<!DOCTYPE html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Paradise hotels</title>

<link rel='stylesheet'
       href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css'>

<style>
.clickable {
       cursor: pointer;
}

.form-group{
width:75%;
text-align: center;
padding-left: 30%;
}
</style>

    <!-- Custom styles for this template -->
    <link href="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://blackrockdigital.github.io/startbootstrap-business-frontpage/css/business-frontpage.css" rel="stylesheet">
    <script src="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  
  </head>

  <body>
${customer}
${bookingdetails}
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
              <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">My Bookings</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Logout</a>
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
            <h1 class="display-3 text-center text-white mt-4">Select the rooms</h1>
          
           
          </div>
        </div>
      </div>
    </header>

    <!-- Page Content -->

      <!-- /.row -->
      
     
<div class="container">
      <div class="row">
<c:forEach items="${rooms}" var="room">
        <div class="col-sm-4 my-4">
          <div class="card" id="mytestclass">
            <img class="card-img-top" src="http://placehold.it/300x200" alt="">
            <div class="card-body">
              <h4 class="card-title">${room.roomId}</h4>
              <p class="card-text">${room.roomTypeId.type}</p>
     
           
           
       
           
           
            </div>
            <div class="card-footer">
             <form action="hotel?hotelId=${hotel.hotelId }">

  <a class="btn btn-primary" href="#">Book Rooms!</a><%--  href="hotel?hotelId=${hotel.hotelId }"  --%>
             </form>
            </div>
          </div>
        </div>
       
 </c:forEach>
      <script
              src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


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
