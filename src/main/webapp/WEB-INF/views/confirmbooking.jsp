<!DOCTYPE html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Business Frontpage - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->

    <!-- Custom styles for this template -->
    <link href="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://blackrockdigital.github.io/startbootstrap-business-frontpage/css/business-frontpage.css" rel="stylesheet">
    <script src="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  
  </head>

  <body >

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-image: url('../images/logo2.jpg');background-repeat: no-repeat;background-color: black;background-size: contain;background-position: 6%"><!-- bg-dark navbar-dark --><!--  style="background-color: transparent;color:black;" -->
      <div class="container">
        <a class="navbar-brand" href="https://www.google.com" target="_blank"><!-- <span><img src="../images/logo.jpg" width="100px" height="100px"></span> -->Paradise Hotels</a>
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
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

   

    <!-- Page Content -->
    <div class="container">
    <div id="print-content">
    <h1 class="display-3 text-center text-black mt-4">Bill Invoice</h1>
   <p style="float: right;">Booking Id:${bookingdetailslist[0].bid.bid}</p>
    <br><br>    <br><br>
    Customer Name: ${customer.custName}<br>
    Customer Phone No: ${customer.phoneNo}
    
    <br>
    <br>
     Hotel Booked:${bookingdetailslist[0].roomId.hotelId.hotelName}  
    

      <div>
           <strong>Bookings:</strong>
   <table class="table table-striped table-bordered">

           <tr>
           <th>Room No</th>
           <th>Room Type</th>
           <th>Check In</th>
           <th>Check Out</th>  
           <th>Price(in $)</th></tr>
 <c:forEach items="${bookingdetailslist}" var="bookingdetails">
<tr><td>${bookingdetails.roomId.roomId}</td>
<td>${bookingdetails.roomId.roomTypeId.type}</td>
<td>${bookingdetails.checkIn}</td>
<td>${bookingdetails.checkOut}</td>
<td>${bookingdetails.roomId.price}</td></tr>
    </c:forEach>
    </table>
<%--     <strong style="padding-left: 69%;">Total Amount  : ${amount}</strong> --%>
        <strong style="padding-left: 69%;float: right;">Total Amount  : $ ${amount}</strong>
    </div>
<!--       <input type="button" onclick="printDiv('print-content')" value="print a div!"/> -->
    
    </div>
      
      <input type="button" onclick="printDiv('print-content')" value="Print Invoice">


    </div>
    <!-- /.container -->
<br><br><br>
    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Paradise Hotels 2018</p>
      </div>
      <!-- /.container -->
    </footer>




<script type="text/javascript">
    function printdiv(divName) {
        var printContents = document.getElementById(divName).innerHTML;
        w=window.open();
        w.document.write(printContents);
        w.print();
        w.close();
    }
</script>

    <script language="javascript" type="text/javascript">
        function printDiv(divID) {
            //Get the HTML of div
            var divElements = document.getElementById(divID).innerHTML;
            //Get the HTML of whole page
            var oldPage = document.body.innerHTML;

            //Reset the page's HTML with div's HTML only
            document.body.innerHTML = 
              "<html><head><title></title></head><body>" + 
              divElements + "</body>";

            //Print Page
            window.print();

            //Restore orignal HTML
            document.body.innerHTML = oldPage;

          
        }
    </script>
  </body>

</html>

