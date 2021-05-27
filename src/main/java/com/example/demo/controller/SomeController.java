package com.example.demo.controller;

import com.example.demo.service.TokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.jwt.JwtUtil.USER_NAME;

@RestController
public class SomeController {

    private final TokenService tokenService;

    public SomeController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestHeader(value = USER_NAME) String userName) {
        // userName 是 从 request的 header中获得的
        return "hello " + userName + "!";
    }

    @GetMapping("/token")
    public String getToken(@RequestParam(value = "username", defaultValue = "user") String userName) {
        return tokenService.generateToken(userName);
    }
}
