package com.payroll.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.payroll.dao.AddressDAO;
import com.payroll.dao.EmployeeDAO;
import com.payroll.dao.EmployeeSkillSetDAO;
import com.payroll.dao.LoginDAO;
import com.payroll.exceptions.PayrollException;
import com.payroll.model.Address;
import com.payroll.model.Department;
import com.payroll.model.Employee;
import com.payroll.model.EmployeeSkillSet;
import com.payroll.model.LoginDetails;
import com.payroll.model.Skills;
import com.payroll.util.ConnectionUtil;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Connection connection = null;
		try {
		
		connection = ConnectionUtil.getConnection();
			
		connection.setAutoCommit(false);
		
		LoginDetails login=new LoginDetails("admin", "admin");
		LoginDAO dao=new LoginDAO();
	boolean check=	dao.loginCheck(login);

	if(check){
		System.out.println("Logged in"+"Home page displayed");
	}else{
		
		System.out.println("Cannot login"+"Error page");
	}
	
	
	Department dept=new Department(10,"HR","Chennai");
	Address address=new Address(0, "redhouse", "chennai", "tamilnadu", "india");
	
	Skills skill1=new Skills(2, "php");
	Skills skill2=new Skills(4, "c");
	List<Skills> list=new ArrayList<>();
	list.add(skill1);
	list.add(skill2);
	
	
	AddressDAO addressDao=new AddressDAO();
	int addressId=addressDao.registerAddress(connection,address);
	address.setAddressId(addressId);
	
	Employee employee=new Employee(0,"raju",1234);
	employee.setAddress(address);
	employee.setDepartment(dept);
	employee.setSkillsList(list);

	EmployeeDAO empDao=new EmployeeDAO();
	int empId=empDao.registerEmployee(connection,employee);
	System.out.println("The emp registered"+empId);
	employee.setEmpId(empId);
	System.out.println(empId);
	
	EmployeeSkillSet skillSet1=new EmployeeSkillSet(0, skill1, employee);
	EmployeeSkillSet skillSet2=new EmployeeSkillSet(0, skill2, employee);
	
	
	EmployeeSkillSetDAO employeeSkillSetDAO=new EmployeeSkillSetDAO();
	employeeSkillSetDAO.registerSkillSet(connection,skillSet1);
	employeeSkillSetDAO.registerSkillSet(connection,skillSet2);
	
	connection.commit();
	
		} 
		
		catch(PayrollException  e){
			System.out.println(e);
			
			
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("error wwhile rollback");
				e.printStackTrace();
			}
			e.printStackTrace();
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("error wwhile rollback");
			}
			e.printStackTrace();
		}
		
		finally {
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error wwhile closing");
			}
		}
	
	
	}

}
