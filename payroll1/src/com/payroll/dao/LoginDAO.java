package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.LoginDetails;
import com.payroll.util.ConnectionUtil;

public class LoginDAO {

	public LoginDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean loginCheck(LoginDetails loginDetails) throws PayrollException {

		boolean flag = false;
		String query = "select * from login where username=? and password=?";
		Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;

		try {
			connObj = ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			pstmt.setString(1, loginDetails.getUsername());
			pstmt.setString(2, loginDetails.getPassword());

			result = pstmt.executeQuery();
			if (result.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			//e.printStackTrace();

			throw new PayrollException(e);
			
		} finally {
			try {
				if (result != null) {
					result.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}
				
				if (connObj != null) {
					connObj.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PayrollException("Error while closing Object "+e);
				
			}
		}

		return flag;

	}

}
