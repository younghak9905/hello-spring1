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
    private Long no;
    private String name;
    private String email;
    private String password;
    private String passwordConfirm;
    private String id;
    private String github;
    private String blog;


    public Member toEntity() {
        Member member =Member.builder()
                .no(no)
                .name(name)
                .email(email)
                .password(password)
                .id(id)
                .github(github)
                .blog(blog)
                .build();
        return member;

}}
