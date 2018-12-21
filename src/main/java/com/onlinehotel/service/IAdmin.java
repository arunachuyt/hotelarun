package com.onlinehotel.service;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Admin;


public interface IAdmin {

	public boolean loginCheck(Admin admin) throws OnlineHotelException;
}
