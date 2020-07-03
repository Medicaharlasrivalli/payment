package com.corebanking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FinalResponse {
	@Id
	private String tid;
	public FinalResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	private long accountno;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public FinalResponse(String tid, long accountno, String status, String time) {
		super();
		this.tid = tid;
		this.accountno = accountno;
		Status = status;
		this.time = time;
	}
	public long getAccountno() {
		return accountno;
	}
	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String Status;
	private String time;
}
