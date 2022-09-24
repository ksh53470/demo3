package com.example.demo3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo3.exception.IdNotFoundException;
import com.example.demo3.exception.PwMissMatchException;
import com.example.demo3.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AuthController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/login/form")
    public ModelAndView loginForm() {
        ModelAndView mv=new ModelAndView("/loginForm");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(
            HttpServletRequest request,
            @RequestParam String id,
            @RequestParam String pw) {
        log.info("============== /login =================");
        String view="redirect:" + request.getContextPath() + "/member/list";
        try {
            memberService.login(id, pw);
            HttpSession session = request.getSession();
            session.setAttribute("id",id);

        }catch(IdNotFoundException | PwMissMatchException e) {
            view="redirect:" + request.getContextPath() + "/login/form";
        }
        return new ModelAndView(view);
    }
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        log.info("============== /logout =================");
        HttpSession session = request.getSession();
        session.invalidate(); // 세션종료
        return new ModelAndView("redirect:" + request.getContextPath() + "/login/form");
    }
}

