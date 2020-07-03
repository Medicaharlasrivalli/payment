package com.payment.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.model.Customer;


public interface PaymentRepository extends JpaRepository<Customer,Integer>{

	Customer findByUsername(String username);

}
