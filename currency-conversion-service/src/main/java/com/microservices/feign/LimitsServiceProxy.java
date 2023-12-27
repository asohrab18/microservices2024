package com.microservices.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservices.external.model.Limits;

/**Eureka Client dependency added. Now, Hardcoded URL is not required.
 * limits-service is the name of the microservice to be called.
 */
@FeignClient(name = "limits-service")
public interface LimitsServiceProxy {

	/**Note: This method name can be different from method name of another microservice (limits-service).*/
	@GetMapping("limits")
	Limits findLimits();
}
