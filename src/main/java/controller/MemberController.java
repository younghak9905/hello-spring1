package controller;

import org.springframework.beans.factory.annotation.Autowired;
import service.MemberService;

public class MemberController {
    private final MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
