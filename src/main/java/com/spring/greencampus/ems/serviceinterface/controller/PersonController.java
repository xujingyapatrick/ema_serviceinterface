package com.spring.greencampus.ems.serviceinterface.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




@RestController
public class PersonController {
	
	@RequestMapping("/persons")
	public ResponseEntity<?> showPeople(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity("http://localhost:9191/persons", Object.class);
	}
	

}
