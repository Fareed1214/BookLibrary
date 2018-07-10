package com.library.data;

import com.library.data.bo.BookInfo;
import com.library.data.controller.LibraryController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.library.data.*"})
@EnableAutoConfiguration
public class DataServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DataServiceApplication.class, args);
	}
}
