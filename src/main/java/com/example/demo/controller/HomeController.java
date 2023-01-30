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
@RequiredArgsConstructor
@Controller
public class HomeController{

    private final AskService askService;
    private CommentService commentService;
    private final CommentRepository commentRepository;
    private final AskRepository askRepository;


    @GetMapping("/")
    public String home(@SessionAttribute(name = "member", required = false) String member, Model model) {
       if(member==null) {
          return "home";
       }
        model.addAttribute("member", member);
        return "loginhome";
    }

    @RequestMapping("/jsp")
    public String home_jsp() {
        return "index";
    }

    @PostMapping("/search")
    public String search( Model model,String search) {

        System.out.println("search = " + search);
        if(search!=null) {
            List<Ask> searchList = askRepository.findByTitleContaining(search);
            model.addAttribute("ask", searchList);

            List<Ask> searchContent = askRepository.findByContentsContaining(search);
            model.addAttribute("content", searchContent);
        }


        return "/questions/searchList";
    }

    }



