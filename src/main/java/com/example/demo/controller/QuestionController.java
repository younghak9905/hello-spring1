package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class QuestionController {




    @GetMapping(value = "/questions/new")
    public String question() {
        return "/questions/write";
    }
    @PostMapping("/questions/new")
    public String create(AskForm form) {
        return "/questions/write";
    }
}
