package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

@Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value="/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @GetMapping(value = "")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @PostMapping(value ="/new")
    public String create(MemberRequestDto requestDto) {
        memberService.join(requestDto);
        return "redirect:/";
    }
}
