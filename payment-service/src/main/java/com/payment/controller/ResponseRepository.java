package com.payment.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.model.Response;

public interface ResponseRepository extends JpaRepository<Response,String> {

}
