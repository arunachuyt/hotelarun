package com.payroll.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.payroll.dao.EmployeeDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Employee;
import com.payroll.util.ConnectionUtil;

public class ListEmployeeMain {

	public ListEmployeeMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmployeeDAO dao=new EmployeeDAO();
		Connection conn=null;
	try {
		conn=	ConnectionUtil.getConnection();
		List<Employee> list=	dao.fetchAllData("anji");
		list.forEach(System.out::println);
		
		System.out.println(list);
		
	} catch (PayrollException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		
	}

}
