package com.example.demo.dto;

import com.example.demo.domain.Member;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MemberResponseDto {
    private Long no;
    private String name;
    private String email;
    private String password;
    private String id;
    private String github;
    private String blog;

    private List<CommentResponseDto> comments;
    private List<AskResponseDto> ask;

    public MemberResponseDto(Member entity) {
        this.no = entity.getNo();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.id = entity.getId();
        this.github = entity.getGithub();
        this.blog = entity.getBlog();

        this.comments = entity.getComment().stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());

        this.ask = entity.getAsk().stream()
                .map(AskResponseDto::new)
                .collect(Collectors.toList());

    }


}
