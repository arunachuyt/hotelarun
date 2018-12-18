package com.onlinehotel.service;

import java.util.List;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Location;

public interface ILocation {

	
	public int addLocations(Location location) throws OnlineHotelException;
	
	public List<Location> fetchAllLocation() throws OnlineHotelException;
	
	public boolean deleteLocation(Location location) throws OnlineHotelException;
}
