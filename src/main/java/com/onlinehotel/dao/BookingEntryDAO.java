package com.onlinehotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.BookingEntry;
import com.onlinehotel.util.ConnectionUtil;

public class BookingEntryDAO {

	public BookingEntryDAO() {
		// TODO Auto-generated constructor stub
	}
	public int getBookingEntry(BookingEntry bookingEntry) throws OnlineHotelException{
		int generatedId=0;
		Connection conobj=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String query="insert into bookingentry(booking_date,Customer_phone_no) values (current_date,?)";
		try{
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=conobj.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			System.out.println(bookingEntry);
			pstmt.setString(1, bookingEntry.getCustomerPhNo().getPhoneNo());
			pstmt.executeUpdate();
			result=pstmt.getGeneratedKeys();
			if(result.next()){
			generatedId=result.getInt(1);
			}
			conobj.commit();
		}
		catch(SQLException sq){
			try {
				conobj.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in rolling back");
				e.printStackTrace();
			}
			throw new OnlineHotelException("BookingEntryDAO has problem"+sq);
		}
		finally{
			if(result!=null){
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error while closing the resultset");
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error while closing the prepared statement");
					e.printStackTrace();
				}
		}
			if(conobj!=null){
				try {
					conobj.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error while closing the conobj");
					e.printStackTrace();
				}
			}
		
		
	}
		return generatedId;
	}

}
