package com.onlinehotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Location;
import com.onlinehotel.util.ConnectionUtil;

public class LocationDAO {

	public LocationDAO() {
		// TODO Auto-generated constructor stub
	}
	public int addLocations(Location location) throws OnlineHotelException{
		int generatedId=0;
		Connection conobj=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String query="insert into location(location_name) values (?)";
		try{
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=conobj.prepareStatement(query);
			pstmt.setString(1, location.getLocationName());
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
				throw new OnlineHotelException("LocationDAO has problem"+sq);
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
	public List<Location> fetchAllLocation() throws OnlineHotelException{
		Connection conobj=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		List<Location> locations=new ArrayList<Location>();
		String query="select * from location";
		try{
			conobj=ConnectionUtil.getConnection();
			pstmt=conobj.prepareStatement(query);
			result=pstmt.executeQuery();
			while(result.next()){
				int locationId=result.getInt("location_id");
				String locationName=result.getString("location_name");
				Location location=new Location(locationId,locationName);
				locations.add(location);
				
			}
		}
		catch(SQLException sq){
			System.out.println("LocationDAO has problem in fetching locations"+sq);
			throw new OnlineHotelException();
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
		return locations;
	}
	public boolean deleteLocation(Location location) throws OnlineHotelException{
		boolean flag=false;
		Connection conobj=null;
		PreparedStatement pstmt=null;
		String query="delete from location where location_id=?";
		try{
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=conobj.prepareStatement(query);
			pstmt.setInt(1, location.getLocationId());
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
			throw new OnlineHotelException("LocationDAO has problem"+sq);
		}
		finally{
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
		return flag;
	}
	

}
