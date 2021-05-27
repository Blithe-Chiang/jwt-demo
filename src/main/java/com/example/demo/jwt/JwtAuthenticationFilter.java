package com.example.demo.jwt;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            // 如果请求的资源是被保护的url的话，获取 request header中的 authorization。
            if (isProtectedUrl(request)) {
//                System.out.println(request.getMethod());
                if (!request.getMethod().equals("OPTIONS"))
                    // 在 request 的 header 中添加更多的信息
                    request = JwtUtil.validateTokenAndAddUserIdToHeader(request);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        filterChain.doFilter(request, response);
    }

    private boolean isProtectedUrl(HttpServletRequest request) {
        List<String> protectedPaths = new ArrayList<String>();

        // 添加保护路径
        protectedPaths.add("/hello");

        boolean bFind = false;
        for (String passedPath : protectedPaths) {
            bFind = pathMatcher.match(passedPath, request.getServletPath());
            if (bFind) {
                break;
            }
        }
        return bFind;
    }

}