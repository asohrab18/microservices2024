package com.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.bean.CurrencyConversion;
import com.microservices.feign.ExchangeCurrencyProxy;

@RestController
@RequestMapping("currency-conversion")
public class CurrencyConversionController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ExchangeCurrencyProxy proxy;

	@GetMapping("from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		CurrencyConversion cc = restTemplate.getForObject("http://localhost:8000/exchange-currency/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		return new CurrencyConversion(cc.getId(), from, to, quantity, cc.getConversionMultiple(),
				quantity.multiply(cc.getConversionMultiple()), cc.getEnvironmentPort() + " using RestTemplate");
	}

	@GetMapping("feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		CurrencyConversion cc = proxy.getExchange(from, to);
		return new CurrencyConversion(cc.getId(), from, to, quantity, cc.getConversionMultiple(),
				quantity.multiply(cc.getConversionMultiple()), cc.getEnvironmentPort() + " using Feign");
	}

}
