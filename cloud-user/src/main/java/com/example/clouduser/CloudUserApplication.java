package com.example.clouduser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * zk 作为注册中心
 * 服务发现
 */
@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class CloudUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudUserApplication.class, args);
	}

	@RequestMapping("/")
	public String home() throws InterruptedException {
		Random random = new Random();
		int nextInt = random.nextInt(5000);
		Thread.sleep(nextInt);
		return "Hello world";
	}

	/**
	 * 获取注册列表
	 */
	@Autowired
	private DiscoveryClient discoveryClient;
	@GetMapping("/services")
	public List<String> serviceUrl() {
		List<ServiceInstance> list = discoveryClient.getInstances("cloud-user");
		List<String> services = new ArrayList<>();
		if (list != null && list.size() > 0 ) {
			list.forEach(serviceInstance -> {
				services.add(serviceInstance.getServiceId().toString());
			});
		}
		return services;
	}

}
