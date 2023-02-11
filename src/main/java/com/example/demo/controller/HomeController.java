package com.example.demo.controller;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import com.example.demo.repository.AskRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.AskService;
import com.example.demo.service.CommentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final AskService askService;
    private CommentService commentService;
    private final CommentRepository commentRepository;
    private final AskRepository askRepository;
    private final MemberRepository memberRepository;


    @GetMapping("/")
    public String home(@SessionAttribute(name = "member", required = false) String member, Model model) {
        List<Member> members= memberRepository.findAll();
        int answerCount=0;
        int score=0;
        int askCount=0;
        Member answerKings=null;
        Member askKings=null;
        for(Member m:members){
            int MemberScore= Math.toIntExact(m.getScore());
            if(score<MemberScore){
                score=MemberScore;
                answerKings=m;
            }
        }
        if(answerKings!=null)
        {model.addAttribute("answerKings",answerKings);}

        for(Member m:members){
            int MemberAskCount=m.getAsk().size();

            if(MemberAskCount>askCount){
                askCount=MemberAskCount;
                askKings=m;
            }
        }
        if(askKings!=null)
        {model.addAttribute("askKings",askKings);}






        model.addAttribute("members",members);

       return "home";
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

    @GetMapping(value="/questions/tagList")
    public String tagList(Model model,String tags){
        System.out.println("tags = " + tags);
        List<Ask> tagList=askService.findAllByTags(tags);
        model.addAttribute("asks",tagList);
        return "/questions/tagList";}




    @GetMapping("/css")
    public String css() {
        return "css";

    }

}



