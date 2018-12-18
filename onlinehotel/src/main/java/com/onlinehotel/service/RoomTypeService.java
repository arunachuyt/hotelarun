package com.onlinehotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinehotel.dao.RoomTypeDAO;
import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.RoomType;

@Service
public class RoomTypeService implements IRoomType {

	RoomTypeDAO roomTypeDAO=new RoomTypeDAO();
	public RoomTypeService() {
		// TODO Auto-generated constructor stub
	}

	public int addRoomType(RoomType roomType) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return roomTypeDAO.addRoomType(roomType);
	}

	public List<RoomType> fetchAllRoomTypes() throws OnlineHotelException {
		// TODO Auto-generated method stub
		return roomTypeDAO.fetchAllRoomTypes();
	}

	public boolean deleteRoomType(RoomType roomType) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return roomTypeDAO.deleteRoomType(roomType);
	}

}
