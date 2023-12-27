package com.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.config.AppConfig;
import com.microservices.model.Greetings;

@RestController
public class AppController {

	@Autowired
	private AppConfig config;

	@GetMapping("greetings")
	public Greetings getLimits() {
		return new Greetings(config.getMessage());
	}
}
