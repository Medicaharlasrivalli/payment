package com.payment.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.model.Customer;
import java.lang.String;

public interface UserRespository extends JpaRepository<Customer,String>{
	 Customer findByUsername(String username);
}
