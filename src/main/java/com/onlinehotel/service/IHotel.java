package com.onlinehotel.service;

import java.util.List;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Hotel;
import com.onlinehotel.model.Location;

public interface IHotel {

	
	public int addHotel(Hotel hotel) throws OnlineHotelException;
	
	public int updateHotel(Hotel hotel) throws OnlineHotelException;
	
	public boolean deleteHotel(Hotel hotel) throws OnlineHotelException;
	
	public List<Hotel> fetchHotelByLocation(Location location) throws OnlineHotelException;
}
