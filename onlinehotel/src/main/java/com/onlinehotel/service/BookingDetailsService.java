package com.onlinehotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinehotel.dao.BookingDetailsDAO;
import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.BookingDetails;
import com.onlinehotel.model.BookingEntry;


@Service
public class BookingDetailsService implements IBookingDetails {

	BookingDetailsDAO bookingDetailsDAO=new BookingDetailsDAO();
	public BookingDetailsService() {
		// TODO Auto-generated constructor stub
	}

	public String addNewBooking(List<BookingDetails> bookingList) throws OnlineHotelException {
		// TODO Auto-generated method stub
		return bookingDetailsDAO.addNewBooking(bookingList);
	}

	public List<BookingDetails> bill(BookingEntry bookingentry)throws OnlineHotelException {
		// TODO Auto-generated method stub
		return bookingDetailsDAO.bill(bookingentry);
	}

	public double totalBillAmount(BookingEntry bookingentry)throws OnlineHotelException {
		// TODO Auto-generated method stub
		return bookingDetailsDAO.totalBillAmount(bookingentry);
	}

}
