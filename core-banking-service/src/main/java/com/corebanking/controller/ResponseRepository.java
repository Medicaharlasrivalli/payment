package com.corebanking.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corebanking.model.Response;

public interface ResponseRepository extends JpaRepository<Response,String>{

	Response findByTid(String tid);
}
