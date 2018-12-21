package com.onlinehotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.RoomType;
import com.onlinehotel.util.ConnectionUtil;

public class RoomTypeDAO {

	public RoomTypeDAO() {
		// TODO Auto-generated constructor stub
	}
	public int addRoomType(RoomType roomType) throws OnlineHotelException{
		int generatedId=0;
		Connection conobj=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String query="insert into roomtype(type) values (?)";
		try{
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=conobj.prepareStatement(query);
			pstmt.setString(1,roomType.getType());
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
			throw new OnlineHotelException("RoomTypeDAO has problem"+sq);
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
	public List<RoomType> fetchAllRoomTypes() throws OnlineHotelException{
		Connection conobj=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		List<RoomType> roomTypes=new ArrayList<RoomType>();
		String query="select * from roomtype";
		try{
			conobj=ConnectionUtil.getConnection();
			pstmt=conobj.prepareStatement(query);
			result=pstmt.executeQuery();
			while(result.next()){
				int typeId=result.getInt("type_id");
				String typeName=result.getString("type");
				RoomType roomType=new RoomType(typeId,typeName);
				roomTypes.add(roomType);
			}
		}
		catch(SQLException sq){
			System.out.println("RoomTypeDAO has problem in fetching locations"+sq);
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
		return roomTypes;
	}
	public boolean deleteRoomType(RoomType roomType) throws OnlineHotelException{
		boolean flag=false;
		Connection conobj=null;
		PreparedStatement pstmt=null;
		String query="delete from roomtype where type_id=?";
		try{
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=conobj.prepareStatement(query);
			pstmt.setInt(1, roomType.getTypeid());
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
			throw new OnlineHotelException("RoomTypeDAO has problem"+sq);
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
