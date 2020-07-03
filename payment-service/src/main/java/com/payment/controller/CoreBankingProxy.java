package com.payment.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.payment.model.FinalResponse;

@FeignClient(name = "core-banking-service" ,url="http://localhost:8181")
public interface CoreBankingProxy {
	
	@PutMapping(path="/user/{username}/payment/direct/process")
	public FinalResponse processLocalPayments(@PathVariable("username") String username,@RequestParam("tid") String tid);
	
	@PutMapping(path="/user/{username}/payment/cross/process")
	public FinalResponse processCrossPayments(@PathVariable("username") String username,@RequestParam("tid") String tid);
	
	@GetMapping(path="/user/{username}/paymentStatus/process")
	public FinalResponse processgetStatus(@PathVariable("username") String username,@RequestParam("tid") String tid);
}
