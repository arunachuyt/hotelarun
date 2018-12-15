package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

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
import com.payroll.services.AddressService;
import com.payroll.services.EmployeeService;
import com.payroll.services.SkillSetService;
import com.payroll.util.ConnectionUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	Connection connObj=null;
		
		String eid=request.getParameter("empId");
		int empId=Integer.parseInt(eid);
		String empName = request.getParameter("empName");
		String salary = request.getParameter("empSalary");
		double empSalary = Double.parseDouble(salary);
		Employee employee=new Employee(empId, empName, empSalary);
		
		
		String did = request.getParameter("departmentId");
		int departmentId = Integer.parseInt(did);
		
		Department department=new Department();
		department.setDepartmentId(departmentId);
		employee.setDepartment(department);
		
		
		String aid = request.getParameter("addressId");
		int addressId=Integer.parseInt(aid);
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		
		Address address=new Address(addressId, street, city, state, country);
		

		String[] skills = request.getParameterValues("skills");
		
		
		try {
				EmployeeService employeeDAO=new EmployeeService();
				connObj=ConnectionUtil.getConnection();
				connObj.setAutoCommit(false);
				
				employeeDAO.updateEmployee(connObj, employee);
				
				
				AddressService addressDAO=new AddressService();
				addressDAO.updateAddress(connObj, address);
				
				SkillSetService dao=new SkillSetService();
				dao.removeSkillSet(connObj, empId);
				
				for (String skillId:skills) {
					
					EmployeeSkillSet skillSet=new EmployeeSkillSet();
					skillSet.setEmpSkillSetId(Integer.parseInt(skillId));
					skillSet.setEmployee(employee);
					dao.registerSkillSet(connObj, skillSet);
				}
				
				
				PrintWriter out=response.getWriter();
				connObj.commit();
				out.print("Updated successfully");
				
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			try {
				connObj.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connObj.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
