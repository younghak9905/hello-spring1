package com.example.demo.dto;

import com.example.demo.domain.Member;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MemberResponseDto {
    private Long no;

    private String name;
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;
    private String id;
    private String github;
    private String blog;
    private String role;

private Long score;
    private List<CommentResponseDto> comments;
    private List<AskResponseDto> ask;

    private List<ImageResponseDto> image;

    public MemberResponseDto(Member entity) {
        this.no = entity.getNo();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.id= entity.getId();
        this.github = entity.getGithub();
        this.blog = entity.getBlog();
        this.role = entity.getRole();
        this.score=entity.getScore();


        this.comments = entity.getComment().stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());

        this.ask = entity.getAsk().stream()
                .map(AskResponseDto::new)
                .collect(Collectors.toList());

        this.image=entity.getImage().stream()
                .map(ImageResponseDto::new)
                .collect(Collectors.toList());

    }
}
