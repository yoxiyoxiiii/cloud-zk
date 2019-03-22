package com.example.cloudorder.controller;

import org.springframework.stereotype.Component;

@Component
public class IUserServiceHystrix implements IUserService {
    @Override
    public String home() {
        return "熔断超时返回!";
    }
}
