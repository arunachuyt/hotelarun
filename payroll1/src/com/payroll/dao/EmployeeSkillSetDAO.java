package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.EmployeeSkillSet;
import com.payroll.model.Skills;
import com.payroll.util.ConnectionUtil;

public class EmployeeSkillSetDAO {

	public EmployeeSkillSetDAO() {
		// TODO Auto-generated constructor stub
	}

	public int registerSkillSet(Connection connObj, EmployeeSkillSet skillSet) throws PayrollException {

		int count = 0;
		boolean flag = false;
		String query = "insert into emp_skillset(fk_skill_id,fk_emp_id) values(?,?)";
		// Connection connObj = null;
		PreparedStatement pstmt = null;

		try {
			// connObj = ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			pstmt.setInt(1, skillSet.getEmpSkillSetId());
			pstmt.setInt(2, skillSet.getEmployee().getEmpId());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PayrollException("EmployeeSkillset problem" + e);

		} finally {
			try {

				if (pstmt != null) {
					pstmt.close();
				}

				/*
				 * if (connObj != null) { connObj.close(); }
				 */
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PayrollException("Error while closing Object " + e);
			}
		}

		return count;

	}

	public int removeSkillSet(Connection connObj, int empId) throws PayrollException {

		int count = 0;
		boolean flag = false;
		String query = "delete from emp_skillset where fk_emp_id=?";
		// Connection connObj = null;
		PreparedStatement pstmt = null;

		try {
			// connObj = ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			pstmt.setInt(1, empId);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PayrollException("EmployeeSkillset problem" + e);

		} finally {
			try {

				if (pstmt != null) {
					pstmt.close();
				}

				/*
				 * if (connObj != null) { connObj.close(); }
				 */
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PayrollException("Error while closing Object " + e);
			}
		}

		return count;

	}

}
