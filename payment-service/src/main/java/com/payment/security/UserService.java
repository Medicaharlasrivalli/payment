package com.payment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;



@Service
public class UserService {
	
	
@Autowired
JwtUtil jwtUtil;

public boolean isAuthenticated(String username, String token) throws ExpiredJwtException,SignatureException{
		
		String tokenid = token.substring(7); 
		
		if (jwtUtil.validateToken(tokenid,username)) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
