package com.corebanking.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corebanking.model.BankCustomer;

public interface BankCustomerRepo extends JpaRepository<BankCustomer,Long>{

	BankCustomer findByAccountno(long baseaccountno);

}
