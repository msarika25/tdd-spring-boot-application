package com.demo.tdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TDDDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TDDDemoApplication.class, args);
	}
}
