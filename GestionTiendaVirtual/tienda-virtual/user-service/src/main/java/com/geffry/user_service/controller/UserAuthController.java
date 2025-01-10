package com.geffry.user_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserAuthController {
    @PostMapping("/register")
    public void userRegister() {

    }

    @PostMapping("/login")
    public void userLogin() {

    }
    
}
