package com.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("circuit-breaker")
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("sample-api")
	@Retry(name = "sample-api")
	public String getSample() {
		logger.info("=====>sample API call received.<========");
		ResponseEntity<String> re = new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class);
		return re.getBody();
	}
}
