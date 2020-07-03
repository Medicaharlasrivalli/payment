package com.payment.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthenticationResponse {
	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	@Id
	private String jwt;

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	
}