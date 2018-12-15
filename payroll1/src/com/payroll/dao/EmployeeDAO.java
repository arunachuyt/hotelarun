package com.payroll.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

public class EmployeeDAO {

	public EmployeeDAO() {
		// TODO Auto-generated constructor stub
	}

public String	updateWholeEmp(Employee employee,String[] skills)throws PayrollException{
		
	String message="";
	Connection connObj=null;
	try {
		EmployeeService employeeDAO=new EmployeeService();
		connObj=ConnectionUtil.getConnection();
		connObj.setAutoCommit(false);
		
		employeeDAO.updateEmployee(connObj, employee);
		
		
		AddressService addressDAO=new AddressService();
		addressDAO.updateAddress(connObj, employee.getAddress());
		
		SkillSetService dao=new SkillSetService();
		dao.removeSkillSet(connObj, employee.getEmpId());
		
		for (String skillId:skills) {
			
			EmployeeSkillSet skillSet=new EmployeeSkillSet();
			skillSet.setEmpSkillSetId(Integer.parseInt(skillId));
			skillSet.setEmployee(employee);
			dao.registerSkillSet(connObj, skillSet);
		}
		
		
		//PrintWriter out=response.getWriter();
		connObj.commit();
		System.out.print("Updated successfully");
		
		message="Updated successfully";
} catch (PayrollException e) {
	// TODO Auto-generated catch block
	try {
		connObj.rollback();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		throw new PayrollException("Rollback "+e1.getMessage());
		//e1.printStackTrace();
	}
	e.printStackTrace();
	throw new PayrollException("Rollback update  "+e.getMessage());
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	try {
		connObj.rollback();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		throw new PayrollException("Rollback "+e1.getMessage());
		
	}
	
	e.printStackTrace();
	
	
}


return message;

		
		
		
	}
	
	
public String  saveWholeEmp(Employee employee ,String[] skills)throws PayrollException{
	Connection connObj = null;
	String message="";
	try {
		connObj = ConnectionUtil.getConnection();
		connObj.setAutoCommit(false);

		AddressService addressDAO = new AddressService();
		int addressId = addressDAO.registerAddress(connObj, employee.getAddress());
		employee.getAddress().setAddressId(addressId);
		//employee.setAddress(address);
		//employee.getDepartment().setDepartment(department);

		EmployeeService dao = new EmployeeService();
		int empId = dao.registerEmployee(connObj, employee);
		employee.setEmpId(empId);

		SkillSetService skillSetdao = new SkillSetService();

		for (String string : skills) {

			int skillId = Integer.parseInt(string);
			EmployeeSkillSet employeeSkillSet = new EmployeeSkillSet();
			employeeSkillSet.setEmpSkillSetId(skillId);
			Skills skils = new Skills();
			skils.setSkillId(skillId);

			employeeSkillSet.setSkills(skils);
			employeeSkillSet.setEmployee(employee);
			skillSetdao.registerSkillSet(connObj, employeeSkillSet);
			connObj.commit();

		}
		connObj.commit();

		if (empId != 0) {
			message="You are empid is " + empId;
			System.out.print("You are empid is " + empId);
			System.out.println("Please remember for future ");

		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block

		try {
			connObj.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new PayrollException("Error while roll back");
		}
		e.printStackTrace();

	} catch (PayrollException e) {
		// TODO Auto-generated catch block
		try {
			connObj.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new PayrollException("Error while roll back");
		}
		e.printStackTrace();
	} finally {

		try {
			connObj.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PayrollException("Error while closing connection");
			
			//e.printStackTrace();
		}

	}
	return message;

	
	
}
	
	
	
	
	public List<Employee> fetchAllData( String name) throws PayrollException {

		List<Employee> employees = new ArrayList<Employee>();

		boolean flag = false;
		String query = "select  e.*,ed.*,d.* , "
				+ "group_concat(s.skill_name) as skills from "
				+ " employee e inner join" + " emp_address ed" 
				+ " inner join department d" 
				+ " inner join skills s "
				+ " inner join emp_skillset sk" 
				+ " on ed.address_id=e.fk_address_id"
				+ " and e.fk_dept_id=d.dept_id "
				+ " and  e.emp_id=sk.fk_emp_id"
				+ " and s.skill_id=fk_skill_id"
				+ " group by e.emp_id";

		String queryByName = "select  e.*,ed.*,d.* ,  " 
				+ " group_concat(s.skill_name) as skills from "
				+ " employee e inner join" 
				+ " emp_address ed"
				+ " inner join department d" 
				+ " inner join skills s "
				+ " inner join emp_skillset sk" 
				+ " on ed.address_id=e.fk_address_id" 
				+ " and e.fk_dept_id=d.dept_id "
				+ " and  e.emp_id=sk.fk_emp_id" 
				+ " and s.skill_id=fk_skill_id"
				+ " where e.emp_name like ? group by e.emp_id ";
		// Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Connection connObj = null;
		try {
			connObj = ConnectionUtil.getConnection();

			if (name == null) {
				pstmt = connObj.prepareStatement(query);
				System.out.println(query);
			} else {
				pstmt = connObj.prepareStatement(queryByName);
				pstmt.setString(1, "%" + name + "%");
				System.out.println(queryByName);

			}
			result = pstmt.executeQuery();

			while (result.next()) {

				int eid = result.getInt("emp_id");
				String ename = result.getString("emp_name");
				double salary = result.getDouble("emp_salary");

				int aid = result.getInt("address_id");
				String street = result.getString("street");
				String city = result.getString("city");
				String state = result.getString("state");
				String country = result.getString("country");

				Address address = new Address(aid, street, city, state, country);

				int did = result.getInt("dept_id");
				String dname = result.getString("dept_name");
				String dlocation = result.getString("dept_location");

				Department department = new Department(did, dname, dlocation);

				
				
				String skills = result.getString("skills");

				Employee employee = new Employee(eid, ename, salary);
				employee.setAddress(address);
				employee.setDepartment(department);
				employee.setSkillStr(skills);

				employees.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PayrollException("emp DAo problem " + e);

		} finally {
			try {

				if (result != null) {
					result.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (connObj != null) {
					connObj.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PayrollException("Error while closing Object " + e);

			}
		}

		return employees;

	}
	public Employee fetchEmployeeById( int empId) throws PayrollException {

		//List<Employee> employees = new ArrayList<Employee>();

		boolean flag = false;
		String query = "select  e.*,ed.*,d.* ,s.* "
				+ " from "
				+ " employee e inner join" + " emp_address ed" 
				+ " inner join department d" 
				+ " inner join skills s "
				+ " inner join emp_skillset sk" 
				+ " on ed.address_id=e.fk_address_id"
				+ " and e.fk_dept_id=d.dept_id "
				+ " and  e.emp_id=sk.fk_emp_id"
				+ " and s.skill_id=fk_skill_id"
				+" where e.emp_id=?"
				;

		
		// Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Connection connObj = null;
		Employee employee=null;
		
		try {
			connObj = ConnectionUtil.getConnection();

			if (empId == 0) {
				throw new PayrollException("Empid is zero");
			} else {
				pstmt = connObj.prepareStatement(query);
				pstmt.setInt(1, empId);
			
			}
			result = pstmt.executeQuery();
			List<Skills> listSkills=new ArrayList<>();
			String skillStr=null;
			while (result.next()) {

				int eid = result.getInt("emp_id");
				String ename = result.getString("emp_name");
				double salary = result.getDouble("emp_salary");

				int aid = result.getInt("address_id");
				String street = result.getString("street");
				String city = result.getString("city");
				String state = result.getString("state");
				String country = result.getString("country");

				Address address = new Address(aid, street, city, state, country);

				int did = result.getInt("dept_id");
				String dname = result.getString("dept_name");
				String dlocation = result.getString("dept_location");

				Department department = new Department(did, dname, dlocation);

				
				int skillId= result.getInt("skill_id");
				String skillName = result.getString("skill_name");
			    skillStr+=skillName;
			
				Skills skills=new Skills(skillId,skillName);
				listSkills.add(skills);
				
				 employee = new Employee(eid, ename, salary);
				employee.setAddress(address);
				employee.setDepartment(department);
				

			}
			employee.setSkillsList(listSkills);
			employee.setSkillStr(skillStr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PayrollException("emp DAo problem " + e);

		} finally {
			try {

				if (result != null) {
					result.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (connObj != null) {
					connObj.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PayrollException("Error while closing Object " + e);

			}
		}

		return employee;

	}
	public int registerEmployee(Connection connObj, Employee employee) throws PayrollException {

		int generatedIdEmp = 0;
		int generatedIdDept = 0;
		int generatedIdAddress = 0;
		int generatedIdSkillSet = 0;

		boolean flag = false;
		String query = "INSERT INTO EMPLOYEE(emp_name,emp_salary,fk_address_id,fk_dept_id) VALUES(?,?,?,?)";
		// Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;

		try {
			// connObj = ConnectionUtil.getConnection();
			// connObj.setAutoCommit(false);
			/*
			 * //AddressDAO addressDAO=new AddressDAO();
			 * //addressDAO.registerAddress(connObj, employee.getAddress());
			 * //address query =
			 * "insert into emp_address(street,city,state,country)values(?,?,?,?)"
			 * ;
			 * 
			 * pstmt = connObj.prepareStatement(query);
			 * pstmt.setString(1,employee.getAddress().getStreet());
			 * pstmt.setString(2, employee.getAddress().getCity());
			 * pstmt.setString(3, employee.getAddress().getState());
			 * pstmt.setString(4, employee.getAddress().getCountry());
			 * pstmt.executeUpdate();
			 * 
			 * System.out.println(10/0); //to get generated auto increment value
			 * result=pstmt.getGeneratedKeys(); if(result.next()){
			 * 
			 * generatedIdAddress = result.getInt(1);
			 * 
			 * }
			 * 
			 * 
			 * //department query =
			 * "insert into department(dept_name,dept_location) values(?,?)";
			 * 
			 * 
			 * pstmt = connObj.prepareStatement(query);
			 * pstmt.setString(1,employee.getDepartment().getDepartmentName());
			 * pstmt.setString(2,
			 * employee.getDepartment().getDepartmentLocation());
			 * pstmt.executeUpdate();
			 * 
			 * result= pstmt.getGeneratedKeys(); if(result.next()){
			 * 
			 * generatedIdDept = result.getInt(1);
			 * 
			 * }
			 * 
			 * employee.getAddress().setAddressId(generatedIdAddress);
			 * employee.getDepartment().setDepartmentId(generatedIdDept);
			 */

			// emp
			query = "INSERT INTO EMPLOYEE(emp_name,emp_salary,fk_address_id,fk_dept_id) VALUES(?,?,?,?)";
			pstmt = connObj.prepareStatement(query);
			pstmt.setString(1, employee.getEmpName());
			pstmt.setDouble(2, employee.getEmpSalary());
			pstmt.setInt(3, employee.getAddress().getAddressId());
			pstmt.setInt(4, employee.getDepartment().getDepartmentId());

			pstmt.executeUpdate();
			result = pstmt.getGeneratedKeys();
			if (result.next()) {

				generatedIdEmp = result.getInt(1);

			}
			/*
			 * query =
			 * "insert into emp_skillset(fk_skill_id,fk_emp_id) values(?,?)";
			 * 
			 * pstmt = connObj.prepareStatement(query);
			 * 
			 * for(Skills skills:employee.getSkillsList()){
			 * 
			 * pstmt.setInt(1, skills.getSkillId()); pstmt.setInt(2,
			 * employee.getEmpId());
			 * 
			 * pstmt.executeUpdate(); result= pstmt.getGeneratedKeys();
			 * if(result.next()){
			 * 
			 * ++generatedIdSkillSet;
			 * 
			 * }
			 * 
			 * 
			 * }
			 */

			// connObj.commit();

		} catch (SQLException e) {

			throw new PayrollException("Employee DAO has problem" + e);

		} finally {
			try {
				if (result != null) {
					result.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				/*
				 * if (connObj != null) { connObj.close(); }
				 */
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PayrollException("Error while closing Object" + e);

			}
		}

		return generatedIdEmp;

	}
	
	
	
	public int updateEmployee(Connection connObj, Employee employee) throws PayrollException {

		int count = 0;
		

		boolean flag = false;
		String query = "update EMPLOYEE set "
				+ " emp_name=?,emp_salary=?,fk_dept_id=? "
				+ "where emp_id=?";
		// Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;

		try {
			// emp
			pstmt = connObj.prepareStatement(query);
			pstmt.setString(1, employee.getEmpName());
			pstmt.setDouble(2, employee.getEmpSalary());
			pstmt.setInt(3, employee.getDepartment().getDepartmentId());
			pstmt.setInt(4, employee.getEmpId());

			count =pstmt.executeUpdate();
			
			

		} catch (SQLException e) {

			throw new PayrollException("Employee DAO has problem" + e);

		} finally {
			try {
				if (result != null) {
					result.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				/*
				 * if (connObj != null) { connObj.close(); }
				 */
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PayrollException("Error while closing Object" + e);

			}
		}

		return count;

	}
	

}
