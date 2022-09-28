package com.example.demo3.aop;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DataAccessException.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, DataAccessException e) {
        ModelAndView mv = new ModelAndView("/error");

        mv.addObject("errorCode", -2);
        mv.addObject("errorMsg", e.getMessage());
        System.out.println("#####################DataAccessException###################1");

        log.error("Request: " + request.getRequestURL() +"\n"+ " raised " + e);
        return mv;
    }
}