package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.dao.EmployeeDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Employee;
import com.payroll.services.EmployeeService;
import com.payroll.util.ConnectionUtil;

/**
 * Servlet implementation class ListEmployeeServlet
 */
@WebServlet(urlPatterns="/ListEmployeeServlet"
,initParams=@WebInitParam(name="url2",value="dbcd//locajhost//url"))


public class ListEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = null;

		try {
			out=response.getWriter();
			
			ServletConfig config=		this.getServletConfig();
			String urlValue=	config.getInitParameter("url");
			String userValue=	config.getInitParameter("username");
			System.out.println("Servlet config url= "+urlValue);
			System.out.println("Servlet Config userName "+userValue);

			ServletContext application=  this.getServletContext();	
			String driver=application.getInitParameter("driver");

			System.out.println("Value from context web.xml"+driver);
			String a=(String)application.getAttribute("driverName");	
			
			System.out.println("get Serrvlet context drivername = "+a);
			//connObj = ConnectionUtil.getConnection();

//ServletConfig config=	this.getServletConfig();
//String url=config.getInitParameter("url");

//System.out.println(url);
			EmployeeService dao = new EmployeeService();
			List<Employee> list = dao.fetchAllData(null);

			list.forEach(out::println);

		}  catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			}

		

	}

}
