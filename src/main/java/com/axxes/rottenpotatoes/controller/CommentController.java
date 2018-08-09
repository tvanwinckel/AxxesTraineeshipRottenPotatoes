package com.axxes.rottenpotatoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @PostMapping
    public ModelAndView addComment() {
        return new ModelAndView();
    }
}
