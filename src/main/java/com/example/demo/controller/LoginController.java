package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
public class LoginController {



    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;

    private final MemberService memberService;

    private final UserService userService;
    @GetMapping("/")
    public String home(Model model) { // 인증된 사용자의 정보를 보여줌
        // 인증된 사용자의 정보를 가져옴 로그인한 상태가 아니라면 loginhome을 반환
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "loginhome";
        }



        System.out.println("token: "+authentication.getName());
        System.out.println("token: "+authentication);
        String id=authentication.getName();
        // token에 저장되어 있는 인증된 사용자의 id 값
        Member member =userService.getUserById(id);
        MemberRequestDto userVo = new MemberRequestDto(member);
        userVo.setPassword(null); // password는 보이지 않도록 null로 설정
        model.addAttribute("user", userVo);
        return "home";
    }


    @PostMapping(value="/joinProc")
    public String joinProc(MemberRequestDto dto) {

        try {
            userService.signup(dto);
        } catch (DuplicateKeyException e) {
            return "redirect:/signup?error_code=-1";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup?error_code=-99";
        }
        return "redirect:/login";
    }


    @GetMapping("/user")
    public @ResponseBody String user(Model model) {
        return "user";
    }

    @GetMapping("/join")
    public String join(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
             return "/login/join";
        else
            return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "execption", required = false) String execption,Model model) {
        model.addAttribute("error", error);
        model.addAttribute("execption", execption);
        return "/login/login";
    }

    @PostMapping("/update")
    public String edit(MemberRequestDto userVo) { // 회원 정보 수정

        return "redirect:/";
    }

    @GetMapping("/update")
    public String editPage(Model model) { // 회원 정보 수정 페이지
        Long no = (Long)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = userService.getUserByNo(no);
        model.addAttribute("user", member);
        return "editPage";
    }

    @PostMapping("/delete")
    public String withdraw(HttpSession session) { // 회원 탈퇴
       Long no = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (no != null) {
            userService.withdraw(no);
        }
        SecurityContextHolder.clearContext(); // SecurityContextHolder에 남아있는 token 삭제
        return "redirect:/";
    }
}
