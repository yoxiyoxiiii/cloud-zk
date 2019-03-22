package com.example.cloudzkconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@SpringBootApplication
public class CloudZkConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudZkConfigApplication.class, args);
	}


	@Value("${dev}")
	private String dev;

	@GetMapping("dev")
	public String dev() {
		return dev;
	}

}
