package com.example.demo.controller;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import com.example.demo.dto.AskResponseDto;
import com.example.demo.dto.CommentResponseDto;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.repository.AskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.MemberService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final AskRepository askRepository;

    @Autowired
    public MemberController(MemberService memberService,
                            AskRepository askRepository) {
        this.memberService = memberService;
        this.askRepository = askRepository;
    }

    @GetMapping(value="/new")
    public String createForm() {
        return "/members/createMemberForm";
    }
    @GetMapping(value = "")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "/members/memberList";
    }

    @PostMapping(value ="/new")
    public String create(MemberRequestDto requestDto) {
        memberService.join(requestDto);
        return "redirect:/";
    }

    @GetMapping(value="/memberPage/{no}")
    public String memberPage(@PathVariable Long no, Model model){
        MemberResponseDto member = memberService.findMember(no);

        model.addAttribute("member", member);
        List <AskResponseDto> asks = member.getAsk();
        model.addAttribute("ask", asks);
        List <CommentResponseDto > comments = member.getComments();
        model.addAttribute("comment", comments);

        return "/members/memberPage";
    }


    @GetMapping("/login")
    public String login() {
        return "/members/login";
    }

    @GetMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "/members/login";
    }
    @PostMapping("login/action")
    public String loginAction( String id,
                              String password,
                              Model model) {
        Member member = memberService.login(id, password);
        if (member == null) {
            model.addAttribute("loginError", true);
            System.out.println("로그인 실패");
            return "/members/login";
        }
        System.out.println("로그인 성공");
        return "redirect:/";
    }

}
