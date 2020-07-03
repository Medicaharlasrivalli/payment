package com.forex.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="currency" ,url="https://free.currconv.com/api/v7/convert?apiKey=4e7b6605c73df7e1f2e0&compact=ultra")
public interface MyFeignClient {
	
	@GetMapping("/")
	String getResponse(@RequestParam("q") String cur);
}
