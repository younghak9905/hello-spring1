package com.example.demo.controller;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Comment;
import com.example.demo.domain.Member;
import com.example.demo.dto.CommentRequestDto;
import com.example.demo.dto.CommentResponseDto;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.repository.AskRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.CommentService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/questions", method = {RequestMethod.GET, RequestMethod.POST})
public class CommentController {

AskRepository askRepository;
    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    //test writer_no
    private Long writer_no = 1L;
    @PostMapping("/comment/{no}")
    public String save(CommentRequestDto dto,@PathVariable("no") Long no){
    Optional<Member> member =memberRepository.findByNo(writer_no);
    dto.setWriter(member.get());
        commentService.save(dto,no);


        return "redirect:/questions/"+no;
    }



    @PostMapping("/comment/{no}/reply")
    public String reply(CommentRequestDto dto,@PathVariable("no") Long no){
        Optional<Member> member =memberRepository.findByNo(writer_no);
        dto.setWriter(member.get());

        commentService.reply(dto,no);
        return "redirect:/questions/"+no;
    }
//selected only one comment
    @PostMapping("comment/selected/{commentNo}")
    public String selected(@PathVariable("commentNo") Long commentNo){
        Long no = commentService.selected(commentNo);

        return "redirect:/questions/"+no;
    }
//delete parent comment
    @PostMapping("comment/delete/{commentNo}")
    public String delete(@PathVariable("commentNo") Long commentNo){


        Long no = commentService.delete(commentNo);
        return "redirect:/questions/"+no;
    }

    @PostMapping("/comment/edit/{commentNo}")
    public String edit(CommentRequestDto dto,@PathVariable("commentNo") Long commentNo){
        Long no = commentService.edit(commentNo, dto);
        return "redirect:/questions/"+no;
    }

}

