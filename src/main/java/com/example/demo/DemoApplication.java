package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller","com.example.dto","com.example.services","com.example.serviceimpl","com.example.dao","com.example.daoimpl"})
public class DemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);
	}

}
