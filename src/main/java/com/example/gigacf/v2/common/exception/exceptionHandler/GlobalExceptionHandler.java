package com.example.gigacf.v2.common.exception.exceptionHandler;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j2;

/*예외 클로벌 처리
 * 
 * */
@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String handleDataAccessException(EmptyResultDataAccessException e, Model model) {
        log.error("Global EmptyResultDataAccessException occurred", e);
        model.addAttribute("error", e.getMessage());
        return "/v2/comm/ErrorPage";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException e, Model model) {
        log.error("Global NullPointerException occurred", e);
        model.addAttribute("error", e.getMessage());
        return "/v2/comm/ErrorPage";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        log.error("Global Exception occurred", e);
        model.addAttribute("error", e.getMessage());
        return "/v2/comm/ErrorPage";
    }
}