package com.example.demo3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class MainController {
    @RequestMapping("/")
    public ModelAndView main() {
        log.info("========================== MemberController(/main) ==================================");
        ModelAndView mv=new ModelAndView("/main");
        return mv;
    }
}
