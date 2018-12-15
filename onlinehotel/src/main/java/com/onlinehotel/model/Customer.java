package com.onlinehotel.model;

public class Customer {
	private int phoneNo;
	private String custName;
	private String password;

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	

	public Customer(int phoneNo, String custName, String password) {
	
		this.phoneNo = phoneNo;
		this.custName = custName;
		this.password = password;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [phoneNo=" + phoneNo + ", custName=" + custName + ", password=" + password + "]";
	}

}
