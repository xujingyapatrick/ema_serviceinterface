package com.spring.greencampus.ems.serviceinterface.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "zuul-gateway")
@RibbonClient(name = "mainapp")
public interface MainappProxy {
	@GetMapping("/mainapp/ports")
	public ResponseEntity<?> getCurrentPort();
}
