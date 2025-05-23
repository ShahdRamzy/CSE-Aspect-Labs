package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class HomeController {

    @GetMapping("/hello")
    @PreAuthorize("isAuthenticated()") //  Require authentication
    public String hello() {
        // Access principal if needed: Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hello from protected endpoint!";
    }

    @GetMapping("/all") // Example public endpoint
    public String allAccess() {
        return "Public Content.";
    }

}