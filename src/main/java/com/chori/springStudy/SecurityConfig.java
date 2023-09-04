//package com.chori.springStudy;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // CSRF 방지 기능 비활성화
//                .authorizeRequests()
//                .antMatchers("/public/**").permitAll() // 특정 경로에 대한 접근 허용
//                .anyRequest().authenticated(); // 그 외의 요청은 인증이 필요
//
//        return http.build();
//    }
//}
