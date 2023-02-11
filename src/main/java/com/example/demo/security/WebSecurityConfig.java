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

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import static org.hibernate.criterion.Restrictions.and;
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthSuccessHandler authSuccessHandler;

    private final AuthFaillerHandler authFaillerHandler;

    private final MemberService memberService;



    @Bean
    public BCryptPasswordEncoder encodePassword(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();



        http
                .authorizeRequests()//요청에 대한 사용권한 체크 URI에 따른 페이지에 대한 권한을 부여하기 위해 시작하는 메소드
               .antMatchers("/user/").authenticated()//인증된 사용자만 접근 가능
               .antMatchers("/admin/").access("hasRole('ROLE_ADMIN')")//권한이 ROLE_ADMIN인 사용자만 접근 가능
               .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/members/login")
                .loginProcessingUrl("/members/login/action")
                .successHandler(authSuccessHandler)
                .failureHandler(authFaillerHandler)
                .failureUrl("/members/login/error")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/members/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .logoutSuccessUrl("/members/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID","remember-me")
                .permitAll()
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                .expiredUrl("/members/login?error=true&exception=Have been attempted to log in to another account")
                .and()
                .and().rememberMe()
                .alwaysRemember(false)
                .tokenValiditySeconds(43200)
                .rememberMeParameter("remember-me");

    }
}
