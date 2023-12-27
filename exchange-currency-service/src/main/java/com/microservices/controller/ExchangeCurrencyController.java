package com.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.entity.ExchangeCurrency;
import com.microservices.repository.ExchangeCurrencyRepository;

@RestController
@RequestMapping("exchange-currency")
public class ExchangeCurrencyController {

	@Autowired
	private ExchangeCurrencyRepository repo;

	@Autowired
	private Environment env;

	@GetMapping("from/{from}/to/{to}")
	public ExchangeCurrency getExchangeCurrency(@PathVariable String from, @PathVariable String to) {
		ExchangeCurrency exchangeCurrency = repo.findByCurrencyFromAndCurrencyTo(from, to).orElse(null);
		if (exchangeCurrency == null) {
			throw new RuntimeException("Unable to find data for " + from + " to " + to + " Currency-Exchange.");
		}
		String port = env.getProperty("local.server.port");
		exchangeCurrency.setEnvironmentPort(port);
		return exchangeCurrency;
	}
}
