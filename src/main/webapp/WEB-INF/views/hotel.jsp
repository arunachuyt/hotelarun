<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Paradise hotels</title>

<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css'>

<style>
.clickable {
	cursor: pointer;
}

.form-group {
	width: 75%;
	text-align: center;
	padding-left: 30%;
}

.imageheight {
	height: 66.67%;
}
</style>

<!-- Custom styles for this template -->
<link
	href="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://blackrockdigital.github.io/startbootstrap-business-frontpage/css/business-frontpage.css"
	rel="stylesheet">
<script
	src="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/jquery/jquery.min.js"></script>
<script
	src="https://blackrockdigital.github.io/startbootstrap-business-frontpage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>



</head>

<body>
	
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top"
		style="background-image: url('../images/logo2.jpg'); background-repeat: no-repeat; background-color: black; background-size: contain; background-position: 6%">
		<!-- bg-dark navbar-dark -->
		<!--  style="background-color: transparent;color:black;" -->
		<div class="container">
			<a class="navbar-brand" href="#">
				<!-- <span><img src="../images/logo.jpg" width="100px" height="100px"></span> -->Welcome
				${customer.custName }
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="location">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="listAllBooking">My
							Bookings</a></li>
					<li class="nav-item"><a class="nav-link" target="blank" href="gallery">Gallery</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Header with Background Image -->
	<header class="business-header" id="headertesting"
		style="background-image: url('https://images.pexels.com/photos/189296/pexels-photo-189296.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2&amp;h=650&amp;w=940');">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="display-3 text-center text-white mt-4">Select your
						Desired Location</h1>


				</div>
			</div>
		</div>
	</header>


	<form action="gethotelid" method="get">
		<div id="container" style="padding-top: 3%">
			<div class="form-group">
				<input id="dp1" type="text" class="form-control clickable input-md"
					id="DtChkIn" placeholder="&#xf133;  Check-In" required="required"
					name="checkIn">
			</div>
			<div class="form-group">
				<input id="dp2" type="text" class="form-control clickable input-md"
					id="DtChkOut" placeholder="&#xf133;  Check-Out" name="checkOut">
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:forEach items="${hotels}" var="hotel">
					<div class="col-sm-6 col-lg-3 col-md-4 my-4">
						<div class="card" id="mytestclass">

							<img class="card-img-top"
								src="../images/hotelsimg/${hotel.hotelId}.jpg" alt="">

							<div class="card-body">
								<h4 class="card-title">${hotel.hotelName }</h4>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Sapiente esse necessitatibus neque sequi
									doloribus.</p>
							</div>
							<div class="card-footer">
								<input type="hidden" value="${hotel.hotelId}" name="hotelId">
								<input type="submit" class="btn btn-primary" value="Book Rooms!">
								<%--  <a href="gethotelid?hotelId=${hotel.hotelId}" class="btn btn-primary">Book Rooms!</a> --%>
							</div>
						</div>
					</div>
				</c:forEach>
				<script
					src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

				<script
					src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js'></script>
				<script>
					var nowTemp = new Date();
					var now = new Date(nowTemp.getFullYear(), nowTemp
							.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

					var checkin = $('#dp1').datepicker({

						beforeShowDay : function(date) {
							return date.valueOf() >= now.valueOf();
						},
						autoclose : true
					}).

					on(
							'changeDate',
							function(ev) {
								if (ev.date.valueOf() > checkout.datepicker(
										"getDate").valueOf()
										|| !checkout.datepicker("getDate")
												.valueOf()) {

									var newDate = new Date(ev.date);
									newDate.setDate(newDate.getDate() + 1);
									checkout.datepicker("update", newDate);

								}
								$('#dp2')[0].focus();
							});

					var checkout = $('#dp2').datepicker(
							{
								beforeShowDay : function(date) {
									if (!checkin.datepicker("getDate")
											.valueOf()) {
										return date.valueOf() >= new Date()
												.valueOf();
									} else {
										return date.valueOf() > checkin
												.datepicker("getDate")
												.valueOf();
									}
								},
								autoclose : true
							}).

					on('changeDate', function(ev) {
					});
					//# sourceURL=pen.js
				</script>


			</div>
			<!-- /.row -->

		</div>
	</form>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2018</p>
		</div>
		<!-- /.container -->
	</footer>

</body>

</html>
