
 <!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Paradise hotels</title>

    <!-- Bootstrap core CSS -->
<!--     <link href="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- <script
       src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
       src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<!-- <link rel="stylesheet" href="../css/hotel1.css">
<link rel="stylesheet" href="../css/hotel2.css"> -->
    <!-- Custom styles for this template -->
    <link href="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://blackrockdigital.github.io/startbootstrap-business-frontpage/css/business-frontpage.css" rel="stylesheet">
    <script src="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- <link rel="stylesheet"
       href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> -->
  
  
  
  </head>

  <body >

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-image: url('../images/logo2.jpg');background-repeat: no-repeat;background-color: black;background-size: contain;background-position: 6%"><!-- bg-dark navbar-dark --><!--  style="background-color: transparent;color:black;" -->
      <div class="container">
        <a class="navbar-brand" href="#"><!-- <span><img src="../images/logo.jpg" width="100px" height="100px"></span> -->Welcome ${customer.custName }</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="location">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="listAllBooking">My Bookings</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="gallery" target="blank">Gallery</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="logout">Logout</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Header with Background Image -->
    <header class="business-header" id="headertesting" style="background-image: url('https://images.pexels.com/photos/189296/pexels-photo-189296.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2&amp;h=650&amp;w=940');">      
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <h1 class="display-3 text-center text-white mt-4">Select your Desired Location</h1>
          </div>
        </div>
      </div>
    </header>

   
<div class="container">
      <div class="row">
<c:forEach items="${locations}" var="location">
        <div class="col-sm-4 my-4">
          <div class="card">
            <img class="card-img-top" src="../images/${location.locationName}.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">${location.locationName }</h4>
             <!--  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque sequi doloribus.</p> -->
            </div>
            <div class="card-footer">
              <a href="getlocationid?locationId=${location.locationId}" class="btn btn-primary">Choose hotels!</a>
            </div>
          </div>
        </div>
</c:forEach>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
      <!-- /.container -->
    </footer>





</body>

</html>
 