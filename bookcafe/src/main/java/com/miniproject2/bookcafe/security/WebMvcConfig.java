package com.miniproject2.bookcafe.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                //클라이언트 로컬 주소 / 일단 전체 허용
                .allowedMethods("*") // 클라이언트에서 요청하는 허용 메소드 / 일단 전체 허용
                .allowCredentials(true);
    }
}