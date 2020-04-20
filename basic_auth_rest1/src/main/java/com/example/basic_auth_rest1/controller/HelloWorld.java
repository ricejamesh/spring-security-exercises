package com.example.basic_auth_rest1.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorld {

    @GetMapping("/")
    public String getDefault() {
        return "default_helloworld";
    }

    @GetMapping("/whoami")
    public String getWhoAmI() {
        return "hello unknown person!";
    }
}
