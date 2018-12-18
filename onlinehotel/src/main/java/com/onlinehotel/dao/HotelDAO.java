package com.onlinehotel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Hotel;
import com.onlinehotel.model.Location;
import com.onlinehotel.util.ConnectionUtil;

public class HotelDAO {

	public HotelDAO() {
		// TODO Auto-generated constructor stub
	}

	public int addHotel(Hotel hotel) throws OnlineHotelException {
		// TODO Auto-generated method stub
		int generatedId=0;
		
		Connection conobj=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String query="insert into hotel(hotel_name,Location_location_id) values (?,?)";
		try {
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=(PreparedStatement) conobj.prepareStatement(query);
			pstmt.setString(1, hotel.getHotelName());
			pstmt.setInt(2,hotel.getLocation().getLocationId());
			pstmt.executeUpdate();
			result=pstmt.getGeneratedKeys();
			if(result.next())
			{
			generatedId=result.getInt(1);
			}
			conobj.setAutoCommit(false);
		} catch(SQLException sq){
			try {
				conobj.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in rolling back");
				e.printStackTrace();
			}
			throw new OnlineHotelException("HotelDAO has problem"+sq);
		}
		finally{
			try{
				if (result!=null)
				{
					result.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(conobj!=null)
				{
					conobj.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println("error while closing object");
			}
			}
		return generatedId;
	}
	
	public int updateHotel(Hotel hotel) throws OnlineHotelException
	{
		int id=0;
		Connection conobj=null;
		PreparedStatement pstmt=null;
		String query="update hotel set hotel_name=?,Location_location_id=? where hotel_id=?";
		
		try {
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=(PreparedStatement) conobj.prepareStatement(query);
			pstmt.setString(1, hotel.getHotelName());
			pstmt.setInt(2,hotel.getLocation().getLocationId());
			pstmt.setInt(3,hotel.getHotelId());
			pstmt.executeUpdate();
			id=hotel.getHotelId();
			conobj.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conobj.rollback();
			} catch (SQLException sq) {
				// TODO Auto-generated catch block
				System.out.println("Error in rolling back");
				e.printStackTrace();
			}
			throw new OnlineHotelException("HotelDAO has problem"+e);
		}
		finally{
			try{
				
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(conobj!=null)
				{
					conobj.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println("error while closing object");
			}
			}
		
	
		return id;
		
	}
	
	public boolean deleteHotel(Hotel hotel) throws OnlineHotelException {
		boolean flag=false;
		Connection conobj=null;
		PreparedStatement pstmt=null;
		String query="delete from hotel where hotel_id=?";
		try{
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=(PreparedStatement) conobj.prepareStatement(query);
			pstmt.setInt(1,hotel.getHotelId());
			pstmt.executeUpdate();
			flag=true;
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
			throw new OnlineHotelException("HotelDAO has problem"+sq);
		}
		finally{
			try{
				
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(conobj!=null)
				{
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
	
	public List<Hotel> fetchHotelByLocation(Location location) throws OnlineHotelException {
		List<Hotel> list=new ArrayList<Hotel>();
		
		Connection conobj=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String query="select * from hotel where Location_location_id=?";
		try {
			conobj=ConnectionUtil.getConnection();
			pstmt=(PreparedStatement) conobj.prepareStatement(query);
			pstmt.setInt(1, location.getLocationId());
			result=pstmt.executeQuery();
			while(result.next()){
				int hotelId=result.getInt(1);
				String hotelName=result.getString(2);
			Hotel hotel=new Hotel(hotelId,hotelName,location);
				list.add(hotel);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("HotelDAO has problem"+e);
			throw new OnlineHotelException();
		}
		finally{
			try{
				
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(conobj!=null)
				{
					conobj.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println("error while closing object");
			}
			}
	return list;
	}
}
