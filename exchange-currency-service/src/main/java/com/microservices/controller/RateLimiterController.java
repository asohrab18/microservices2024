package com.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("rate-limiter")
public class RateLimiterController {

	private Logger logger = LoggerFactory.getLogger(RateLimiterController.class);

	@GetMapping("sample-api")
	@RateLimiter(name = "default")
	public String getSample() {
		logger.info("=====>sample-api call received.<========");
		return "sample-api response due to Rate Limiter.";
	}
}
