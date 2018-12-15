package com.onlinehotel.model;

public class Room {
	private int roomId;
	private RoomType roomTypeId;
	private Hotel hotelId;
	private double price;
	public Room() {
		super();
	}
	public Room(int roomId, RoomType roomTypeId, Hotel hotelId, double price) {
		
		this.roomId = roomId;
		this.roomTypeId = roomTypeId;
		this.hotelId = hotelId;
		this.price = price;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public RoomType getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(RoomType roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public Hotel getHotelId() {
		return hotelId;
	}
	public void setHotelId(Hotel hotelId) {
		this.hotelId = hotelId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomTypeId=" + roomTypeId + ", hotelId=" + hotelId + ", price=" + price
				+ "]";
	}
	
	

}
