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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @PostMapping("/comment/{no}")
    public String save(CommentRequestDto dto,@PathVariable("no") Long no){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();
        if(!id.equals("anonymousUser")) {

            Member loginMember = memberRepository.findById(id);
            dto.setWriter(loginMember);
            commentService.save(dto, no);
            return "redirect:/questions/" + no;
        }
        return "redirect:/members/login";
    }



    @PostMapping("/comment/{no}/reply")
    public String reply(CommentRequestDto dto,@PathVariable("no") Long no){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();
        if(!id.equals("anonymousUser"))
        {
            Member loginMember=memberRepository.findById(id);
            dto.setWriter(loginMember);
            commentService.reply(dto,no);
            return "redirect:/questions/"+no;
        }


      return "redirect:/members/login";
    }
//selected only one comment
    @PostMapping("comment/selected/{commentNo}")
    public String selected(@PathVariable("commentNo") Long commentNo){
       Comment comment=commentRepository.findByCommentNo(commentNo).get();
        Ask ask=comment.getAsk();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();
        if(!id.equals("anonymousUser"))
        {
            Member loginMember=memberRepository.findById(id);

            if(ask.getMember().getNo()==loginMember.getNo())
            {
                Long askNo = commentService.selected(commentNo);
                return "redirect:/questions/"+askNo;
            }
            return  "redirect:/questions/"+comment.getAsk().getNo();
        }

        return "redirect:/members/login";
    }
//delete parent comment
    @PostMapping("comment/delete/{commentNo}")
    public String delete(@PathVariable("commentNo") Long commentNo){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();
        if(!id.equals("anonymousUser"))
        {
            Member loginMember=memberRepository.findById(id);
           Comment comment=commentRepository.findByCommentNo(commentNo).get();
           if(comment.getWriter().getNo()==loginMember.getNo())
           {
               Long no = commentService.delete(commentNo);
               return "redirect:/questions/"+no;
           }
           return  "redirect:/questions/"+comment.getAsk().getNo();
        }


        return "redirect:/members/login";


    }

    @PostMapping("/comment/edit/{commentNo}")
    public String edit(CommentRequestDto dto,@PathVariable("commentNo") Long commentNo){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();
        if(!id.equals("anonymousUser")) {
            Member loginMember=memberRepository.findById(id);

            if(dto.getWriter().getNo()==loginMember.getNo())
            {
                Long no = commentService.edit(commentNo,dto);
                return "redirect:/questions/"+no;
            }
        }

        return "redirect:/members/login";
    }

}

