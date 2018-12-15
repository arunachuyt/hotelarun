<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>





<%--  <c:if test="${loginDetails.username ne null }">
<c:redirect url="success"></c:redirect>
</c:if> 
 --%>
 


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<!-- <link rel="stylesheet" href="css/style.css" type="text/css">
 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">

<!-- <script src="../js/validate.js">
</script>
 -->

<!-- <link rel="stylesheet" href="../css/style.css" type="text/css">
 -->
</head>
<body>
<div id="p1" onclick="validateDate()">
hello how are you
</div>
<div id="p2" onclick="validateDate()">
<form name="dates" onsubmit="validate1();">
<input class="textbox" type="text" name="date1"  id="date1">
<input class="textbox" type="text" name="date2"  id="date2">
<input class="btn" type="submit" name="submit"  >

</form>
</div>




	<div class="container">
	
	
	
	

		<div id="header">
			<h3>Payroll Management Sytem</h3>
		</div>
		<div id="content">


  <div class="btn-group">
    <button type="button" class="btn btn-primary">Home</button>
    <button type="button" class="btn btn-primary">Login</button>
    <div class="btn-group">
      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Sony <span class="caret"></span></button>
      <ul class="dropdown-menu" role="menu">
        <li><a href="#">Registration</a></li>
        <li><a href="#">List</a></li>
      </ul>
    </div>
  </div>
			<div id="nav">
				<h3>Navigations</h3>
				<ul>
					<li class="selected"><a href=""> Home page </a></li>
					<li><a href=""> Login</a></li>
					
					<li><a href=""> Registration</a></li>
					<li><a href=""> list </a></li>
					<li><a href="">logout </a></li>
				</ul>
			</div>

			<div id="main">





<c:if test="${error ne null }">
 <div class="alert alert-info alert-dismissible fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <c:out value="${error}"></c:out>
  </div>

</c:if>



				<form id="login" onsubmit="return helloo();" name="login" method="post" 
				action="LoginController"
				
				>
				<!-- action="/payroll/LoginServlet" -->
				

					<table>
						<tr>
							<td><label>Enter Username</label></td>

							<td><span class="glyphicon glyphicon-user"></span> <input class="textbox" type="text" name="username" ></td>
						</tr>

						<tr>
							<td><label>Enter Password </label></td>

							<td> <span class="glyphicon glyphicon-lock"></span><input class="textbox" type="password" name="password" ></td>
							<br>
						</tr>

						<tr>
							<td colspan="2"><input class="btn btn-success btn-lg" type="submit" name="submit" onclick="helloo();"
								value="Login"><br></td>
						</tr>
					</table>

				</form>

			</div>
			
			</div>

<a href="/payroll/app/register">Register</a>

			<div id="footer">Copyright &copy; payroll.com</div>



		</div>
</body>
</html>