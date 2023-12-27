package com.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.config.LimitsConfig;
import com.microservices.model.Limits;

@RestController
public class AppController {

	@Autowired
	private LimitsConfig limitsConfig;

	@GetMapping("limits")
	public Limits getLimits() {
		return new Limits(limitsConfig.getMinimum(), limitsConfig.getMaximum(), limitsConfig.getMessage());
	}
}
