package com.payment.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="forex-service",url="http://localhost:8383/")
public interface ForexServiceProxy {
	@GetMapping("/")
	float getRates(@RequestParam("currency") String cur);
}
