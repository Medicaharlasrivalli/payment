package com.payment.model;

public class Request {
	private double amount;
	private long targetAccNo;
	private String targetCurrency;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getTargetAccNo() {
		return targetAccNo;
	}
	public void setTargetAccNo(long targetAccNo) {
		this.targetAccNo = targetAccNo;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public Request(double amount, long targetAccNo, String targetCurrency) {
		super();
		this.amount = amount;
		this.targetAccNo = targetAccNo;
		this.targetCurrency = targetCurrency;
	}
	
}
