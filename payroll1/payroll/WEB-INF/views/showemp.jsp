
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>

<link rel="stylesheet" href="css/style.css" type="text/css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="container">

		<div id="header">
			<h3>Payroll Management Sytem</h3>
		</div>
		<div id="content">

			<div id="nav">
				<h3>Navigations</h3>
				<ul>
					<li class="selected"><a href=""> ShowEmp </a></li>
					<li><a href=""> Registration</a></li>
					<li><a href=""> list </a></li>
					<li><a href="">logout </a></li>
				</ul>
			</div>

			<div id="main">

			<form name="update" method="post" action="update">
<input type="hidden" name="empId" value="${employee.empId}">
			<br>
			<input type="hidden" name="addressId"
				value="${employee.address.addressId}">
			
		<table>

			

			<tr>
				<td><label>EmployeeName</label></td>
				<td><input class="textbox" type="text" name="empName"
					value="${employee.empName}"></td>
</tr>
<tr>
				<td><label> Enter EmployeeSalary</label></td>
				<td><input class="textbox" type="text" name="empSalary"
					value="${employee.empSalary}"></td>
			</tr>

			<tr>
				<td><label> Select Department</label></td>
				<td><select class="dropdown" name="department.departmentId">
						<c:forEach items="${deptList }" var="department">

							<c:if
								test="${ employee.department.departmentId 
					eq department.departmentId}">
								<option value="${department.departmentId}
						"
									selected="selected">${department.departmentName }
							</c:if>
							<c:if
								test="${employee.department.departmentId 
					ne department.departmentId}">
								<option value="${department.departmentId}
						">${department.departmentName }
							</c:if>




						</c:forEach>
				</select></td>
			</tr>

			

			<tr>
				<td><label> Enter street</label></td>
				<td><input class="textbox" type="text" name="address.street"
					value="${employee.address.street}"></td>
</tr><tr>
				<td><label> Enter city</label></td>
				<td><input class="textbox" type="text" name="address.city"
					value="${employee.address.city}"></td>
			</tr>

			<tr>
				<td><label> Enter state</label></td>
				<td><input type="text" name="address.state" class="textbox"
					value="${employee.address.state}"></td>
		</tr><tr>
				<td><label>Enter country</label></td>
				<td><input class="textbox" type="text" name="address.country"
					value="${employee.address.country}"></td>
			</tr>


<tr>
				<td><label> Select Skills</label></td>

				<td><c:forEach items="${skillList }" var="skill">

						<c:if
							test="${fn:containsIgnoreCase(employee.skillStr,skill.skillName)}">
							<input type="checkbox" name="skills" value="${skill.skillId}"
								checked>${skill.skillName}
			
									</c:if>
						<c:if
							test="${!fn:containsIgnoreCase(employee.skillStr,skill.skillName)}">
							<input type="checkbox" name="skills" value="${skill.skillId}">${skill.skillName}
		</c:if>




					</c:forEach>

				
				</td>

			</tr>


			<!-- Select Skills 
<input type="checkbox" name="skills" value="1"> JAVA
<input type="checkbox" name="skills" value="2"> .NET
<input type="checkbox" name="skills" value="3"> php
<input type="checkbox" name="skills" value="4"> C
<input type="checkbox" name="skills" value="5"> CPP
<input type="checkbox" name="skills" value="6"> HTML
 -->
			<tr>
				<td><input class="btn" type="submit" name="submit"
					value="Update"><br></td>
			</tr>
		</table>



	</form>
			
			</div>



			<div id="footer">Copyright &copy; payroll.com</div>



		</div>










	
</body>
</html>