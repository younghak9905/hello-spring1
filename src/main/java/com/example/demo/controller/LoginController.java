package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.LoginService;
import com.example.demo.service.MemberService;

import lombok.RequiredArgsConstructor;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


@RequiredArgsConstructor
@Controller
public class LoginController {



    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;

    private final MemberService memberService;

    private final LoginService loginService;



    @PostMapping(value="/joinProc")
    public String joinProc(MemberRequestDto dto, Errors errors,Model model) {
       /* if(errors.hasErrors()){
            Map<String,String> validatorResult=memberService.validateHandling(errors);
            for(String key:validatorResult.keySet()){
                model.addAttribute(key,validatorResult.get(key));
            }
            return "/members/join";

        }*/
        try {
            loginService.signup(dto);
        } catch (DuplicateKeyException e) {
            return "redirect:/signup?error_code=-1";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup?error_code=-99";
        }
        return "redirect:/members/login";
    }


    @GetMapping("/user")
    public @ResponseBody String user(Model model) {
        return "user";
    }

    @GetMapping("/members/new")
    public String join(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
            return "/members/join";
        else
            return "redirect:/";
    }

    @GetMapping("/members/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "execption", required = false) String execption,Model model) {
        model.addAttribute("error", error);
        model.addAttribute("execption", execption);
        return "/members/login";
    }


}
