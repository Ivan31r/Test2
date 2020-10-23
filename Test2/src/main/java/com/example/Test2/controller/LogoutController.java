package com.example.Test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("/api/logout")
    public String toLoginPage() {
        return "logout";
    }
}
