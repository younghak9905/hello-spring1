package com.example.demo.security;

import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import static org.hibernate.criterion.Restrictions.and;
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig  {

    private final AuthSuccessHandler authSuccessHandler;

    private final AuthFaillerHandler authFaillerHandler;

    private final MemberService memberService;



    @Bean
    public BCryptPasswordEncoder encodePassword(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();//h2-console 사용을 위해 disable


        return http
                .authorizeRequests()//요청에 대한 사용권한 체크 URI에 따른 페이지에 대한 권한을 부여하기 위해 시작하는 메소드
                .antMatchers("/users/**").authenticated()//인증된 사용자만 접근 가능
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")//권한이 ROLE_ADMIN인 사용자만 접근 가능
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/members/login")
                .loginProcessingUrl("/loginProc")
                .usernameParameter("id")
                .passwordParameter("password")
                .permitAll()//모든 사용자 접근 가능
                .successHandler(authSuccessHandler)
                .failureHandler(authFaillerHandler)
                .failureUrl("/members/login/error")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//로그아웃 처리를 위한 URL
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")//
                .permitAll()
                .and()
                .sessionManagement()//
                .maximumSessions(1)//동시 로그인 방지
                .maxSessionsPreventsLogin(false)//기존 세션 만료
                .expiredUrl("/members/login?error=true&exception=Have been attempted to log in to another account")
                .and()
                //.and().rememberMe()//로그인 상태 유지
                //.alwaysRemember(false)//
                //.tokenValiditySeconds(43200)//12시간
                //.rememberMeParameter("remember-me")//로그인 페이지에서 remember-me 파라미터명

                .and()
                .build();
    }
}
