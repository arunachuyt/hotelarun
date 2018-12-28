package com.onlinehotel.model;

import java.sql.Date;


public class BookingEntry {
	private int bid;
	private Date bookingDate; 
	private Customer customerPhNo;
	public BookingEntry() {
		super();
	}
	public BookingEntry(int bid, Date bookingDate, Customer customerPhNo) {
		super();
		this.bid = bid;
		this.bookingDate = bookingDate;
		this.customerPhNo = customerPhNo;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Customer getCustomerPhNo() {
		return customerPhNo;
	}
	public void setCustomerPhNo(Customer customerPhNo) {
		this.customerPhNo = customerPhNo;
	}
	@Override
	public String toString() {
		return "BookingEntry [bid=" + bid + ", bookingDate=" + bookingDate + ", customerPhNo=" + customerPhNo + "]";
	}
	

}
