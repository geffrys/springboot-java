package com.geffry.user_service.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/health")
public class Health {
    

    @GetMapping
    public String getHealthStatus() {
        return "OK";
    }
    
}
