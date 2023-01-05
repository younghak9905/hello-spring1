import domain.Member;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import repository.MemoryMemberRepository;
import service.MemberService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
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
        member2.setId("you1");
        //when
        memberService.join(member1);
        IllegalStateException e = org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }
}
