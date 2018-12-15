package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.Address;
import com.payroll.util.ConnectionUtil;


public class AddressDAO {

	public AddressDAO() {
		// TODO Auto-generated constructor stub
	}
	
public int registerAddress(Connection connObj,Address address) throws PayrollException{
		
		int generatedId=0;
		boolean flag = false;
		String query = "insert into emp_address(street,city,state,country)values(?,?,?,?)";
		//Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;

		try {
			//connObj = ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			pstmt.setString(1, address.getStreet());
			pstmt.setString(2,  address.getCity());
			pstmt.setString(3,  address.getState());
			pstmt.setString(4,  address.getCountry());
			 pstmt.executeUpdate();
			
			
			//to get generated auto increment value
			result=pstmt.getGeneratedKeys();
			if(result.next()){
				
				generatedId =	result.getInt(1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PayrollException("Address DAO has problem"+e);

		} finally {
			try {
				if (result != null) {
					result.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}
				
				/*if (connObj != null) {
					connObj.close();
				}*/
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PayrollException("Error while closing Object " + e);

				
			}
		}

		return generatedId;
		
	}
	
	
public int updateAddress(Connection connObj,Address address) throws PayrollException{
	
	int count=0;
	boolean flag = false;
	String query = "update emp_address set street=?,city=?,state=?,country=? "
			+ "where address_id=?";
	//Connection connObj = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;

	try {
		//connObj = ConnectionUtil.getConnection();
		pstmt = connObj.prepareStatement(query);
		pstmt.setString(1, address.getStreet());
		pstmt.setString(2,  address.getCity());
		pstmt.setString(3,  address.getState());
		pstmt.setString(4,  address.getCountry());
		pstmt.setInt(5,  address.getAddressId());
		
		count= pstmt.executeUpdate();
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new PayrollException("Address DAO has problem"+e);

	} finally {
		try {
			if (result != null) {
				result.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}
			
			/*if (connObj != null) {
				connObj.close();
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PayrollException("Error while closing Object " + e);

			
		}
	}

	return count;
	
}

}
