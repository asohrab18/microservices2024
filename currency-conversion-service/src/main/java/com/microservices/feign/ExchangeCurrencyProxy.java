package com.microservices.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.bean.CurrencyConversion;

/**Eureka Client dependency added. Now, Hardcoded URL is not required.
 * exchange-currency-service is the name of the microservice to be called.
 */
@FeignClient(name = "exchange-currency-service")
public interface ExchangeCurrencyProxy {

	/**Note: This method name can be different from method name of another microservice (exchange-currency-service).*/
	@GetMapping("exchange-currency/from/{from}/to/{to}")
	CurrencyConversion getExchange(@PathVariable String from, @PathVariable String to);
}
