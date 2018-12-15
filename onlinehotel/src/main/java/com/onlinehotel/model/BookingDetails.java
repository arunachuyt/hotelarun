package com.onlinehotel.model;

import java.time.LocalDate;

public class BookingDetails {
	private BookingEntry bid;
	private Room roomId;
	private LocalDate checkIn;
	private LocalDate checkOut;
	public BookingDetails() {
		super();
	}
	public BookingDetails(BookingEntry bid, Room roomId, LocalDate checkIn, LocalDate checkOut) {
		super();
		this.bid = bid;
		this.roomId = roomId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	@Override
	public String toString() {
		return "BookingDetails [bid=" + bid + ", roomId=" + roomId + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ "]";
	}
	

}
