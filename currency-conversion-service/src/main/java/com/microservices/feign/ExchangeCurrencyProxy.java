package com.microservices.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.bean.CurrencyConversion;

@FeignClient(name = "feign-exchange", url = "http://localhost:8000")
public interface ExchangeCurrencyProxy {

	/**Note: This method name can be different from method name of another microservice (exchange-currency-service).*/
	@GetMapping("exchange-currency/from/{from}/to/{to}")
	CurrencyConversion getExchange(@PathVariable String from, @PathVariable String to);
}
