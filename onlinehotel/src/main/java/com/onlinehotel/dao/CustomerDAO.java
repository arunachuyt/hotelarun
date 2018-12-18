package com.onlinehotel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.onlinehotel.exception.OnlineHotelException;

import com.onlinehotel.model.Customer;
import com.onlinehotel.util.ConnectionUtil;

public class CustomerDAO {

	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean loginCheck(Customer customer) throws OnlineHotelException{
		boolean flag = false;
		String query = "select * from customer where phone_no=? and password=?";
		Connection conobj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			conobj = ConnectionUtil.getConnection();
			pstmt = (PreparedStatement) conobj.prepareStatement(query);
			pstmt.setString(1,customer.getPhoneNo());
			pstmt.setString(2,customer.getPassword());
			result = pstmt.executeQuery();
			if (result.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			
			throw new OnlineHotelException("Customerdao has problem"+e);
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
	
	public boolean registerCustomer(Customer customer) throws OnlineHotelException
	{
		boolean flag=false;
		String query="insert into customer values(?,?,?)";
		Connection conobj = null;
		PreparedStatement pstmt=null;
		try {
			conobj = ConnectionUtil.getConnection();
			pstmt=(PreparedStatement) conobj.prepareStatement(query);
			pstmt.setString(1,customer.getPhoneNo());
			pstmt.setString(2,customer.getCustName());
			pstmt.setString(3, customer.getPassword());
			pstmt.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OnlineHotelException("Customerdao has problem"+e);
		}
		finally{
			try{
				
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if (conobj != null) {
					conobj.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println("error while closing object");
			}
			}
	return flag;
	}
}
