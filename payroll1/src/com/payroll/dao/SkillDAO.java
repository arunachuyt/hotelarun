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

public class SkillDAO {

	public SkillDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public int registerSkill(Skills skills) throws PayrollException{
		
		int generatedId=0;
		boolean flag = false;
		String query = "insert into skills(skill_name) values(?)";
		Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result=null;
		
		try {
			connObj = ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			pstmt.setString(1, skills.getSkillName());
			
			 pstmt.executeUpdate();
			
		result=	 pstmt.getGeneratedKeys();
		if(result.next()){
			
			generatedId =	result.getInt(1);
			
		}
		
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PayrollException("Skill DAo problem "+e);
			

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
				throw new PayrollException("Error while closing Object "+e);
				
				
			}
		}

		
		
		
		return generatedId;
		
	}
	
	public List<Skills> fetchAllSkills() throws PayrollException {

		//List<Employee> employees = new ArrayList<Employee>();

		boolean flag = false;
		String query = "select * from skills";
				;

		
		// Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Connection connObj = null;
		Employee employee=null;
		List<Skills> listSkills=new ArrayList<>();
		
		
		try {
			connObj = ConnectionUtil.getConnection();

			 
				pstmt = connObj.prepareStatement(query);
				result = pstmt.executeQuery();
			
			
			
			String skillStr=null;
			while (result.next()) {

				
				
				int skillId= result.getInt("skill_id");
				String skillName = result.getString("skill_name");
			   
				Skills skills=new Skills(skillId,skillName);
				listSkills.add(skills);
				
				
				

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

		return listSkills;

	}
	
	
	
	
	
	
	

}
