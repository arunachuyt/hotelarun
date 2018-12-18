package com.onlinehotel.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.BookingDetails;
import com.onlinehotel.model.Hotel;
import com.onlinehotel.model.Room;
import com.onlinehotel.model.RoomType;
import com.onlinehotel.util.ConnectionUtil;

public class RoomDAO {

	public RoomDAO() {
		// TODO Auto-generated constructor stub
	}

	public int addRoom(Room room) throws OnlineHotelException{
		int generatedId=0;
		
		Connection conobj=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String query="insert into room(price,Hotel_hotel_id,RoomType_type_id) values (?,?,?)";
		try {
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=(PreparedStatement) conobj.prepareStatement(query);
			pstmt.setDouble(1,room.getPrice());
			pstmt.setInt(2,room.getHotelId().getHotelId());
			pstmt.setInt(3,room.getRoomTypeId().getTypeid());
			pstmt.executeUpdate();
			result=pstmt.getGeneratedKeys();
			if(result.next())
			{
			generatedId=result.getInt(1);
			}
			conobj.commit();
		} catch(SQLException sq){
			try {
				conobj.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in rolling back");
				e.printStackTrace();
			}
			throw new OnlineHotelException("RoomDAO has problem"+sq);
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
	
	public int updateRoom(Room room) throws OnlineHotelException
	{
		int id=0;
		Connection conobj=null;
		PreparedStatement pstmt=null;
		String query="update room set price=?,Hotel_hotel_id=?,RoomType_type_id=? where room_id=?";
		
		try {
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=(PreparedStatement) conobj.prepareStatement(query);
			pstmt.setDouble(1, room.getPrice());
			pstmt.setInt(2,room.getHotelId().getHotelId());
			pstmt.setInt(3,room.getRoomTypeId().getTypeid());
			pstmt.setInt(4,room.getRoomId());
			pstmt.executeUpdate();
			id=room.getRoomId();
			conobj.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conobj.rollback();
			} catch (SQLException sq) {
				// TODO Auto-generated catch block
				System.out.println("Error in rolling back");
				e.printStackTrace();
			}
			throw new OnlineHotelException("RoomDAO has problem"+e);
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
	
	public boolean deleteRoom(Room room) throws OnlineHotelException {
		boolean flag=false;
		Connection conobj=null;
		PreparedStatement pstmt=null;
		String query="delete from room where room_id=?";
		try{
			conobj=ConnectionUtil.getConnection();
			conobj.setAutoCommit(false);
			pstmt=(PreparedStatement) conobj.prepareStatement(query);
			pstmt.setInt(1,room.getRoomId());
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
			throw new OnlineHotelException("RoomDAO has problem"+sq);
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
	public List<Room> fetchAllAvailableRoomsByHotel(BookingDetails bookingdetails,Hotel hotel) throws OnlineHotelException{
		Connection conobj=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String query="select * from room r where r.room_id not in(select r.room_id from room r inner join bookingdetails b on r.room_id=b.Room_room_id where check_in<? && check_out>?) and Hotel_hotel_id=?";
		List<Room> rooms=new ArrayList<Room>();
		try{
			conobj=ConnectionUtil.getConnection();
			pstmt=(PreparedStatement) conobj.prepareStatement(query);
			pstmt.setDate(1, (Date) bookingdetails.getCheckOut());
			pstmt.setDate(2, (Date) bookingdetails.getCheckIn());
			pstmt.setInt(3, hotel.getHotelId());
			result=pstmt.executeQuery();
			while(result!=null){
				int roomId=result.getInt("room_id");
				RoomType roomType=new RoomType();
				int roomTypeId=result.getInt("RoomType_type_id");
				roomType.setTypeid(roomTypeId);
				int hotelId=result.getInt("Hotel_hotel_id");
				Hotel hotelobj=new Hotel();
				hotelobj.setHotelId(hotelId);
				double price=result.getDouble("price");
				Room room=new Room(roomId,roomType,hotel,price);
				rooms.add(room);
				}
			}
		catch(SQLException sq){
			System.out.println("RoomDAO has problem"+sq);
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
		
		return rooms;
	}
	
}
