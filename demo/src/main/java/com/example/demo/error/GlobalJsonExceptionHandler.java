package com.example.demo.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalJsonExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception{
        ErrorInfo<String> error = new ErrorInfo<>();
        error.setMessage(e.getMessage());
        error.setCode(ErrorInfo.ERROR);
        error.setData("Some Data");
        error.setUrl(req.getRequestURI().toString());
        return error;
    }
}
