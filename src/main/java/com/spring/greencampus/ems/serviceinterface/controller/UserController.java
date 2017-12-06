package com.spring.greencampus.ems.serviceinterface.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.greencampus.ems.serviceinterface.pojo.SignInForm;
import com.spring.greencampus.ems.serviceinterface.pojo.SignUpForm;


@RestController
public class UserController {
	@RequestMapping(value="/signup", method=RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> signup(@RequestBody SignUpForm form){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<SignUpForm> httpEntity = new HttpEntity<SignUpForm>(form);
		return restTemplate.postForEntity("http://localhost:8500/signup", httpEntity, Object.class);
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> signin(@RequestBody SignInForm form){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<SignInForm> httpEntity = new HttpEntity<SignInForm>(form);
		return restTemplate.postForEntity("http://localhost:8500/signin", httpEntity, Object.class);
	}

}
