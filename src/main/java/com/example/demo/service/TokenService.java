package com.example.demo.service;


import com.example.demo.jwt.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String generateToken(String userId) {
        return JwtUtil.generateToken(userId);
    }

}
