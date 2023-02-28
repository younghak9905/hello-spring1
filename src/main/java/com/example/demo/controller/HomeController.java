package com.example.demo.controller;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.repository.AskRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.AskService;
import com.example.demo.service.CommentService;

import com.example.demo.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private final LoginService loginService;







    @GetMapping("/")
    public String home(Model model ) {

        List<Member> members = memberRepository.findAll();
        int answerCount = 0;
        int score = 0;
        int askCount = 0;
        Member answerKings = null;
        Member askKings = null;
        for (Member m : members) {
            int MemberScore = Math.toIntExact(m.getScore());
            if (score < MemberScore) {
                score = MemberScore;
                answerKings = m;
            }
        }
        if (answerKings != null) {
            model.addAttribute("answerKings", answerKings);
        }

        for (Member m : members) {
            int MemberAskCount = m.getAsk().size();

            if (MemberAskCount > askCount) {
                askCount = MemberAskCount;
                askKings = m;
            }
        }
        if (askKings != null) {
            model.addAttribute("askKings", askKings);
        }


        model.addAttribute("members", members);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            // authentication 이 존재하면 로그인이 되어있는 상태이므로 home으로 이동



//authentication 이 존재하면 로그인이 되어있는 상태이므로 home으로 이동


            System.out.println("token1: " + authentication.getName());
            System.out.println("token2: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            String id = authentication.getName();
            // token에 저장되어 있는 인증된 사용자의 id 값
            Member LoginMember = loginService.getUserById(id);
            MemberRequestDto LoginuserVo = new MemberRequestDto(LoginMember);
            LoginuserVo.setPassword(null); // password는 보이지 않도록 null로 설정
            model.addAttribute("LoginMember", LoginuserVo);

            return "loginHome";
        }

       return "home";
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

