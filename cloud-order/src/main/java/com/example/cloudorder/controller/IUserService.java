package com.example.cloudorder.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cloud-user", fallback = IUserServiceHystrix.class)
public interface IUserService {

    @RequestMapping("/")
    String home();
}
