package com.example.demo.domain;

import com.example.demo.dto.MemberRequestDto;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Member implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String name;
    private String email;
    private String password;

    private String id;

    private String github;

    private String blog;
    private String role;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Ask> ask = Collections.emptyList();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Comment> comment = Collections.emptyList();

    public Member(MemberRequestDto userVo) {
        this.name = userVo.getName();
        this.email = userVo.getEmail();
        this.password = userVo.getPassword();
        this.id = userVo.getId();
        this.github = userVo.getGithub();
        this.blog = userVo.getBlog();
        this.role = userVo.getRole();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.getRole()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
