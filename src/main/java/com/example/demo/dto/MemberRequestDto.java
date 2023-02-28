package com.example.demo.dto;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor//모든 필드를 파라미터로 받는 생성자를 만들어줌
@NoArgsConstructor
@Builder
public class MemberRequestDto {
    @NotBlank(message = "이름을 입력해주세요.")
    private String name;
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{4,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    private String passwordConfirm;
    @NotBlank(message = "아이디는 필수 입력값 입니다.")
    private String id;
    private String github;
    private String blog;

    private String role;
    private Long score;


    public MemberRequestDto(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.id = member.getId();
        this.github = member.getGithub();
        this.blog = member.getBlog();
        this.role = member.getRole();
        this.score=member.getScore();

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

    }


}
