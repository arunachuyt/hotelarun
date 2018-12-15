package com.onlinehotel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Admin;
import com.onlinehotel.util.ConnectionUtil;
import com.mysql.jdbc.Connection;

public class AdminDAO {

	public AdminDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean loginCheck(Admin admin) throws OnlineHotelException{
		boolean flag = false;
		String query = "select * from admin where username=? and password=?";
		Connection conobj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			conobj = ConnectionUtil.getConnection();
			pstmt = (PreparedStatement) conobj.prepareStatement(query);
			pstmt.setString(1, admin.getUsername());
			pstmt.setString(2, admin.getPassword());
			result = pstmt.executeQuery();
			if (result.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			
			throw new OnlineHotelException("Admindao has problem"+e);
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conobj != null) {
					conobj.close();
				}
			} catch (SQLException e) {
				System.out.println("error while closing object");
			}
		}

		return flag;
	}
}
