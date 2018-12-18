package com.onlinehotel.service;

import java.util.List;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.BookingDetails;
import com.onlinehotel.model.Hotel;
import com.onlinehotel.model.Room;

public interface IRoom {

	public int addRoom(Room room) throws OnlineHotelException;
	
	public int updateRoom(Room room) throws OnlineHotelException;
	
	public boolean deleteRoom(Room room) throws OnlineHotelException;
	
	public List<Room> fetchAllAvailableRoomsByHotel(BookingDetails bookingdetails,Hotel hotel) throws OnlineHotelException;
}
