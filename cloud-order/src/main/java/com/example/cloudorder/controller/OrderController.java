package com.example.cloudorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private IUserService iUserService;
    @GetMapping("/")
    public String hello() {
        String home = iUserService.home();
        return home;
    }
}
