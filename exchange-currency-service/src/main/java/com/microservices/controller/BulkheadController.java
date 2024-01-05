package com.microservices.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
@RequestMapping("bulkhead")
public class BulkheadController {

	private Logger logger = LoggerFactory.getLogger(BulkheadController.class);

	@GetMapping("sample-api")
	@Bulkhead(name = "my-resource")
	public String getSample() {
		logger.info("=====>sample-api call received.<========");
		return "sample-api response due to Bulkhead.";
	}
}
