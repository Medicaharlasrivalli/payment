package com.payment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.payment.model.Customer;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRespository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer=repo.findByUsername(username);
		if(customer==null)
			throw new UsernameNotFoundException("User not found");
		return new UserPrincipal(customer);
	}

}

