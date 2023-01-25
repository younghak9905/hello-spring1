package com.example.demo.controller;

import com.example.demo.domain.Ask;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/questions", method = {RequestMethod.GET, RequestMethod.POST})
public class CommentController {

AskRepository askRepository;
    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @PostMapping("/comment/{no}")
    public String save(CommentRequestDto dto,@PathVariable("no") Long no){

        commentService.save(dto,no);


        return "redirect:/questions/"+no;
    }



    @PostMapping("/comment/{no}/reply")
    public String reply(CommentRequestDto dto,@PathVariable("no") Long no){
        commentService.reply(dto,no);
        return "redirect:/questions/"+no;
    }

}

