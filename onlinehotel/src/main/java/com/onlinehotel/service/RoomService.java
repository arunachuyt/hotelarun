package com.onlinehotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinehotel.dao.RoomDAO;
import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.BookingDetails;
import com.onlinehotel.model.Hotel;
import com.onlinehotel.model.Room;


@Service
public class RoomService implements IRoom {

	RoomDAO roomDAO=new RoomDAO();
	public RoomService() {
		// TODO Auto-generated constructor stub
	}

	public int addRoom(Room room) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return roomDAO.addRoom(room);
	}

	public int updateRoom(Room room) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return roomDAO.updateRoom(room);
	}

	public boolean deleteRoom(Room room) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return roomDAO.deleteRoom(room);
	}

	public List<Room> fetchAllAvailableRoomsByHotel(BookingDetails bookingdetails, Hotel hotel)
			throws OnlineHotelException {
		// TODO Auto-generated method stub
		return roomDAO.fetchAllAvailableRoomsByHotel(bookingdetails, hotel);
	}

}
