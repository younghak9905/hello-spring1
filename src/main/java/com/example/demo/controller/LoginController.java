package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm form) {
        return "login/loginForm";
    }
    @PostMapping("/login")
    public String loginPost(@Validated @ModelAttribute LoginForm form, BindingResult result, HttpServletRequest request, @RequestParam(defaultValue = "/") String redirectURL) {
        if (result.hasErrors()) {
            return "login/loginForm";
        }

        Member member = loginService.login(form.getLoginId(), form.getPassword());
        //login error
        if (member == null) {
            result.reject("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "login/loginForm";
        }
        //success
        HttpSession session=request.getSession();

        session.setAttribute("loginMember", member);

        return "redirect:" + redirectURL;
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        if(session!=null) {
            session.invalidate();
        }
        return "redirect:/";
    }

}
