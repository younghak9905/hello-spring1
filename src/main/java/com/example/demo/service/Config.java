package com.example.demo.service;


import com.example.demo.repository.CommentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.AskRepository;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Configuration
public class Config {

    private final MemberRepository memberRepository;
    private final AskRepository askRepository;
  private final CommentRepository commentRepository;
   public Config(MemberRepository memberRepository, AskRepository askRepository, CommentRepository commentRepository) {
        this.memberRepository = memberRepository;
        this.askRepository = askRepository;
        this.commentRepository = commentRepository;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8"); // 파일 인코딩 설정
        multipartResolver.setMaxUploadSizePerFile(50 * 1024 * 1024); // 파일당 업로드 크기 제한 (50MB)
        return multipartResolver;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public AskService askService() {

        return new AskService(askRepository);
    }

    @Bean
    public CommentService commentService() {

        return new CommentService(commentRepository, askRepository);
    }



}




