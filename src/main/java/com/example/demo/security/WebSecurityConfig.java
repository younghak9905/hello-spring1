package com.example.demo.security;
import com.example.demo.service.MemberDetailsService;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final AuthenticationFailureHandler userLoginFailHandler;
    private final MemberService memberService;



    @Bean
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.csrf().disable()//CSRF 공격에 대한 방어 해제 -> 기본적으로 탑재
                .authorizeRequests()//요청에 대한 사용권한 체크 URI에 따른 페이지에 대한 권한을 부여하기 위해 시작하는 메소드
                .antMatchers("/user/**").authenticated()//인증된 사용자만 접근 가능
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")//권한이 ROLE_ADMIN인 사용자만 접근 가능
                .anyRequest().permitAll()
                .and()
                .formLogin()//form 기반의 인증을 지원하는 필터를 추가
                .loginPage("/login")
                .loginProcessingUrl("/loginProc")//로그인 처리를 담당하는 URL formlogin의 자동로그인 방식을 이용
                    .usernameParameter("id")
                    .passwordParameter("password")

                    .permitAll()//로그인 페이지에서 사용자가 입력한 아이디의 파라미터명

                .failureHandler(userLoginFailHandler)
                .defaultSuccessUrl("/")//로그인을 성공했을 때의 페이지
                .and()
                .httpBasic()
                .and()
                .build();

        // configure HTTP security...

    }
}
