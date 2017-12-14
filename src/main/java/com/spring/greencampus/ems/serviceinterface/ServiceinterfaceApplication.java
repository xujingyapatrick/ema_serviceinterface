package com.spring.greencampus.ems.serviceinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication

public class ServiceinterfaceApplication {
	public static void main(String[] args) {

		SpringApplication.run(ServiceinterfaceApplication.class, args);
	}
}
