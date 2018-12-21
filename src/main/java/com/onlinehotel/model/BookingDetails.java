package com.onlinehotel.model;

import java.sql.Date;


public class BookingDetails {
	private BookingEntry bid;
	private Room roomId;
	private Date checkIn;
	private Date checkOut;
	public BookingDetails() {
		super();
	}
	public BookingDetails(BookingEntry bid, Room roomId,Date checkIn,Date checkOut) {
		super();
		this.bid = bid;
		this.roomId = roomId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public  BookingDetails(BookingDetails bookingDetails) {
		// TODO Auto-generated constructor stub
		
	}
	public BookingEntry getBid() {
		return bid;
	}
	public void setBid(BookingEntry bid) {
		this.bid = bid;
	}
	public Room getRoomId() {
		return roomId;
	}
	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	@Override
	public String toString() {
		return "BookingDetails [bid=" + bid + ", roomId=" + roomId + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ "]";
	}
	

}
