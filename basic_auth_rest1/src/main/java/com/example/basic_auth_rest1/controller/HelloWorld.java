package com.example.basic_auth_rest1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/hello-world")
public class HelloWorld {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/")
    public String getDefault() {
        return "default_helloworld";
    }

    @GetMapping("/whoami")
    public String getWhoAmI() {
        return "hello unknown person!";
    }

    @GetMapping("/redirectTest")
    public void getARedirect(HttpServletResponse response) throws IOException {

        String url = request.getContextPath() + "/hello-world/whoami";



        response.sendRedirect(url);
    }
}
