package com.ohrim.spring.http.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.ohrim.spring.http.rest")
@RestControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

}
