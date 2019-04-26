package com.ERS.bean;

public class Reimbursement {

	private int id;
	private String username;
	private double amt;
	private int eId;
	private String status;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int id, String username, double amt, int eId, String status) {
		super();
		this.id = id;
		this.username = username;
		this.amt = amt;
		this.eId = eId;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", amt=" + amt + ", eId=" + eId + "]";
	}
	
}
