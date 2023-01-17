package com.example.demo.dto;

import com.example.demo.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long no;
    private String name;
    private String email;
    private String password;
    private String id;
    private String github;
    private String blog;

    public MemberResponseDto(Member entity) {
        this.no = entity.getNo();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.id = entity.getId();
        this.github = entity.getGithub();
        this.blog = entity.getBlog();
    }
}
