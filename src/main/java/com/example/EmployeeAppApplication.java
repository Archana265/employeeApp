package com.example;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EmployeeAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EmployeeAppApplication.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();

		Arrays.sort(beanNames);

		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
	 @RequestMapping("/greeting")
	     public String greeting() {
		 return "Hello from EurekaClient!";
	 }

}
