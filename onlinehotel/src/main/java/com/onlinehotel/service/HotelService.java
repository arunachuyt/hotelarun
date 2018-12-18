package com.onlinehotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinehotel.dao.HotelDAO;
import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Hotel;
import com.onlinehotel.model.Location;

@Service
public class HotelService implements IHotel {

	HotelDAO hotelDAO=new HotelDAO();
	public HotelService() {
		// TODO Auto-generated constructor stub
	}

	public int addHotel(Hotel hotel) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return hotelDAO.addHotel(hotel);
	}

	public int updateHotel(Hotel hotel) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return hotelDAO.updateHotel(hotel);
	}

	public boolean deleteHotel(Hotel hotel) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return hotelDAO.deleteHotel(hotel);
	}

	public List<Hotel> fetchHotelByLocation(Location location) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return hotelDAO.fetchHotelByLocation(location);
	}

}
