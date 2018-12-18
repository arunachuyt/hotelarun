package com.onlinehotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.onlinehotel.exception.OnlineHotelException;
import com.onlinehotel.model.Customer;
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

	@Autowired(required = true)
	private AdminService adminService;

	@Autowired(required = true)
	private BookingDetailsService bookingDetailsService;

	@Autowired(required = true)
	private BookingEntryService bookingEntryService;

	@Autowired(required = true)
	private CustomerService customerService;

	@Autowired(required = true)
	private HotelService hotelService;

	@Autowired(required = true)
	private LocationService locationService;

	@Autowired(required = true)
	private RoomService roomService;

	@Autowired(required = true)
	private RoomTypeService roomTypeService;

	@GetMapping("/home")
	public ModelAndView home() {
		String view = "oyologin";
		ModelAndView mav = new ModelAndView(view);
		System.out.println("Home");

		return mav;
	}

	@PostMapping("/loginvalidate")
	public ModelAndView loginvalidate(Customer customer) {
		System.out.println(customer);
		String view = "success";
		ModelAndView mav = null;
		try {
			boolean ch = false;
			ch = customerService.loginCheck(customer);
			if (ch) {
				mav = new ModelAndView(view);
			} else {
				view = "oyologin";
				mav = new ModelAndView(view);
				mav.addObject("error", "username or password is wrong");
			}
		} catch (OnlineHotelException e) {
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/register")
	public ModelAndView register() {
		String view = "oyoregister";
		ModelAndView mav = new ModelAndView(view);
		System.out.println("Home");

		return mav;
	}

	@PostMapping("/registration")
	public ModelAndView registration(Customer customer) {
		System.out.println(customer);
		String view = "success";
		ModelAndView mav = null;
		try {
			boolean ch = false;
			ch = customerService.registerCustomer(customer);
			if (ch) {
				mav = new ModelAndView(view);
			} else {
				view = "oyoregister";
				mav = new ModelAndView(view);
				mav.addObject("error", "error in registering the details");
			}
		} catch (OnlineHotelException e) {
			e.printStackTrace();
		}
		return mav;
	}

}
