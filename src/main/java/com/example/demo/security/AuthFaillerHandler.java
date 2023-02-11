package com.example.demo.security;

import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFaillerHandler extends SimpleUrlAuthenticationFailureHandler {


   @Override
public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
        throws IOException, ServletException {
String msg="invalid id or password";
    if (exception instanceof DisabledException) {
        msg = "DisabledException account";
    } else if (exception instanceof BadCredentialsException) {
        msg = "BadCredentialsException";


    } else if (exception instanceof CredentialsExpiredException) {
        msg = "CredentialsExpiredException account";
    }


    setDefaultFailureUrl("/login?error=true&exception=" + msg);
    super.onAuthenticationFailure(request, response, exception);

}

}
