package com.spring.greencampus.ems.serviceinterface.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




@RestController
public class PersonController {
//	private Logger logger = LoggerFactory.getLogger(PersonController.class);
	@RequestMapping("/persons")
//	@Cacheable("showPeople")
	public ResponseEntity<?> showPeople(){
		RestTemplate restTemplate = new RestTemplate();
//		logger.info("ShowPeople Called Once!!!!!");
		return restTemplate.getForEntity("http://localhost:9191/persons", Object.class);
	}

	@Cacheable("showPeopleDummy")
	@RequestMapping("/personsdummy")
	public Object showPeopleDummy(){
		RestTemplate restTemplate = new RestTemplate();
//		logger.info("ShowPeople Called Once!!!!!");
		return restTemplate.getForEntity("http://localhost:9191/sensordata", Object.class).getBody();
	}
	
	

}
