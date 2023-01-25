package com.example.demo.controller;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Comment;
import com.example.demo.dto.AskRequestDto;
import com.example.demo.dto.AskResponseDto;
import com.example.demo.dto.CommentResponseDto;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.AskService;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/questions", method = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class QuestionController {
    private final AskService askService;
    private final CommentService commentService;
    private final CommentRepository commentRepository;


    @GetMapping(value = "/new")
    public String createForm() {
        return "/questions/write";
    }
    @PostMapping(value="/new/questionList")
    public String create(AskRequestDto requestDto) {
        askService.write(requestDto);
       return "redirect:/questions/questionList";
    }

    @GetMapping(value="/questionList")
    public String list(Model model) {
        List<Ask> asks = askService.findAsks();
        model.addAttribute("asks", asks);
        return "/questions/questionList";
    }
    @GetMapping(value="/{no}")
    public String detail(Model model , @PathVariable("no") Long no) {
        AskResponseDto ask = askService.findAsk(no);
        List<CommentResponseDto> comments = ask.getComments();
        List<CommentResponseDto> reply = ask.getComments();


      if(comments!=null && !comments.isEmpty()) {
          model.addAttribute("comment", comments);
          //comments.depth가 1 이상인 것만 뽑아서 보내기

            if(reply!=null && !reply.isEmpty()) {
                model.addAttribute("reply",reply);
            }


      }



      model.addAttribute("asks",ask);

      return "questions/view";
    }
    @GetMapping(value="/{no}/edit")
    public String editForm(Model model, @PathVariable("no") Long no) {
        Ask ask = askService.findOne(no).get();
        model.addAttribute("ask", ask);
        return "/questions/edit";
    }

}
