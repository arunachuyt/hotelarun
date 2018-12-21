<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("button").click(function(){
    $("#addlocation").toggle();
  });
});
</script>
</head>
<body>

<table>
<thead>
<tr>
<th>Location Id</th>
<th>Location Name</th>
</tr>
</thead>
<tbody>
<c:forEach items="${locations}" var="location">
<tr>
<td>${location.locationId}</td>
<td>${location.locationName}</td>
</tr>
</c:forEach>
</tbody>
</table>
<br>
<button >AddLocation</button>
<div id="addlocation">
<form action="" method="post">
Location Name<input type="text" name="locationName" placeholder="Location Name">
<input type="submit" value="Submit">
</form>
</div>
</body>
</html>