package com.onlinehotel.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Admin;
import com.onlinehotel.model.BookingDetails;
import com.onlinehotel.model.BookingEntry;
import com.onlinehotel.model.Customer;
import com.onlinehotel.model.Hotel;
import com.onlinehotel.model.Location;
import com.onlinehotel.model.Room;
import com.onlinehotel.model.RoomType;
import com.onlinehotel.service.AdminService;
import com.onlinehotel.service.BookingDetailsService;
import com.onlinehotel.service.BookingEntryService;
import com.onlinehotel.service.CustomerService;
import com.onlinehotel.service.HotelService;
import com.onlinehotel.service.LocationService;
import com.onlinehotel.service.RoomService;
import com.onlinehotel.service.RoomTypeService;

@Controller
public class TestController {

	
	public TestController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired(required=true)
	private AdminService adminService;
	
	@Autowired(required=true)
	private BookingDetailsService bookingDetailsService;
	
	@Autowired(required=true)
	private BookingEntryService bookingEntryService;
	
	@Autowired(required=true)
	private CustomerService customerService;
	
	@Autowired(required=true)
	private HotelService hotelService;
	
	@Autowired(required=true)
	private LocationService locationService;
	
	@Autowired(required=true)
	private RoomService roomService;
	
	@Autowired(required=true)
	private RoomTypeService roomTypeService;
	
	@GetMapping("/home")
	public ModelAndView home(){
		String view="oyologin";
		ModelAndView mav=new ModelAndView(view);
		System.out.println("Home");
		
		return mav;
	}
	@PostMapping("/loginvalidate")
	public ModelAndView loginvalidate(Customer customer,HttpSession session)
	{
		System.out.println(customer);
		String view="location";
		ModelAndView mav=null;
		List<Location> locations=new ArrayList<Location>();
		try{
			boolean ch=false;
			 ch=customerService.loginCheck(customer);
			 if(ch){
					mav=new ModelAndView(view);
					locations=locationService.fetchAllLocation();
					System.out.println(customer);
					session.setAttribute("customer", customer);
					mav.addObject("name", customer.getCustName());
					mav.addObject("locations", locations);
			 }
			 else{
				 view="oyologin";
				 mav=new ModelAndView(view);
				 mav.addObject("error","username or password is wrong");
			 }
			 }
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
	}
	@PostMapping("/listhotels")
	public ModelAndView listhotels(Location location){
		System.out.println(location);
		String view="hotel";
		ModelAndView mav=null;
		List<Hotel> hotels=new ArrayList<Hotel>();
		try{
			hotels=hotelService.fetchHotelByLocation(location);
			mav=new ModelAndView(view);
			mav.addObject("hotels", hotels);
			}
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
		
	}
	@GetMapping("/register")
	public ModelAndView register(){
		String view="oyoregister";
		ModelAndView mav=new ModelAndView(view);
		System.out.println("Registration page");
		
		return mav;
	}
	@PostMapping("/registration")
		public ModelAndView registration(Customer customer){
		System.out.println(customer);
		String view="oyologin";
		ModelAndView mav=null;
		try{
			boolean ch=false;
			ch=customerService.registerCustomer(customer);
			if(ch){
				mav=new ModelAndView(view);
				mav.addObject("message", "Successfully registered!! Please login again");
			}
			else{
				mav=new ModelAndView(view);
				 mav.addObject("message","error in registering the details");
			}
		}
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
	}
	
	@GetMapping("/getlocationid")
	public ModelAndView getlocationid(@RequestParam(value="locationId") int locationId)
	{
		String view="hotel";
		ModelAndView mav=null;
		Location location=null;
		List<Hotel> hotels=new ArrayList<Hotel>();
		
		try{
			mav=new ModelAndView(view);
			location=new Location();
			location.setLocationId(locationId);
			hotels=hotelService.fetchHotelByLocation(location);
			mav.addObject("hotels", hotels);
		}
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
		
	}
	@GetMapping("/gethotelid")
	public ModelAndView gethotelid(@RequestParam(value="hotelId") int hotelId,@RequestParam(value="checkIn") String checkIn,@RequestParam(value="checkOut") String checkOut,HttpSession session1) throws ParseException{
		
		String view="room2";
		ModelAndView mav=null;
		Hotel hotel=null;
		BookingDetails bookingDetails=null;
		List<Room> rooms=new ArrayList<Room>();
		try{
			mav=new ModelAndView(view);
			hotel=new Hotel();
			bookingDetails=new BookingDetails();
			hotel.setHotelId(hotelId);
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date datein =sdf1.parse(checkIn);
			java.sql.Date sqlStartDate = new java.sql.Date(datein.getTime());
			bookingDetails.setCheckIn(sqlStartDate);
			java.util.Date dateout =sdf1.parse(checkOut);
			java.sql.Date sqlEndDate = new java.sql.Date(dateout.getTime());
			bookingDetails.setCheckOut(sqlEndDate);
			System.out.println(bookingDetails);
			session1.setAttribute("bookingdetails", bookingDetails);
			
			rooms=roomService.fetchAllAvailableRoomsByHotel(bookingDetails, hotel);
			mav.addObject("rooms", rooms);
			}
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
		
	}

@PostMapping("/booking")
	public ModelAndView booking(String[] roomsbooked,HttpSession session)
	{
	System.out.println(roomsbooked);
	String view="confirmbooking";
		ModelAndView mav=null;
		BookingEntry bookingEntry=null;
		Customer customer=(Customer)session.getAttribute("customer");
		System.out.println(customer);
		BookingDetails bookingDetails2=(BookingDetails)session.getAttribute("bookingdetails");
		BookingDetails bookingDetails=new BookingDetails(bookingDetails2);
		System.out.println(bookingDetails2);
		List<BookingDetails> bookingDetailslist=new ArrayList<BookingDetails>();
		try {
		mav=new ModelAndView(view);
		bookingEntry=new BookingEntry();
		bookingEntry.setCustomerPhNo(customer);
		int bid=bookingEntryService.getBookingEntry(bookingEntry);
		bookingEntry.setBid(bid);
		bookingDetails.setBid(bookingEntry);
		Room room=null;
		for (String roomNo : roomsbooked) {
			bookingDetails=new BookingDetails();
			bookingDetails.setCheckIn(bookingDetails2.getCheckIn());
			bookingDetails.setCheckOut(bookingDetails2.getCheckOut());
			bookingDetails.setBid(bookingEntry);
			room=new Room();
			System.out.println(roomNo);
			int roomnoobj=Integer.parseInt(roomNo);
			room.setRoomId(roomnoobj);
			System.out.println(room);
			bookingDetails.setRoomId(room);
			System.out.println(bookingDetails);
			bookingDetailslist.add(bookingDetails);
			}
		System.out.println(bookingDetailslist);
		
		String msg=bookingDetailsService.addNewBooking(bookingDetailslist);
		Double amount=bookingDetailsService.totalBillAmount(bookingEntry);
		List<BookingDetails> resbookingDetailslist=new ArrayList<BookingDetails>();
		resbookingDetailslist=bookingDetailsService.bill(bookingEntry);
		
		 mav.addObject("message",msg);
		 mav.addObject("amount",amount);
		 mav.addObject("bookingdetailslist",resbookingDetailslist);
		
		} catch (OnlineHotelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/adminlogin")
		public ModelAndView adminlogin(){
			String view="adminlogin";
			ModelAndView mav=new ModelAndView(view);
			System.out.println("Admin login");
			
			return mav;
		}
	@PostMapping("/adminloginvalidate")
	public ModelAndView adminloginvalidate(Admin admin){
		System.out.println(admin);
		String view="adminfunctionality";
		ModelAndView mav=null;
		try{
			boolean ch=false;
			 ch=adminService.loginCheck(admin);
			 if(ch){
					mav=new ModelAndView(view);
					mav.addObject("message", "success");
				
				
			 }
			 else{
				 view="adminlogin";
				 mav=new ModelAndView(view);
				 mav.addObject("error","username or password is wrong");
			 }
			 }
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
	}
	@PostMapping("/fetchlocations")
	public ModelAndView fetchlocations(){
		String view="addlocation";
		ModelAndView mav=null;
		List<Location> locations=null;
		try{
			mav=new ModelAndView(view);
			locations=locationService.fetchAllLocation();
			mav.addObject("locations", locations);
		}
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
	}
	
	@GetMapping("/location")
	public ModelAndView location(){
		String view="location";
		ModelAndView mav=null;
		List<Location> locations=new ArrayList<Location>();
		try{
			mav=new ModelAndView(view);
			locations=locationService.fetchAllLocation();
			mav.addObject("locations", locations);
		}
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
	}
	
	@GetMapping("/listAllBooking")
	public ModelAndView listAllBooking(HttpSession session){
		String view="mybookings";
		ModelAndView mav=null;
		List<BookingDetails> bookings=new ArrayList<BookingDetails>();
		try{
			mav=new ModelAndView(view);
			bookings=customerService.listAllBooking((Customer) session.getAttribute("customer"));
			mav.addObject("bookings", bookings);
		}
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
	}
	
		@GetMapping("/logout")
			public ModelAndView logout(HttpServletRequest request) throws OnlineHotelException{
			String view="oyologin";
			ModelAndView mav=null;
			mav=new ModelAndView(view);
			request.getSession(true).invalidate();
				
				return mav;
				
			} 
		 
	
	@GetMapping("/addhotel")
	public ModelAndView addhotel(){
		String view="addhotel";
		ModelAndView mav=null;
		List<Location> locations=new ArrayList<Location>();
		List<RoomType> roomTypes=new ArrayList<RoomType>();
		try{
			mav=new ModelAndView(view);
			locations=locationService.fetchAllLocation();
			roomTypes=roomTypeService.fetchAllRoomTypes();
			mav.addObject("locations", locations);
			mav.addObject("roomTypes", roomTypes);
			
		}
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
	}
	
	
	@PostMapping("/registernewhotel")
	public ModelAndView registernewhotel(){
		String view="adminfunctionality";
		ModelAndView mav=null;
		List<Location> locations=new ArrayList<Location>();
		List<RoomType> roomTypes=new ArrayList<RoomType>();
		try{
			mav=new ModelAndView(view);
			locations=locationService.fetchAllLocation();
			roomTypes=roomTypeService.fetchAllRoomTypes();
			mav.addObject("locations", locations);
			mav.addObject("roomTypes", roomTypes);
			
		}
		catch(OnlineHotelException e)
		{
			e.printStackTrace();
		}
		return mav;
	}
	
	@GetMapping("/gallery")
	public ModelAndView gallery() throws OnlineHotelException{
		ModelAndView mav=null;
		String view="gallery";
		mav=new ModelAndView(view);
		return mav;
	}
}
