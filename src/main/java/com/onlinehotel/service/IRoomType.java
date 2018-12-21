package com.onlinehotel.service;

import java.util.List;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.RoomType;

public interface IRoomType {

	
	public int addRoomType(RoomType roomType) throws OnlineHotelException;
	
	public List<RoomType> fetchAllRoomTypes() throws OnlineHotelException;
	
	public boolean deleteRoomType(RoomType roomType) throws OnlineHotelException;
}
