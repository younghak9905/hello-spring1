package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.MemberRepository;
import repository.MemoryMemberRepository;
import repository.QuestionRepository;
@Configuration
public class Config {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
