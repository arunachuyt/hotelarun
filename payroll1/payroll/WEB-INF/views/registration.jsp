<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${error}
	<div id="container">

		<div id="header">
			<h3>Payroll Management Sytem</h3>
		</div>
		<div id="content">

			<div id="nav">
				<h3>Navigations</h3>
				<ul>
					<li><a href=""> Login </a></li>
					<li><a class="selected" href=""> Registration</a></li>
					<li><a href=""> list </a></li>
					<li><a href="logout">logout </a></li>
				</ul>
			</div>

			<div id="main">

				<form name="register"  method="post" action="reg">

					<table>
						<tr>
							<td><label>Enter EmployeeName</label></td>
							<td><input class="textbox" type="text" name="empName"
									name="empName" /></td>
						</tr>

						<tr>
							<td><label>Enter EmployeeSalary</label></td>
							<td><input type="text" class="textbox" name="empSalary"
									name="empSalary" /></td>
						</tr>

						<tr>
							<td><label>Select Department</label></td>
							<td><select  class="dropdown"
									name="department.departmentId">
									<option value="10">HR</option>
									<option value="20">HR</option>
									<option value="30">TR</option>
									<option value="40">DEV</option>
									<option value="41">HRR</option>

								</select></td>
						</tr>
						<tr>
							<td><label>Enter street</label></td>
							<td><input type="text" name="address.street" class="textbox"
									 /></td>
						</tr>
						<tr>
							<td><label>Enter city</label></td>
							<td><input type="text" class="textbox" name="address.city"
									 /></td>
						</tr>
						<tr>
						<tr>
							<td><label>Enter state</label></td>
							<td><input type="text" class="textbox" name="address.state"
									 /></td>
						</tr>
						<tr>
							<td><label>Enter country</label></td>
							<td><input type="text" class="textbox" 
									name="address.country" /></td>
						</tr>

						<tr>
							<td><label>Select Skills </label></td>
							<td><input type="checkbox" name="skills" value="1"> java<input type="checkbox" name="skills" value="3"> php
								
								<input type="checkbox" name="skills" value="2"> .NET <input type="checkbox" name="skills" value="3"> php
								<input type="checkbox" name="skills" value="4"> C <input type="checkbox" name="skills" value="5"> CPP
								<input type="checkbox" name="skills" value="6"> HTML 
								
								
								
								<%-- 
								<form:checkbox path="skills"  value="1"/> JAVA
								<form:checkbox
									path="skills" value="2"/> .Net
									<form:checkbox
									path="skills" value="3"/>php
									 <form:checkbox
									path="skills" value="4"/> c
									 <form:checkbox
									path="skills" value="5"/> cpp
									 <form:checkbox
									  path="skills" value="6"/> html --%>
						</tr>
						<tr>

							<td><input class="btn" path="submit" type="submit"
									name="submit" value="Register" /></td>
						</tr>

					</table>

				</form>


			</div>

		</div>



		<div id="footer">Copyright &copy; payroll.com</div>



	</div>





</body>
</html>