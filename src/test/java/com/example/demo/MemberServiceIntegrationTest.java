package com.example.demo;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
   @Autowired
   MemberService memberService;
   @Autowired
   MemberRepository memberRepository;

    @Test
    void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("0hak11");
        member.setId("you111");
        member.setEmail("yeong@naver.com");
        member.setPassword("1234");
        member.setBlog("https://blog.naver.com/0hak");
        member.setGithub("https://github.com/younghak9905/hello-spring1.git");


        //when
        Long saveNo = memberService.join(MemberRequestDto.builder().build());
        //then

        Member findMember = memberRepository.findByNo(saveNo).get();
        assertThat(member.getId()).isEqualTo(findMember.getId());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();

        member1.setId("you111");
        member1.setEmail("yeong@naver.com");
        member1.setPassword("1234");
        member1.setBlog("https://blog.naver.com/0hak");
        member1.setGithub("https://github.com/younghak9905/hello-spring1.git");

        Member member2 = new Member();

        member2.setId("you111");
        member2.setEmail("yeong@naver.com");
        member2.setPassword("1234");
        member2.setBlog("https://blog.naver.com/0hak");
        member2.setGithub("https://github.com/younghak9905/hello-spring1.git");
        //when
        memberService.join(MemberRequestDto.builder().build());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(MemberRequestDto.builder().build()));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then
    }
}
