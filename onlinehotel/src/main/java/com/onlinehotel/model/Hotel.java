package com.onlinehotel.model;

public class Hotel {
	private int hotelId;
	private String hotelName;
	private Location location;
	public Hotel() {
		// TODO Auto-generated constructor stub
	}
	public Hotel(int hotelId, String hotelName, Location location) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.location = location;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", location=" + location + "]";
	}
	

}
