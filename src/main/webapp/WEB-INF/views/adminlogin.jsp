<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${error}
 <form name="adminlogin" action="adminloginvalidate" method="post" onsubmit="">
<input type="text" name="username" placeholder="Enter username" style="width:80%;border-radius: 4px;">
<input type="password" name="password" placeholder="Enter password" style="width:80%;">
<input type="submit" value="Login" class="btn btn-primary btn-sm">
<!-- <regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}"> -->
</form>
</body>
</html>