package com.onlinehotel.service;

import org.springframework.stereotype.Service;

import com.onlinehotel.dao.AdminDAO;
import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Admin;

@Service
public class AdminService implements IAdmin {

	AdminDAO admindao=new AdminDAO();
	public AdminService() {
		// TODO Auto-generated constructor stub

		
	}

	public boolean loginCheck(Admin admin) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return admindao.loginCheck(admin);
	}

}
