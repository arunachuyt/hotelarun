package com.onlinehotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinehotel.dao.LocationDAO;
import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Location;


@Service
public class LocationService implements ILocation {

	LocationDAO locationDAO=new LocationDAO();
	public LocationService() {
		// TODO Auto-generated constructor stub
	}

	public int addLocations(Location location) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return locationDAO.addLocations(location);
	}

	public List<Location> fetchAllLocation() throws OnlineHotelException {
		// TODO Auto-generated method stub
		return locationDAO.fetchAllLocation();
	}

	public boolean deleteLocation(Location location) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return locationDAO.deleteLocation(location);
	}

}
