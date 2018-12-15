package com.payroll.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sdfsdf
 */
@WebServlet(
		urlPatterns = { "/sdfsdf" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc/url", description = "url for jdbc"), 
				@WebInitParam(name = "username", value = "admin")
		})
public class sdfsdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sdfsdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
ServletConfig config=		this.getServletConfig();
String urlValue=	config.getInitParameter("url");
String userValue=	config.getInitParameter("username");
System.out.println("Servlet config url= "+urlValue);
System.out.println("Servlet Config userName "+userValue);


	// get servlet context object
ServletContext application=  this.getServletContext();
// get value from web.xml value whose key=driver
String driver=application.getInitParameter("driver");

System.out.println("Value from context web.xml"+driver);
	
//without adding to web.xml add value to context object
application.setAttribute("driverName", "driver");

//without adding to web.xml get value from context object
String a=(String)application.getAttribute("driverName");
//without adding to web.xml remove value to context object
application.removeAttribute("driverName");

	
	}

}
