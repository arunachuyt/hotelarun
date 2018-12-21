package com.onlinehotel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


import com.onlinehotel.service.AdminService;
import com.onlinehotel.service.BookingDetailsService;
import com.onlinehotel.service.BookingEntryService;
import com.onlinehotel.service.CustomerService;
import com.onlinehotel.service.HotelService;
import com.onlinehotel.service.LocationService;
import com.onlinehotel.service.RoomService;
import com.onlinehotel.service.RoomTypeService;
import com.onlinehotel.controllers.TestController;

@SpringBootApplication
public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}
	@Bean
	public TestController testController(){
		return new TestController();
	}

	@Bean
	public AdminService adminService()
	{
		return new AdminService();
	}
	
	
	
	@Bean
	public BookingDetailsService bookingDetailsService()
	{
		return new BookingDetailsService();
	}
	
	@Bean
	public BookingEntryService bookingEntryService()
	{
		return new BookingEntryService();
	}
	
	@Bean
	public CustomerService customerService()
	{
		return new CustomerService();
	}
	
	@Bean
	public HotelService hotelService()
	{
		return new HotelService();
	}
	
	@Bean
	public LocationService locationService()
	{
		return new LocationService();
	}
	
	@Bean
	public RoomService roomService()
	{
		return new RoomService();
	}
	
	@Bean
	public RoomTypeService roomTypeService()
	{
		return new RoomTypeService();
	}
	
	
	@Bean
	public UrlBasedViewResolver setUpViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App.class, args);
	}

}
