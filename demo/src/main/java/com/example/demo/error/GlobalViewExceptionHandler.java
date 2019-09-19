package com.example.demo.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalViewExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",req.getRequestURI());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }


}
