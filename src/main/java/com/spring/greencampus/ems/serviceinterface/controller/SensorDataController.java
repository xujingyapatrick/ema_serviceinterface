package com.spring.greencampus.ems.serviceinterface.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.greencampus.ems.serviceinterface.feignclient.MainappProxy;

@RestController
public class SensorDataController {
	
	@Autowired
	private MainappProxy mainappProxy;
	
	@RequestMapping("/ports")
	public ResponseEntity<?> getCurrentPort(){
		return mainappProxy.getCurrentPort();
	}
	
	@RequestMapping("/sensordata")
	public ResponseEntity<?> getAllSensorData() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity("http://localhost:9191/sensordata", Object.class);
	}

	@RequestMapping("/sensordata/{date}")
	public ResponseEntity<?> getSensorDataByTimestamp(@PathVariable("date") String date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("date", date);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity("http://localhost:9191/sensordata/{date}", Object.class, map);
	}

	@RequestMapping("/sensordata/{start}/{end}")
	public ResponseEntity<?> getSensorDataBetween(@PathVariable("start") String start,
			@PathVariable("end") String end) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", start);
		map.put("end", end);

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity("http://localhost:9191/sensordata/{start}/{end}", Object.class, map);
	}

	@RequestMapping(value = "/sensordata", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> insertNewData(@RequestBody String body) {
		HttpEntity<String> httpEntity = new HttpEntity<String>(body);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForEntity("http://localhost:9191/sensordata", httpEntity, Object.class);
	}

}
