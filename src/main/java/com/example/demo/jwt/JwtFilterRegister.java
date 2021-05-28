package com.example.demo.jwt;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.List;

/**
 * 将 JwtAuthenticationFilter 注册到 context 中
 */
@Configuration
public class JwtFilterRegister {
    @Bean
    public FilterRegistrationBean<? extends Filter> jwtFilter() {
        final FilterRegistrationBean<JwtAuthenticationFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new JwtAuthenticationFilter());

        // 设置受到保护的url
        List<String> protectedUrls = Arrays.asList(
                "/hello"
        );
        filter.setUrlPatterns(protectedUrls);

        return filter;
    }
}
