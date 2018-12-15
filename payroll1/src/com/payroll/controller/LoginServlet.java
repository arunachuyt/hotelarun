package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.dao.EmployeeDAO;
import com.payroll.dao.LoginDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Employee;
import com.payroll.model.LoginDetails;
import com.payroll.model.LoginDetailsValidate;
import com.payroll.services.LoginService;
import com.payroll.util.ConnectionUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Login servlet for login check", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LoginServlet Initialization");

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy LoginServlet");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("POst of login servlet");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Connection connection = null;
		PrintWriter out = response.getWriter();

		LoginDetails login = new LoginDetails(username, password);
		
		LoginDetailsValidate validate=new LoginDetailsValidate();
		
		
		
		
		LoginService loginService = new LoginService();
		boolean check = false;
		String page = "login.jsp";
		try {
			
			boolean checkLogin=	validate.validateLoginDetails(login);
			System.out.println("validate check"+checkLogin);
			
			
			if(checkLogin){
			check = loginService.loginCheck(login);
			System.out.println("db check"+check);
			if (check) {
				// out.println("WelCome to servlets " + username+" Home page
				// displayed");

				HttpSession session = request.getSession();
				session.setAttribute("user", login);

				EmployeeDAO empdao = new EmployeeDAO();
				List<Employee> employees = empdao.fetchAllData(null);

				request.setAttribute("list", employees);
				System.out.println("Logged in" + "Home page displayed");

				page = "success.jsp";

			} else {
				// out.println("Cannot login" + "Error page");

				System.out.println("Cannot login" + "Error page");

				request.setAttribute("error", "Username or password is wrong");

				page = "login.jsp";

			}
			}else{
				
				throw new PayrollException("Username and Password should correctly be provided");
			}
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMessage());

		}

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}
}
