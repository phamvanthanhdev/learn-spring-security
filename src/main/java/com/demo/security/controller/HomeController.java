package com.demo.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    private String home() {
        return "Home page";
    }

    @GetMapping("/welcome")
    private String welcome() {
        return "Welcome to my website";
    }
}
