package com.corebanking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Response {
	@Id
	private String tid;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	private long baseaccountno;
	private long targetaccountno;
	private String basecurrency;
	private String targetcurrency;
	public long getBaseaccountno() {
		return baseaccountno;
	}
	public void setBaseaccountno(long baseaccountno) {
		this.baseaccountno = baseaccountno;
	}
	public long getTargetaccountno() {
		return targetaccountno;
	}
	public void setTargetaccountno(long targetaccountno) {
		this.targetaccountno = targetaccountno;
	}
	public String getBasecurrency() {
		return basecurrency;
	}
	public void setBasecurrency(String basecurrency) {
		this.basecurrency = basecurrency;
	}
	public String getTargetcurrency() {
		return targetcurrency;
	}
	public void setTargetcurrency(String targetcurrency) {
		this.targetcurrency = targetcurrency;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	private double amount;
	private double tamount;
	public Response(String tid, long baseaccountno, long targetaccountno, String basecurrency, String targetcurrency,
			double amount, double tamount) {
		super();
		this.tid = tid;
		this.baseaccountno = baseaccountno;
		this.targetaccountno = targetaccountno;
		this.basecurrency = basecurrency;
		this.targetcurrency = targetcurrency;
		this.amount = amount;
		this.tamount = tamount;
	}
	public double getTamount() {
		return tamount;
	}
	public void setTamount(double tamount) {
		this.tamount = tamount;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
}
