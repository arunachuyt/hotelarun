<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>


body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  background-image:url("https://www.omnihotels.com/-/media/images/hotels/ausctr/pool/ausctr-omni-austin-hotel-downtown-evening-pool.jpg?h=660&la=en&w=1170");
      background-repeat:no-repeat;
      background-size: 1500px 800px;
}

.topnav {
  overflow: hidden;
  background-color: #e9e9e9;
}

.topnav a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #2196F3;
  color: white;
}

.topnav input[type=text] {
  float: right;
  padding: 6px;
  margin-top: 8px;
  margin-right: 16px;
  border: none;
  font-size: 17px;
}

@media screen and (max-width: 600px) {
  .topnav a, .topnav input[type=text] {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  }
  /* .topnav input[type=text] {
    border: 1px solid #ccc;  
  } */

.textbox{
      width: 30%;
      height: 30px;
      
      line-height: 0.5;
      color: #008040;
      border: 1px solid #408080;
      border-radius: .25rem;
      cursor: pointer;
}
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 7px 12px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}


</style>

</head>
<body>
${error}
<div class="topnav">
  <a class="active" href="adminlogin">Home</a>
  <a href="#about">About</a>
  <a href="#contact">Contact</a>
 
  <input type="text" placeholder="Search..">
</div>
<h3 style="padding-left:440px; padding-top:150px; ">Welcome,</h3>

<div class="first" style="text-align:center; padding-top:5px;">
 <form name="adminlogin" action="adminloginvalidate" method="post">
<input class="textbox" type="text" name="username" placeholder="Enter username" ><br><br>
<input class="textbox" type="password" name="password" placeholder="Enter password"><br><br>
<input class="button" type="submit" value="Login">
<!--  class="btn btn-primary btn-sm" -->
<!-- <regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}"> -->
</form>
</div>

</body>
</html>