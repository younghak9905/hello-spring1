package com.example.demo.controller;

import com.example.demo.domain.Image;
import com.example.demo.domain.Member;
import com.example.demo.dto.*;
import com.example.demo.repository.AskRepository;

import com.example.demo.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.MemberService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;
    private final AskRepository askRepository;

private final LoginService loginService;

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "/members/memberList";
    }

   /* @PostMapping(value ="/members/new")
    public String create(MemberRequestDto requestDto) {
        requestDto.setScore(0L);
        memberService.join(requestDto);
        return "redirect:/";
    }*/

    @GetMapping(value="/members/memberPage/{no}")
    public String memberPage(@PathVariable Long no, Model model){
        MemberResponseDto member = memberService.findMember(no);

        model.addAttribute("member", member);
        List <AskResponseDto> asks = member.getAsk();
        model.addAttribute("ask", asks);
        List <CommentResponseDto > comments = member.getComments();

        model.addAttribute("comment", comments);
        member.getScore();

        return "/members/memberPage";
    }

    @PostMapping("/update")
    public String edit(MemberRequestDto userVo) { // 회원 정보 수정

        return "redirect:/";
    }

    @GetMapping("/update")
    public String editPage(Model model) { // 회원 정보 수정 페이지
        Long no = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = loginService.getUserByNo(no);
        model.addAttribute("user", member);
        return "editPage";
    }

    @PostMapping("/delete")
    public String withdraw(HttpSession session) { // 회원 탈퇴

        Long no = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (no != null) {
            loginService.withdraw(no);
        }
        SecurityContextHolder.clearContext(); // SecurityContextHolder에 남아있는 token 삭제
        return "redirect:/";
    }







/*    @PostMapping("/image")
    public String imageUpload(ImageUploadDto imageUploadDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        if(imageUploadDto.getFile().isEmpty()) {

        }
        imageService.upload(imageUploadDto, principalDetails);

        return "redirect:/user/" + principalDetails.getUser().getId();
    }*/

}
