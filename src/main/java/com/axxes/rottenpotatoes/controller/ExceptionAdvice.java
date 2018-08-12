package com.axxes.rottenpotatoes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = "com.axxes.rottenpotatoes.controller")
public class ExceptionAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(final Exception e) {
        LOGGER.error("Exception caught: " + e);
        return new ModelAndView("error");
    }
}
