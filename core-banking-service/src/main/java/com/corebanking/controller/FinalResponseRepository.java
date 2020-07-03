package com.corebanking.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corebanking.model.FinalResponse;

public interface FinalResponseRepository extends JpaRepository<FinalResponse,String> {
	FinalResponse findByTid(String tid);
}