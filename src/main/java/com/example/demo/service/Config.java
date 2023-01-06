package com.example.demo.service;

import com.example.demo.repository.JpaMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class Config {
    private final EntityManager em;
    private final DataSource dataSource;
    public Config(EntityManager em, DataSource dataSource) {
        this.em = em;
        this.dataSource = dataSource;

    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

}
