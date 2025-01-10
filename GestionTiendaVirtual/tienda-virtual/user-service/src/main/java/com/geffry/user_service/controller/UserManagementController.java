package com.geffry.user_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/user")
public class UserManagementController {
    @GetMapping()
    public void getMethodName() {

    }
    
}
