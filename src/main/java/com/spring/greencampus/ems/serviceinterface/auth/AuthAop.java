package com.spring.greencampus.ems.serviceinterface.auth;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Aspect
@Configuration
public class AuthAop {
	
	@Autowired
	private HttpServletRequest request;
	private Logger logger = LoggerFactory.getLogger(this.getClass()) ;

	@Around("execution(* com.spring.greencampus.ems.serviceinterface.controller.SensorDataController.*(..))")
	public ResponseEntity<?> accessValidation(ProceedingJoinPoint point) throws Throwable{

		String id = request.getHeader("X-ACCESS-ID");
		String token = request.getHeader("X-ACCESS-TOKEN");
		logger.info("id: "+id);
		logger.info("token: "+token);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-ACCESS-ID", id);
		headers.set("X-ACCESS-TOKEN", token);
		HttpEntity httpEntity = new HttpEntity(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity responseEntity= restTemplate.exchange("http://localhost:8500/access", HttpMethod.GET, httpEntity, Object.class);
		logger.info("responseEntity.getStatusCode()"+responseEntity.getStatusCode());
		logger.info("HttpStatus.OK"+HttpStatus.OK);
		
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			responseEntity = (ResponseEntity) point.proceed();
		}		
		
		logger.info("Arg LOG FINISHED !!");
		return responseEntity;
	}

	
	

}
