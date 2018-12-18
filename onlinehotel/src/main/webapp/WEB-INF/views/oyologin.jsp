<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

 <style>
  /* Make the image fully responsive */
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
  </style>
<title>Insert title here</title>

<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> -->





  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


</head>


<body>



${error }
<header id="header">
<h1>Book hotels online</h1>
</header>

<form name="login" action="loginvalidate" method="post" onsubmit="return validatelogin()">
<input type="text" name="phoneNo" placeholder="Enter your 10 digit mobile number" maxlength="10" pattern="[1-9]{1}[0-9]{9}" onkeypress="return event.charCode >= 48 && event.charCode <= 57" oninput="invalidmsg(this)" title="Should enter a valid phone no i.e., first digit is not zero"><br>
<input type="password" name="password" placeholder="Enter password"  >
<input type="submit" value="login">
<!-- <regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}"> -->
<!-- title="Must contain at least one number and one uppercase and lowercase letter and one special character(!@#\$%^&*), and at least 8 or more characters" -->
</form>
<br><br><br><br>




</body>

    <footer class="py-5 bg-dark">
      <div class="container" style=";width:100%;position: fixed;color: white;">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
      <!-- /.container -->
    </footer>

<script>
function validatelogin() {
	var phoneno = document.forms["login"]["phoneno"].value;
	var pass = document.forms["login"]["password"].value;
	if (phoneno == "" || pass == "") {
		alert("phoneno and password should be filled");
		return false;
	}


	else{



	regex2=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
	if (pass.match(regex2)) {
		return true;
	} else {

		alert("Password entered is of wrong format");
		return false;
	}}

}

function invalidmsg(textbox)
{
	if(textbox.validity.patternMismatch){
        textbox.setCustomValidity('please enter valid phone number');
    }    
    else {
        textbox.setCustomValidity('');
    }
    return true;
	}


</script>


</html>













<!--       <div id="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://www.w3schools.com/howto/img_lights_wide.jpg" alt="Los Angeles" width="100%" height="10%">
      <div class="carousel-caption">
        <h3>Los Angeles</h3>
        <p>We had such a great time in LA!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="https://www.w3schools.com/howto/img_nature_wide.jpg" alt="Chicago" width="100%" height="50%">
      <div class="carousel-caption">
        <h3>Chicago</h3>
        <p>Thank you, Chicago!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="https://www.w3schools.com/howto/img_snow_wide.jpg" alt="New York" width="100%" height="50%">
      <div class="carousel-caption">
        <h3>New York</h3>
        <p>We love the Big Apple!</p>
      </div>   
    </div>
  </div>
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div> -->