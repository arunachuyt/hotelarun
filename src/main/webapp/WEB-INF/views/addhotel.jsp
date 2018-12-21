<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
<input type="text" placeholder="HotelName">
<select name="locationId" >
<c:forEach items="${locations}" var="location">
<option value="${location. locationId}" selected="selected"> ${location.locationName}</option>
</c:forEach>
</select>
<c:forEach items="${RoomTypes}" var="roomtype">
No. of rooms of type ${roomtype.type}<input type="text" placeholder="No of room" name="${roomtype.typeid}">
</c:forEach>
<input type="submit" value="Add Hotel">
</form>
</body>
</html>