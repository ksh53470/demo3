package com.example.demo3.controller;

import java.util.List;

import com.example.demo3.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo3.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j // Simple Logging Facade for Java

public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/")
    public ModelAndView main() {
        log.info("========================== MemberController(/main) ==================================");
        ModelAndView mv=new ModelAndView("/main");
        return mv;
    }

    @RequestMapping("/member/register-form")
    public ModelAndView registerform() {
        log.info("========================== MemberController(/registerform) ==================================");
        ModelAndView mv=new ModelAndView("/member/register-form");
        return mv;
    }

    @RequestMapping("/member/register")
    public String registerMember(MemberDTO dto) {
        log.info("========================== MemberController(/registerMember) ==================================");
        memberService.registerMember(dto);
        return "redirect:/member/list";
    }

    @GetMapping("/member/login")
    public String login(){
        return "member/login";
    }

    @PostMapping("/member/login")
    public String loginplus(
            @RequestParam String id,
            @RequestParam String pw,
            HttpServletRequest request

    ){

        MemberDTO dto = memberService.findMemberDetail(id);
        System.out.println(dto);

        if(dto.getPw().equals(pw)){
            HttpSession session = (HttpSession)request.getSession();
            session.setAttribute("userid", id);
            return "redirect:/member/list";
        }
        else {
            return null;
        }
    }

    @RequestMapping("/member/list")
    public ModelAndView memberList() {
        log.info("========================== MemberController(/member/list) ==================================");
        ModelAndView mv=new ModelAndView("/member/list");
        List<MemberDTO> list=memberService.findMemberList();
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/member/detail")
    public ModelAndView memberDetail(
            @RequestParam String id
    ) {
        log.info("========================== MemberController(/member/detail) ==================================");
        ModelAndView mv=new ModelAndView("/member/detail");
        MemberDTO member =memberService.findMemberDetail(id);
        mv.addObject("member", member);
        return mv;
    }
    @GetMapping("/member/update")
    public ModelAndView update(@RequestParam String id) {
        log.info("========================== MemberController(/member/detail) ==================================");
        ModelAndView mv = new ModelAndView("/member/update");
        MemberDTO member =memberService.findMemberDetail(id);
        mv.addObject("member", member);
        return mv;
    }

    @PostMapping("/member/update")
    public String updateMember(
            MemberDTO dto
    ) {
        log.info("========================== MemberController(/member/update) ==================================");

        System.out.println(dto);
        memberService.modifyMember(dto);
        System.out.println(dto.getPw());
        return "redirect:/member/list";
    }

    @RequestMapping("/member/delete")
    public String deleteMember(@RequestParam String id) {
        log.info("========================== MemberController(/member/delete) ==================================");
        memberService.removeMember(id);
        return "redirect:/member/list";
    }

    @GetMapping("/member/join")
    public String join() {
        log.info("========================== MemberController(/member/join) ==================================");
        return "member/join";
    }
    @PostMapping("/member/join")
    public String joinMember(
            @RequestParam String id,
            @RequestParam String pw,
            @RequestParam String addr,
            @RequestParam String tel,
            MemberDTO dto
    ) {
        log.info("========================== MemberController(/member/joinMember) ==================================");
        dto.setId(id);
        dto.setPw(pw);
        dto.setAddr(addr);
        dto.setTel(tel);
        memberService.registerMember(dto);
        return "redirect:/member/login";
    }
}
