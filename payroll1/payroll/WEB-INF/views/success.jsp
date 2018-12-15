
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" href="css/style.css" type="text/css">
 --><meta name="viewport" content="width=device-width, initial-scale=1">
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<!-- <link rel="stylesheet" href="css/style.css" type="text/css">
 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<div class="container">

  
  <c:if test="${message ne null }">
 <div class="alert alert-success">
 
  <c:out value="${message}"></c:out>
   </div>
  </c:if>
 
 <c:if test="${error ne null }">
 <div class="alert alert-danger">
 
  <c:out value="${error}"></c:out>
   </div>
  </c:if>



		<div class="page-header">
			<h3>Payroll Management Sytem</h3>
		</div>
		<div id="content">

			<div id="nav">
				<h3>Navigations</h3>
				<ul class="list-group">
					<li class="list-group-item" class="selected"><a href=""> Home </a></li>
					<li class="list-group-item"><a href=""> Registration</a></li>
					<li class="list-group-item"><a href=""> list </a></li>
					<li class="list-group-item"><a href="">logout </a></li>
				</ul>
			</div>

			
			<div id="employees" class="table-responsive">
<table class="table table-hover ">
<caption><b>Employee List</b></caption>

 <a href="#">List <span class="badge"><c:out value="100"></c:out></span></a><br>
 

<c:forEach items="${list}" var="employee">

<tr>

<input type="hidden" name="empId" value="${employee.empId}">
<td class="info"><label>EmployeeName</label></td>
<td class="success">${employee.empName}</td>
<td class="info"><label>EmployeeSalary</label></td>
<td class="success">${employee.empSalary }</td>
</tr>

<tr>
<td class="info"><label>Department Name</label></td>
<td class="success">${employee.department.departmentName }</td>
<td class="info"><label>depaartment location</label></td>
<td class="success">${employee.department.departmentLocation }</td>
 <td class="info"><label> Street</label></td>
 <td class="success">${employee.address.street }</td>
</tr>
<tr>
<td class="info"><label>City</td>
<td class="success">${employee.address.city }</td>
<td class="info"><label>State</label></td>
<td class="success">${employee.address.state }</td>
<td class="info"><label>country</label></td>
<td class="success">${employee.address.country }</td>
</tr>

<tr>
<td class="info"><label>Employee skill</label></td>
<td class="success">${employee.skillStr }</td>
<td class="warning"><a class="btn btn-warning"  href="getemp?empId=${employee.empId }">Edit</a></td>
<td class="danger"><a class="btn btn-danger" href="">Delete</a></td>

</tr>



</c:forEach>

</table>
</div>
			
			<div id="main">

				Success page
<%-- ${list } --%>



<a class="btn" href="logout">Logout</a>
<a class="btn" href="ListEmployeeServlet">List</a>



			</div>
			
			</div>



			<div id="footer">Copyright &copy; payroll.com</div>



		</div>





</body>
</html>