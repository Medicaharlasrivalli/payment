package com.forex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {
	
	@Autowired
	private MyFeignClient myfeignclient;
	
	@GetMapping("/")
	public float getRates(@RequestParam("currency") String cur)
	{
		String s=myfeignclient.getResponse(cur);
		String[] s1=s.split(":");
		String[] s2=s1[1].split("}");
		float f=Float.parseFloat(s2[0]);
		return f;
	}
}
