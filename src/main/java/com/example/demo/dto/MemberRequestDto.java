package com.example.demo.dto;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequestDto {
    private String name;
    private String email;
    private String password;
    private String passwordConfirm;
    private String id;
    private String github;
    private String blog;

    private String role;

    public MemberRequestDto(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.id = member.getId();
        this.github = member.getGithub();
        this.blog = member.getBlog();
        this.role = member.getRole();
    }


    public Member toEntity() {
        Member member =Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .id(id)
                .github(github)
                .blog(blog)
                .role(role)
                .build();
        return member;

}}
