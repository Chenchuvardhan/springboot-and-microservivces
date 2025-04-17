package in.nykaa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class NykaaReseliencejRestController {
@GetMapping(value ="/fetch")
@CircuitBreaker(fallbackMethod="getDataFromDb",name="chechu")
public String getDataFromRedis() {
	int i=1/0;
	return "getting Data from Redis Cache";
}
public String getDataFromDb(Throwable t) {
	
	return "getting data from db";
}
}
