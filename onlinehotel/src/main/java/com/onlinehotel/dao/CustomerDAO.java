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
		String query = "select * from admin where username=? and password=?";
		Connection conobj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			conobj = ConnectionUtil.getConnection();
			pstmt = (PreparedStatement) conobj.prepareStatement(query);
			pstmt.setString(1,""+customer.getPhoneNo());
			pstmt.setString(2, customer.getPassword());
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
	
	public void registerCustomer(Connection conobj,Customer customer)
	{
		String query="insert into customer values(?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=(PreparedStatement) conobj.prepareStatement(query);
			pstmt.setString(1,customer.getName());
			pstmt.setInt(2,Integer.parseInt(customer.getContactNo()));
			pstmt.setInt(3, customer.getVtype().getVerificationNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				
				if(pstmt!=null)
				{
					pstmt.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println("error while closing object");
			}
			}
	}
}
