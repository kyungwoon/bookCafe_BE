package com.miniproject2.bookcafe.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 헤더에서 JWT를 받아옴
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
        // 클라이언트에서 받은 token값을 서버 콘솔에 찍어보자
        System.out.println(token);

        // 유효한 토큰인지 확인, / validateToken이 true라면
        if (token != null && jwtTokenProvider.validateToken(token)) {
            // 토큰이 유효하다면 회원 정보를  authentication에 받아온다.
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            // SecurityContext 에 authentication 객체를 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}
