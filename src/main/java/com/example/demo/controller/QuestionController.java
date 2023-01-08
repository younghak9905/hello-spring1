package com.example.demo.controller;

import com.example.demo.domain.Ask;
import com.example.demo.service.AskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class QuestionController {
    private final AskService askService;

    @Autowired
    private QuestionController(AskService askService) {
        this.askService = askService;
    }



    @GetMapping(value = "/questions/new")
    public String question() {
        return "/questions/write";
    }
    @PostMapping("/questions/new")
    public String create(AskForm form) {
        Ask ask = new Ask();
        ask.setTitle(form.getTitle());
        ask.setContents(form.getContents());
        //ask.setWriterNo(form.getWriterNo());
        ask.setTags(form.getTags());

        return "redirect:/questions";
    }
    @GetMapping("/questions")
    public String list(Model model) {
        List<Ask> asks = askService.findAsks();
        model.addAttribute("asks", asks);
        return "/questions/questionList";
    }

}
