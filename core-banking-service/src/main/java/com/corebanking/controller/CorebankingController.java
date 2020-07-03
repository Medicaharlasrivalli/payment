package com.corebanking.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.corebanking.model.BankCustomer;
import com.corebanking.model.FinalResponse;
import com.corebanking.model.Response;

@RestController
public class CorebankingController {

	@Autowired
	private BankCustomerRepo repo;
	
	@Autowired
	private ResponseRepository repo1;
	
	@Autowired
	private FinalResponseRepository repo2;
	
	@PutMapping(path="/user/{username}/payment/direct/process")
	public FinalResponse processLocalPayments(@PathVariable("username") String username,@RequestParam("tid") String tid) {
		Response r=repo1.findByTid(tid);
		String status;
		Date date=java.util.Calendar.getInstance().getTime();
		String time=date.toString();
		BankCustomer bcus=repo.findByAccountno(r.getBaseaccountno());
		BankCustomer bcus1=repo.findByAccountno(r.getTargetaccountno());
		if(bcus1!=null && bcus1.getCurrency().equals(r.getTargetcurrency())&& r.getTargetcurrency().equals("INR"))
		{
		if(bcus.getBalance()>r.getAmount())
		{
			double detect=bcus.getBalance()-r.getAmount();
			double add=bcus1.getBalance()+r.getAmount();
			bcus.setBalance(detect);
			bcus1.setBalance(add);
			repo.save(bcus);
			repo.save(bcus1);
			status="success";
		}
		else
			status="failure due to unavailabilty of amount";
		}
		else
			status="Failure dure to any of the following reasons "+ "1.target account not found  "+ "2.Target currency other than INR "+ "3.currency not matched";
		FinalResponse fr=new FinalResponse(r.getTid(),r.getBaseaccountno(),status,time);
		repo2.save(fr);
		return fr;
	}
	@PutMapping(path="/user/{username}/payment/cross/process")
	public FinalResponse processCrossPayments(@PathVariable("username") String username,@RequestParam("tid") String tid) {
		Response r=repo1.findByTid(tid);
		String status;
		Date date=java.util.Calendar.getInstance().getTime();
		String time=date.toString();
		BankCustomer bcus=repo.findByAccountno(r.getBaseaccountno());
		BankCustomer bcus1=repo.findByAccountno(r.getTargetaccountno());
		if(bcus1!=null && bcus1.getCurrency().equals(r.getTargetcurrency())&& !r.getTargetcurrency().equals("INR"))
		{
			if(bcus.getBalance()>r.getAmount())
			{
				double detect=bcus.getBalance()-r.getAmount();
				double add=bcus1.getBalance()+r.getTamount();
				bcus.setBalance(detect);
				bcus1.setBalance(add);
				repo.save(bcus);
				repo.save(bcus1);
				status="success";
			}
			else
				status="Failure dure to any of the following reasons "+ "1.target account not found "+ "2.Target currency must not be INR "+ "3.currency not matched";
		}
		else
			status="target account not found or currency not matched";
		FinalResponse fr=new FinalResponse(r.getTid(),r.getBaseaccountno(),status,time);
		repo2.save(fr);
		return fr;
	}
	@GetMapping("user/{username}/paymentStatus/process")
	public FinalResponse processgetStatus(@PathVariable("username") String username,@RequestParam("tid") String tid)
	{
		return repo2.findByTid(tid);
	}
}
