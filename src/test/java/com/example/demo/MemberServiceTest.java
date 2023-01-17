package com.example.demo;

import com.example.demo.domain.Member;
import com.example.demo.repository.JpaMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.demo.service.MemberService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    MemberService memberService;
  JpaMemberRepository memberRepository;

/*

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("0hak");
        member.setId("you");
        member.setPassword("1234");
        //when
        Long saveNo = memberService.join(member);
        //then

        Member findMember = memberRepository.findByNo(saveNo).get();
        assertThat(member.getId()).isEqualTo(findMember.getId());
    }
    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setId("you");
        Member member2 = new Member();
        member2.setId("you");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then
    }*/
}
