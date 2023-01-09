package com.example.demo.controller;

import com.example.demo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.service.MemberService;

import java.util.List;
@Controller
public class MemberController {
    private final MemberService memberService;

@Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value="/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @PostMapping(value ="members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setId(form.getId());
        member.setGitHub(form.getGitHub());
        member.setBlog(form.getBlog());
        memberService.join(member);
        return "redirect:/";
    }
}