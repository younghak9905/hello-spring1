package com.example.demo.controller;

import com.example.demo.domain.Ask;
import com.example.demo.repository.AskRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.AskService;
import com.example.demo.service.CommentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.List;

@Controller
public class HomeController{



    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @RequestMapping("/jsp")
    public String home_jsp() {
        return "index";
    }




}
