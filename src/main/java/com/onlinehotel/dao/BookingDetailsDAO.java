package com.onlinehotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.BookingDetails;
import com.onlinehotel.model.BookingEntry;
import com.onlinehotel.model.Customer;
import com.onlinehotel.model.Hotel;
import com.onlinehotel.model.Room;
import com.onlinehotel.model.RoomType;
import com.onlinehotel.util.ConnectionUtil;

public class BookingDetailsDAO {

	public BookingDetailsDAO() {
		// TODO Auto-generated constructor stub
	}
	public String addNewBooking(List<BookingDetails> bookingList) throws OnlineHotelException{
		String res="";
		Connection conobj=null;
		PreparedStatement pstmt = null;
		String query="insert into bookingdetails(BookingEntry_bid,Room_room_id,check_in,check_out) values(?,?,?,?)";
		try{
			conobj=ConnectionUtil.getConnection();
		
			for(BookingDetails obj:bookingList)
			{
				pstmt=conobj.prepareStatement(query);
				pstmt.setInt(1,obj.getBid().getBid());
				pstmt.setInt(2,obj.getRoomId().getRoomId());
				pstmt.setDate(3,obj.getCheckIn());
				pstmt.setDate(4,obj.getCheckOut());
				pstmt.executeUpdate();
			}
			res="Booking done successfully";
		}
		catch(SQLException sq){
			res="Booking failed";
			throw new OnlineHotelException("BookingDetailsDAO has a problem"+sq);
			}
		finally{
			try{
				
				if(pstmt!=null){
					pstmt.close();
				} 
				if(conobj!=null)
				{
					conobj.close();
				}
			}
			catch(SQLException sq){
				throw new OnlineHotelException("BookingDetailsDAO has a problem in closing"+sq);
				}
		}
	return res;
	}
	public List<BookingDetails> bill(BookingEntry bookingentry) throws OnlineHotelException
	{
		Connection conobj=null;
		PreparedStatement pstmt = null;
		String query="select c.cust_name,h.hotel_name,r.room_id,bd.check_in,bd.check_out,rt.type,(datediff(bd.check_out,bd.check_in))*(r.price) from customer c inner join bookingentry be inner join bookingdetails bd inner join room r inner join roomtype rt inner join hotel h on be.bid=bd.BookingEntry_bid and c.phone_no=be.customer_phone_no and bd.Room_room_id=r.room_id and r.RoomType_type_id=rt.type_id and h.hotel_id=r.Hotel_hotel_id where be.bid=?";
		ResultSet result=null;
		List<BookingDetails> bookinglist=new ArrayList<BookingDetails>();
		
		try {
			conobj=ConnectionUtil.getConnection();
			pstmt=conobj.prepareStatement(query);
			pstmt.setInt(1,bookingentry.getBid());
			result=pstmt.executeQuery();
			while(result.next())
			{
				Customer customer=new Customer();
				customer.setCustName(result.getString(1));
				
				Hotel hotel=new Hotel();
				hotel.setHotelName(result.getString(2));
				
				Room room=new Room();
				room.setRoomId(result.getInt(3));
				room.setHotelId(hotel);
				
				BookingDetails bookingdetails1=new BookingDetails();
				bookingdetails1.setCheckIn(result.getDate(4));
				bookingdetails1.setCheckOut(result.getDate(5));
				
				RoomType roomtype=new RoomType();
				roomtype.setType(result.getString(6));
				
				room.setRoomTypeId(roomtype);
				room.setPrice(result.getDouble(7));
				
				BookingEntry bookingEntry=new BookingEntry();
				bookingEntry.setCustomerPhNo(customer);
	
				bookingdetails1.setRoomId(room);
				bookingdetails1.setBid(bookingEntry);
				
				
				bookinglist.add(bookingdetails1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("BookingDetails dao has problem"+e);
			throw new OnlineHotelException();
		}
		
		finally {
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
		
		return bookinglist;
	} 
	public double totalBillAmount(BookingEntry bookingentry) throws OnlineHotelException{
		double total=0;
		Connection conobj=null;
		PreparedStatement pstmt = null;
		String query="select (datediff(bd.check_out,bd.check_in))*(sum(r.price)) from customer c inner join bookingentry be inner join bookingdetails bd inner join room r inner join roomtype rt inner join hotel h on be.bid=bd.BookingEntry_bid and c.phone_no=be.customer_phone_no and bd.Room_room_id=r.room_id and r.RoomType_type_id=rt.type_id and h.hotel_id=r.Hotel_hotel_id where be.bid=?";
		ResultSet result=null;
		try{
			conobj=ConnectionUtil.getConnection();
			pstmt=conobj.prepareStatement(query);
			pstmt.setInt(1,bookingentry.getBid());
			result=pstmt.executeQuery();
			if(result.next()){
				total=result.getInt(1);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("BookingDetails dao has problem"+e);
			throw new OnlineHotelException();
		}
		finally {
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
		return total;
		}

}
