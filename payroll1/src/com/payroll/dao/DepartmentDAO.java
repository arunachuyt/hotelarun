package com.payroll.dao;

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
import com.payroll.model.Skills;
import com.payroll.util.ConnectionUtil;


public class DepartmentDAO {

	public DepartmentDAO() {
		// TODO Auto-generated constructor stub
	}
	
public int registerDepartment(Connection connObj, Department department) throws PayrollException{
		
		int generatedId=0;
		boolean flag = false;
		String query = "insert into department(dept_name,dept_location) values(?,?)";
		//Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result=null;
		
		try {
			
			pstmt = connObj.prepareStatement(query);
			pstmt.setString(1,department.getDepartmentName());
			pstmt.setString(2, department.getDepartmentLocation());
			pstmt.executeUpdate();
			result=	pstmt.getGeneratedKeys();
		if(result.next()){
			
			generatedId =	result.getInt(1);
			
		}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			//e.printStackTrace();
			throw new PayrollException("Error while closing Object "+e);
			
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				throw new PayrollException("Error while closing Object "+e);
				
			}
		}

		
		
		
		return generatedId;
		
	}


public List<Department> fetchAllDepartments () throws PayrollException {

	//List<Employee> employees = new ArrayList<Employee>();

	boolean flag = false;
	String query = "select * from department";

	
	// Connection connObj = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	Connection connObj = null;
	Employee employee=null;
	List<Department> deptList=new ArrayList<>();
	
	try {
		connObj = ConnectionUtil.getConnection();

		
			pstmt = connObj.prepareStatement(query);
			
		
		result = pstmt.executeQuery();
			while (result.next()) {

			
			int did = result.getInt("dept_id");
			String dname = result.getString("dept_name");
			String dlocation = result.getString("dept_location");

			Department department = new Department(did, dname, dlocation);

			deptList.add(department);
			
			
			

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

	return deptList;

}



}
