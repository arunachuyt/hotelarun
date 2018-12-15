package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.dao.AddressDAO;
import com.payroll.dao.EmployeeDAO;
import com.payroll.dao.EmployeeSkillSetDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Address;
import com.payroll.model.Department;
import com.payroll.model.Employee;
import com.payroll.model.EmployeeSkillSet;
import com.payroll.model.Skills;
import com.payroll.services.AddressService;
import com.payroll.services.EmployeeService;
import com.payroll.services.SkillSetService;
import com.payroll.util.ConnectionUtil;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		String empName = request.getParameter("empName");
		String salary = request.getParameter("empSalary");
		double empSalary = Double.parseDouble(salary);

		String did = request.getParameter("departmentId");
		int departmentId = Integer.parseInt(did);

		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");

		String[] skills = request.getParameterValues("skills");

		Employee employee = new Employee(0, empName, empSalary);

		Department department = new Department();
		department.setDepartmentId(departmentId);

		Address address = new Address(0, street, city, state, country);
        employee.setAddress(address);
        employee.setDepartment(department);
        
		
        
        EmployeeService employeeService=new EmployeeService();
        String path="success.jsp";
        String message="";
        try {
			message=employeeService.saveWholeEmp(employee, skills);
		    
			request.setAttribute("message", message);
        
        } catch (PayrollException e) {
			// TODO Auto-generated catch block
			path="error.jsp";
			request.setAttribute("error", e.getMessage());
		}
        
        request.getRequestDispatcher(path).forward(request, response);
        
        

	}

}
