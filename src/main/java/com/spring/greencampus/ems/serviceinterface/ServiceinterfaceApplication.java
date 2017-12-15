package com.spring.greencampus.ems.serviceinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;

import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
@EnableFeignClients("com.spring.greencampus.ems.serviceinterface.feignclient")
@EnableDiscoveryClient
public class ServiceinterfaceApplication {
	public static void main(String[] args) {

		SpringApplication.run(ServiceinterfaceApplication.class, args);
	}
	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
