package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller","com.example.model","com.example.services","com.example.serviceimpl","com.example.dao","com.example.daoimpl","com.example.util","com.example.security"})
@EnableSwagger2
@EntityScan(basePackages={"com.example.*"})
@EnableJpaRepositories(basePackages={"com.example.*"})
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);
	}

}
