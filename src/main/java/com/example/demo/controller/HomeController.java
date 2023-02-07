package com.example.demo.controller;

import com.example.demo.domain.Ask;
import com.example.demo.repository.AskRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController{
private final AskRepository askRepository;

    public HomeController(AskRepository askRepository) {
        this.askRepository = askRepository;
    }


    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @RequestMapping("/jsp")
    public String home_jsp() {
        return "index";
    }

@PostMapping("/search")
    public String search (String search, Model model) {
    List<Ask> title = askRepository.findByTitleContaining(search);
    List<Ask> content = askRepository.findByContentsContaining(search);
    if (search != null) {
        model.addAttribute("title", title);
        model.addAttribute("content", content);
}
        return "questions/searchList";
    }





}
