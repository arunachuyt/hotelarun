package com.payroll.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.dao.DepartmentDAO;
import com.payroll.dao.EmployeeDAO;
import com.payroll.dao.SkillDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Department;
import com.payroll.model.Employee;
import com.payroll.model.Skills;

/**
 * Servlet implementation class GetEmpServlet
 */
@WebServlet("/GetEmpServlet")
public class GetEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
	String eid=	request.getParameter("empId");
	int empId=Integer.parseInt(eid);
	
	EmployeeDAO employeeDAO=new EmployeeDAO();
	try {
		Employee employee=employeeDAO.fetchEmployeeById(empId);
	    DepartmentDAO deptDao=new DepartmentDAO();
	    SkillDAO skillDao=new SkillDAO();
	  List<Skills> skillList=  skillDao.fetchAllSkills();
	    List<Department> listDept=    deptDao.fetchAllDepartments();
		request.setAttribute("skillList", skillList);
		request.setAttribute("deptList", listDept);
		request.setAttribute("employee", employee);
		// data all emp dept
		// dat of skills 
		
	
	} catch (PayrollException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		request.setAttribute("error", "Some internal DB error");
	}
	
	request
	.getRequestDispatcher("showemp.jsp")
	.forward(request, response);
	
	
	
	
	
	
	
	}

}
