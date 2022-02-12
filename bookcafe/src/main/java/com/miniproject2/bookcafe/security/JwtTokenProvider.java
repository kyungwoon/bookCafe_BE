package com.miniproject2.bookcafe.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import io.jsonwebtoken.Claims;
import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;

public class JwtTokenProvider {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public JwtTokenProvider(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    private String secretKey = "bookcafe";
    private long tokenValidTime = 30 * 60 * 1000L; // 토큰 유효시간 30분 , 프론트쪽과 일치해야 함

    //secretKey를 base64로 인코딩
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    //토큰 생성
    public String createToken(String userPK, String email) {
        Claims claims = Jwts.claims().setSubject(userPK);
        claims.put("id", email); //id가 email이니까?
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + tokenValidTime)) // 이부분 프론트쪽과 일치시켜야 함 통신문제로
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
