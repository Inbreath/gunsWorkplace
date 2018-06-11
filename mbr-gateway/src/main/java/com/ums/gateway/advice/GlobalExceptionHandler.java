package com.ums.gateway.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public String exception(Exception e, WebRequest webRequest) {
        e.printStackTrace();
        return "出现异常了，在本类处理" + e.getLocalizedMessage();
    }
}
