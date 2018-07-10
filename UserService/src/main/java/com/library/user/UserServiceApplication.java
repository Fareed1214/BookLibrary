package com.library.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication//(scanBasePackages = "com.library.user.*")
@RestController
public class UserServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@RequestMapping("/hello")
	public String hello()
	{
		return "Hello World";
	}
}
