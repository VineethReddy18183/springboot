package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(ConfigApplication.class, args);

		Samsung samsung = (Samsung) context.getBean("samsung");
		System.out.println(samsung.getAppName());

	}

}
