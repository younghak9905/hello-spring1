package com.example.demo.controller;

import com.example.demo.domain.Comment;
import com.example.demo.dto.CommentRequestDto;
import com.example.demo.dto.CommentResponseDto;
import com.example.demo.repository.AskRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.CommentService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class CommentController {

   @Autowired
    private final CommentService commentService;
    @PostMapping("/questions/{no}/comments")
    public String save(@PathVariable("no") Long no,CommentRequestDto dto) {

        commentService.save(dto,no);
        return "redirect:/questions/{no}";


    }
}

