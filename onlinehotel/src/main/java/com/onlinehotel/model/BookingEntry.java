package com.onlinehotel.model;

import java.time.LocalDate;

public class BookingEntry {
	private int bid;
	private LocalDate bookingDate; 
	private Customer customerPhNo;
	public BookingEntry() {
		super();
	}
	public BookingEntry(int bid, LocalDate bookingDate, Customer customerPhNo) {
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
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
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
