package com.example.demo.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.AskRepository;

@Configuration
public class Config {
    /*
    private final EntityManager em;
    private final DataSource dataSource;

    public Config(EntityManager em, DataSource dataSource) {
        this.em = em;
        this.dataSource = dataSource;

    }*/
    private final MemberRepository memberRepository;
    private final AskRepository askRepository;
    public Config(MemberRepository memberRepository, AskRepository askRepository) {
        this.memberRepository = memberRepository;
        this.askRepository = askRepository;
    }


@Bean
public MemberService memberService() {
    return new MemberService(memberRepository);
}

@Bean
public AskService askService() {
    return new AskService(askRepository);
}
}
