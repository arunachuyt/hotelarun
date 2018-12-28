

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Paradise hotels</title>

   
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
        <a class="navbar-brand" href="#"><!-- <span><img src="../images/logo.jpg" width="100px" height="100px"></span> -->Paradise Hotels</a>
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
              <a class="nav-link" target="blank" href="gallery">Gallery</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
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
            <h1 class="display-3 text-center text-white mt-4">Make your Dream A Reality</h1>
          </div>
        </div>
      </div>
    </header>

    <!-- Page Content -->
    <div class="container">

      <div class="row">
        <div class="col-sm-8">
          <h2 class="mt-4">What We Do</h2>
         <!--  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A deserunt neque tempore recusandae animi soluta quasi? Asperiores rem dolore eaque vel, porro, soluta unde debitis aliquam laboriosam. Repellat explicabo, maiores!</p>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis optio neque consectetur consequatur magni in nisi, natus beatae quidem quam odit commodi ducimus totam eum, alias, adipisci nesciunt voluptate. Voluptatum.</p> -->
          <p>With a choice of themed rooms to suit every dream lover, you can spark your imagination and enter a world of swashbuckling pirates, brave knights or powerful pharaohs. Rooms include 2 separate sleeping areas, with a king-sized bed for adults, and a separate area for up to 3 children, complete with bunk bed, pull-out trundle bed and their very own TV.</p>
          <p>Jump into a fairytale or explore the depths of the ocean.Travel to the edges of the Universe or Live the life of a prisoner.Become the King of the Darkness or be the Warrior of Light!<br>A whole new world awaits for you</p>
          <p><strong>To jump into your fantasy world...</strong></p>
          <p>
            <a id="myBtn" class="btn btn-primary btn-lg" href="#">Register here! &raquo;</a>
          </p>
        </div>
        <div class="col-sm-4"> <!-- style="padding-left: 15% " -->
          <div style="border-style: solid;padding: 5%;margin-top: 10%">
       <h2 class="mt-4">Login</h2>
        
        <form name="login" action="loginvalidate" method="post" onsubmit="return validatelogin()">
<input type="text" name="phoneNo" placeholder="Enter your 10 digit mobile number" maxlength="10" pattern="[1-9]{1}[0-9]{9}" onkeypress="return event.charCode >= 48 && event.charCode <= 57" oninput="invalidmsg(this)" title="Should enter a valid phone no i.e., first digit is not zero" style="width:80%;border-radius: 4px;">
<input type="password" name="password" placeholder="Enter password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter and one special character(!@#\$%^&*), and at least 8 or more characters" style="width:80%;">
<input type="submit" value="Login" class="btn btn-primary btn-sm">
<!-- <regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}"> -->
</form>

</div>
          <h2 class="mt-4">Contact Us</h2>
          <address>
            <strong>Paradise Hotels</strong>
            <br>3481 Melrose Place
            <br>Beverly Hills, Hyd 500076
            <br>
          </address>
          <address>
            <abbr title="Phone">P:</abbr>
            (123) 456-7890
            <br>
            <abbr title="Email">E:</abbr>
            <a href="mailto:#">bhatta@gmail.com</a>
          </address>
        </div>
      </div>
      <!-- /.row -->

      <div class="row">
        <div class="col-sm-4 my-4">
          <div class="card">
            <img class="card-img-top" src="https://endpoint914114.azureedge.net/globalassets/windsor-2016/legoland-hotel/rooms/uvid-49ae3c/pirate-premium---box.jpg?w=1422&h=800&mode=crop&scale=both&quality=80&format=jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Pirate Themed Rooms</h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque sequi doloribus.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>
        <div class="col-sm-4 my-4">
          <div class="card">
            <img class="card-img-top" src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUTExMVFhUXGRcYGRgYGB4YGBgXGhkXGhoaGhgYHiggGBolHRcaITEhJSkrLi4uGh8zODMtNygtLisBCgoKDg0OGxAQGy8lHyUtLS0wLy0vLS0uLS0tLS8vLS0uLS0tLS0tLi0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLf/AABEIAKcBLQMBIgACEQEDEQH/xAAcAAACAwEBAQEAAAAAAAAAAAAFBgMEBwACAQj/xABJEAABAwIDBAcDCgMGBAcBAAABAgMRACEEEjEFQVFhBhMicYGRoTKxwQcUI0JSYnKy0fAzguEkQ2OSovFTc7PCFTSjpMPS4iX/xAAbAQACAwEBAQAAAAAAAAAAAAADBAECBQAGB//EADIRAAIBAwMBBgYCAgIDAAAAAAECAAMRIQQSMUETIlFxsfAFYYGRwdEyoSMzcuEUJDT/2gAMAwEAAhEDEQA/AE7pW1KGRb2nLEwTAb0MEDXU2pXU2pIhSYTPtDtC8WzA5TpWh7W2ay6011qHSZchTagMv8OZSoEKmBvGlLeI6OlPaYxAPJQLa+7UpP8Amp3VA9sYl8OX/wBZfr6wE28CCAOETJVaZggC3Ijh30Y2Dg+sUBNzYQMx8QO1HMA1TLTiTDiEnnlyqHcUxfmZq/sjEy4CCslIi4BgCwlVvcamhYMLymrDFSq8x6wTCWklThM8Z+BEn0qk/ilOGB7Pqe/9KiccW6Rm0Gg+PfRXBYKNa1Hqi1hxENF8M2HtK2W9P+5Hg8HRVpgCpGm6ttYc93vpZm8ZshZWDdSfNjuueFFG8HAk9ketD9trf6uMH1ec2lYUfJKUnzNhvoXbWysq9MMNrdZ7xeMaw7eZ1aUDidSeAAuo8hJpLxfT9xx5LWFTkClpT1iwFKMqjso0SLzeTyFAMbhXgorxqXs+mZwEeAPsxyTaoujmGnFMqGmafJJI9RWe1cu1oytEKBN/6M4MFoOk5yrNKSeZGp1MAa1inyi7QaVjXSFKQoKywT20qQAkyUkwQU6zWzbJfystpFjkT5wJ9awNzZxx+Oeyqy5nFOEkSAlbsSY/F41UBi5kuQBC+xenLrcJfl5vcsR1gHfo54weZp82djmcQjO0sLTv3EHgpJuD31ku1NgHCPqaLueIMAiIVcBVvagjSrGxtuMsLW27nQdW3krVDZMEy2hPam8k8AIprtWQXtFNiubXmsBKkmQTbncdxongNo37R8f1FJezelrZ/iOsrb/4yXEpjh1rS8qkk6SARTCw6hxIUhQUDopJBB8RY0wlRKoi70mpmN9lJ3EHxBpG6S7DTJUmEK0C4BIvpfd5RRbC45bXNPDd/wDk1YxziXU28RvolAGm2eDE9agrU7j+QiW1ilpPU4gQr6quItoTqOW6qu2NmqKTlAM/vWi+NbCh1axIHsnRSfwndQnaOKcaQELPWBUlJvmVcA2F8193pWicDPE86mal058ImYro+qM2dAPD+ukULIeSor7XZhRUEyEzYGIidwoztF5RKhlglU6KSUiQIKVExe0ayBeoG8AXJKlJBhR3btbDef6mxms56ase7PSUqjKvfIgVpSR7QUoRYTlE211kcgQeYrylKSDuN90z3ybd4FExglNrBJKSLzdJHAyASNQbbtKup2syjCKwww6S8omXlSFC/spTMCLiT5ClqgZbYjlNlbrF/DKAJkqFjGXUyCLk7rweIJqRlibzp5nTQVdKHFGSJKALpE2TbMVjW8XvVs4kBRWQkHWFFSiSfxEz42jvoi0/GUer4TsJshSgLAJm6jG+NTE24aWMUedWyylvqHVF1JSoqixNtIJuOcad1LoxvbORIVEnSARvtw5CoUbQsIIkm4y6cO0fhTCOi8RSpTepzNO6U4DrCl8plLqUry5iACUgkQLWNqSnmZWRlgDSVWA7rkjypjxG2lLwzAStY+jAMEhO/wAqUV7QIWQCV851HfEg86awEG6IUVcs1vfjLGKbSAAlIJ3mD8aobNZ/tGY/USpenKPOVDyq7h8STJPkb+tq+YdQ6t5QAkwm3mff6UOpY2jCllVh9PviCEMda+lPEye7UnymtK25ixg9ngRC3ATG/tZbf5erR/OqljoFsrrsQSQSkWMfZHaX6CP5q+fKBtQv4gpBGRvs2PZzXzEcrqI5KTwpcHat+pz+vyZdh2tUL0X3+opodIBJkqUZUeJN68Ezcj1j30UwqB7NjbhofHfQRySTelQ9haaSjdmaPt3GttpYC280hwggXF0ixkEabjVZrHMrFnY5Lkk+LgnyXX3pewScOB9hXqs/pQFXY0uaaqLdiTxFNLWKU1QC5tCuIQlSkpkXIFpH6j1ojs/ZiQYSmB743k0pYMHrkG9z8DW2bHwifmIQlCc60JWVfWKoChfhNo5ml94HSaii5ueYAwuASKJ4bBFWgn3CiuzNhHKFvHKPsg3PeRp3D0oslIEBIAA0EfCuesBhcwoUdYNweyDE7t6jYDuqyFNpHYhZ+1qPCKt4pSXU5HE5hyMactDQtzYberbikHn+osPKhKwb/Yf1KVC4/gMf3PDyio3M1XU3U6sDiE/ZcHEX916g+cwYWhST5/7U0ox3c+USZs96485IlxUFMkpOoJPlYzHLSg7PRnDtrStlAbgzAKiDYiO0ogC+4bqMNqSr2VA1JkoTopORDo7Dgz40uMvKKwxp9aO02tSZIJgkSUmUzGsG96256wJ5VjmwtkrxLiWm4kiSTolI1JjdoO8ipVRzA1mYkASm66paipaipRuSTJ8zQTaYzPZRr2RzJgacTetjwXQbDIjrVKdVFxOVE8gnteZo7gtjMt3aZQgneEgHxPtGqVBuFhCUKTIbtMawHQPGuxLaWxxcUE/6UyoeVOnRjoK/hVBfz3J9pCEylXfnMHvyz3U/pwf7/rXwtJGt/X0qiooPMYJ+UrhYmJnwrytsi6fL9OFTqdA0FRLdUeAppWMUqUgZXxLeYXEGgu0dnBxOVQ00I1B8bHuNGXeKlUKxu3sK3ZeIanhmlXkL03Tr2Fn4mPq/h127SibNM12q2pt0tKVJR9bcRAKYTFj53PifeHdz/WAIEaQCAPui54k1BtvHIdxLq0EqQcuUjsz2UjRQmLEacKnwGDOXNH60umXO3iON3aY34Nh95adCEgEkkxx0FwRbx868HDIWEwkZjIMZirXW/HSBwqti1bt+6h2JxKj7RJE3Ex7xvvU1KgXkSKVJmGDLeMeSkZGwpRvO/TgBwvfnQxx4nUQfH3frRTo8MKpSjiHFpASSkhGY5wbJAzAQb3P9QJdCoi+WZA3d/fFJtU3E2j60won1ZTuM2Goi/K99fSrDDKhbKQdLiDu46elfWcJlglUCZGZMDxm19d4ijeC2etSC4oWVOXdxvpRqNIuYCtWVBPn/AIo4hIQmyQAmeIGvnUiHkLT2wCoWGWEnxgXqm43lUBYwd36wDV1MKiEwbbyq3j8KbFybGIuqgXA+skKE5TlzaVAIDKu8eNif+4VYfEI77VG832EJGp7UfiMgeUDwq1UZ+kGhx9fSMXRrF/NcC86LLOUJO+VFenPspPekVnOLcKpM77ndz/pypp6TLKEIYB+qhSh/LCfHU+VLacApRsKXrKSdqxvSWALt19Jd2Wm4i82mKr4vZqusXGkn1vTR0f6POLIShJJ5Caa09HcM3Z99tKzFhKyLbymwNXXSAHv/AG5MC+v23CZ9PuYE6WA5mQP+F73HKXSxKgKZulCfpWv+Un87lC0dkhW8VFQErG9IFFjLPSHCJRicMhIHZbAMWvC60vZdmmvwI/KKyleIU7iUKUZP9DWsYQfRo/Cn3ClFTatjNJ2ubiXAuvYXVYm1fSqu2wd5ZzV8mq3WV3W12yV3mWQqvZeJsqFDgoA++qfW19DtVNOWFWendnsr1QUnik/A1XVshaf4T/8AKsR75HrVlLlSpcqN1QdfvmTsptm1vLEqo2W8tMLSkAiCQZHofdXYHo8yyISEIHBAAnvIufGrGJxqW0KWqYSlSjAk2BNpI4UD6OdMGsYVpQlSFJE5VxKk6SIO4xI5ihk1DDDswQOsO9W2nRNRLcPIVIQTuNCdpbZw7P8AFebQeBUJ8heuUeMlmAxLbh4moFClrFfKBg0zlWtwjclMeRcyiguN+UtISopw6gRGUOEpzyYMZEqTYXuRymiCoi9YMhjHpVROKrJ8X8peKV7KGkD8JUfMmPShL3SnGue1iFgHcmE/lANXFdYFkMZ+n3Sc3w7Rn/iHkfq+O/lA32Q0L0sLb92vP96VLkmSSok3JnUm8nia8lN/2aq7M5vB0wqC3XqZZ2SguOJQgJzKsMxSkaE3UohI8adtjJ7BCgNYtfypAKaPdFccsOFClSnKTfdcfrTWjqbXsesT+IUd9MsvSWtptEKNvCg7uEJGZWVImJJj01PhTTjChFykqMEgATYDUnhSjtDGlRJ3/CiaoKpzB6NnYCw+s+oaTaO0RrlRaLRJPxH9JFBKpAMXm5geX776pYTGOAKSlSkpXZQSSEqi4zAGFQbwanaBIM5jPL97reNJK1+kfZbdZZwiW0uoSuMuZOYmwCTAJABkgTPhWpNqwWJRCFpYciAhZ+j0sEr0A76yZ/C5CJykqAVZQVAPHKTlV903FXMKVWSCTPImZItr7qZoVSvET1VAVALmNO1NhrZXlUg6AyLwDvBFr8RVFJAtbz/WiCfnRZQ2Q6QJgZSIEzF/2KoL2biToye9Sh+vwp3d1AzM0MDcFh95A6SVpB0uSOW4+cVfTh1FCnh9RSRpIAJAnzIjxqinY74UVEJkiPaHeeW6mDaroYwiMPP0ikocWOHWOt5J8GzbnQixySISykgKb+UVOkOJBxTpMxDSb6wlAA8YjzqXZ2PYSRnCo5WqbCbCViXXlBzKAtKYiZPVoPEfapia+T5LYl9/q5vBIzR+BIUaqrVFYlQOT6wj1qG0IxNwBe3l9oPxnTUqlrDp6tsAiQbrA3k8+HOlXbO0F9ZqfZSbHiKcMX0awSDKH3Cd4UkZT3XmkrpEwA8YIIyp9woFZ6o6+/WH0Z07MQg9+k1PajCFKbza9Wn8yqpObPb4ir2OdQlxOf8A4aPjVDa+KbI7OtaCtgC0zzpnZiytA+IwwRikgGezNawy32E/hHuFZFgjmfBN+yr4VtaWrDuHurN1LBT9Z6TS02FFQ2TaDsWoJQpRMAJUSeAAJJoPs/pNhVwPnWHUTuUtKVeABT7qLdJExhcQeDDx/wDTVX50Iilt9xLsNpn6SS02sShRPcQoeg+NQOsRoqfCPjX52bXlMix4ix8xRLAbZxZVCMU6mxIzPKCTG7tHLPfAqFZh1nNtPSbeV/u9e0qO4E9wn3Vi+H6bY5P9/m5KQg/9oPrRnAfKXikntoZUOQUk/mI9KIa2JQUwTNSSuNbVMF0mYX5TyUwvCnvQ58Cge+jWxtvoxJ7KXEERIXlMyY1BJ91DFcMbQvYkcSz0gV/Znz/hO/kVWPYIrbUFtqUhQ0UklJHcRetl6Qtf2V//AJTn5TWWN4RYAJSQDpandOgYGZWuqlCJVdxTzh+kcW5+NRV+Y0FxO0MY24vIXggqMBSSpJHIKBEd1OGFRFBcT0hfbJS24bKIgpREZogQkE+JNXr0gqjJHlF9LW7RyCAfOBzt2f8AzGEQrmkKaPpb0qRjFYNXsreZPBQzp807u8Vdx/SzFpTPWC5j2EnceIpfu84VuLSmQe1ktpAGVsW8t1JVMG3PmB6ialNcXHd8ifQgiFlbHDgPVKZe4ZFQrl2RB8xUOy9my7kxRcZTFsjZVJnQlIUUd+VXdUI2GzkzHExy6ld+4kirTZxDYSWsWspt7TbhTewjsqSRVQgGStvrf395JZyCAwP0t/eR/UaMPsXZiRfEJWTuW7lI7pW16pqRex9m/bbHPr0mP/dUt4R7FLH0jRIFrZwT4CR6V7xuzS4mOqdQeIaWrzMCmA+LhR6Rfs82Ln35Sfa+zdnoQS3jFFVzH8STHswhMDvK7cDQPE4ppDaVNLPWE9pOoi+/duteiD+y0s4dRVhwV5FfSlS033EIUk3vGopZ+bKjPlVlmM0WnhOk0Ko7DoP1D06anliftn394SG2lqJzFY7KkjKqNRAB4p4jeJqkp0n+tSYXCyCYNSLw5G6h3ZstL/40ws7ZTJcdSiYmd3AE027O2d1aiohtyREOJJA8MwoF0abHzhBUUpTCpKjAHZIptffaSY65k8w4kj307pUTbdvGZmvq1A9k4t+4Ca2PmxKW/azgnKITcrACROgvFO2xcejCFSEMpacSSlWZIUqQYIJXJ13UsoxWHD5UpaVJ6kpBCxAWVpN+NgbV6RjmM09akmdLmSfCioKYJ4tFNQKtRV/le3S4mh4jpGlxA+iSlQ+ujsg96YvQ1eNnh5VZwm0XQ0EBKAnSyQT41WSzJ76dppt4Fpg1nDG5Nz78PWUnX0zKwAkQVfhm/pSS9tc4p/FPGwW5h8o+ykOwlPgIFN/S5KEM5d6s0/hgyKScBhgnDtLmVOutyfwuNwB3SaT1JJqADoDNz4aqiiWPJIA9fxGros7iEjELYkfSawIs02NToaFbW2u7JzEydSTJrsAFZHSCRLit/JI+FDtpwhJURMcK5iQlx7zLJTDVjfPHoJLsnEpWpQdDirHKEqCYUdCZBlI4UJ2x/FV3JH+kV2zNqALsk/5v0F6rbQ2lLqzl+sd/AxwpFnUi95q06TBzYdJom3Xy4pwgwGm2Dp7WfnNooAp+d9P+z+jzTiFKKjLqGswkQMgtFrVCehCZ9qfKm2rEDbeDo0lw1ug+8VtiCXf5VfCt+Rg5FYh8y+b4xTQ0CfeEn41sux+kAeUWwiFATrYgRpbnpSGqBYAzXpGy4lDplhSnA4o/4D3/AE1V+aXm+F/fX6d6d4pScDiQUCFNOJnNxQd0Xr82YzCquQkkD6wuL6X+GtL08CRUF8ygEGJvExO6dYnjU2GwqlkAAkmLC55ADif0pi2J0fff+iC0gK7RSpSk5lACQREKUmd+hNjTlsTYeGYdadU6mVDMlJGUpUBlkiSJCgeWaIFGAJgsTOdt4YIcCMqUlCUoVlmFLElRvvk5T+GoGWxTB0s2cWXyFIUgKKinOQoKGY3BFt4tqCaXs94oTk3lltCjWKhOWmn5O8XneWNw6oea4pAcftFOnyUqSHlk6BTBPcFqPwqiJ3rxgNeat0qZjB4g6fRq91ZxslwuJ7SpCRAET2RdRtqAPeOIrVOl76Htn4gNSuUKHZBtEEyYtAvesD6P9MVYR0mJT20kyfrKbIVA0ypQbDWbzTuk1JpKR1vMrX6IahhfAAjC1SBtjaSkuqSEpsQZi+5XHnT0wuRIjwpC2ngVrW46B2QpKTxnIDw0pz4hVK01IMz/AITSBquCJB87U8MqsoCb2EbjU2HU0UXaKinUpMHeZM8uVVcAAC4Fa5YFpvO/wmp9nNuIJVkJStJFryDG4Sazw5sGObzYKAXAxLG1NnthlLzBcyykKCxBBM6EWUPZ4HteVJG1XIgrWIiIUYAHATaiIChs5eYEHrt4jczxpdTv7qo7WOJdFuCD0Muu7QUrVTh71E/GvbGAzgEEXvpQ4CmLZqYDfMbzGo4nQXq9LvnvSKnctaQNYYIBHGM+4G8AQN2tPmztkqOz1pSsZFBJKVIBHbGFWYKSk6qGs2HjSrttoNwAttU3lCgoazcin7ZJ/wD58/dZ/wClgqbRFBsIlqmKn6xKwGyT1aCN6Qo+N7mvGLw8k7h3fAUdadysoAt2UzzsPOqL+IhWgPCYg8r2plqKATPSs7MTAu08MjIgNkyqxJ4iCdNBS0uQdT5067cyRh+0mSpwKERljKB2hZW/ThzpQxgAUtAuErXB4iQNf5fU1natFB7vvE19ExK595lcTRLYuHlwKzJGVSLEgKMmOyNVRvjQVRaFx++NENkj6du31k/mFApjvCMVT3D5TVmnjNEsEu9BkG9FsDqK9R0nz6qLGLnygOQm3BdLuHRGFwwP2wfJxP6Uc6fG0fccPoKDqTlYwo+8o+pUKza3+0+X6m/of/mT/kfQy3gf4Sj/AIjv51D4UN24fo1/veKMbIT9Hfet3/qrqp0h2WrqiUEGY7JsdeOm6rVDaj9Jagb6m3z/ADE7ZBhfr5VSUqSTxvU4BbKgoFJykQRGtvjVesUnAE9EB3iZumG2qW+zEhISnyAB91Wx0hOuX1pT+dEkniSfOo1YgzrWs2xszLpJVUWl13E9bjFriJSPcmtC2FgVKfX2i2Mp7em9Oh41nOwBOIM8B7xX6CaWmIECkNRU2jaOs16QsoiP0x2cUYR8l8uy25Ym47JuLmsMbxJbXKQlR4ESPKv1JtTCoeaUyuMqwQZ4b6TT0fbbkNhpsgkT1XD70yKWQ3OTLNe2JiL+38SXOsUpSVXi3EFNpvJk3vMmreL2TjUgLcOQATmWsXJ1BULJO6FkDnWpbQ6OOupIWttxN5ESBYidDFib2oVgeiT7aSj5zLY9gFskoT9nNnAUkaCRpTaop5MVYv0EVGMMtxCm/nCVqN1sOo6tQH2klWaDMwoDLfWruG6M4IJBUHVEgSkqmDvBKBHkTR5voayBCypwAyEgJbCTxTl7SP5SN/GqWG6MuqUUuFLaCpQTKi44QAopzRAEhI+tPdRgEHMCQ54nhnZ2DQJGFR3rM/mNHNhdWtYS00hMFI7AAm/IX0oKjoe4lXZ+b5eJLmby09aa+jWy04XMorJNjqABBOgJk60Gs/RRGaCgZZoUx+z+owry3VuJTC+ykgoOYAAqSOZrI/mGFQn2G1qUJ9hNp13bq1Ppnt0OYPEICeyUGCCZJEEa847451jiJGtG0S7QSwzMz4m7MwCtYfKXsI0hHsISmYmABMcYpIeDjilhDkJK/ZK8iZyxJkgbopxaVSthei2KcbL/AFYQ0TZbp6tCs1xlUoQRzmKj4gRtUCd8KU73Y54lfA4dJcWFqgBM2IN504b6stYhtuUoci51bk2J1O818V0bxCElQCV6D6NXWTPAokEDeZtRDZ+wceWusTg8QtAEghOs3BCSklabzIHjvpNHUKLzTdGLGVtuY4dQpofbBJJFzABgADL7IsSdDS8QBIMzv7+H9atuYnslJSoG4194I11qX5y2Y7CRFzKQSqQd95uZvXMLmcO6OIOkK5HdeQfS1HtmsShIBOgNz3aVXb2rk9kADglKRPlBolsnazbjyOuSG275ii9pta0/5rxUoQjXOZzd4eEp47DkNrM3GX8xHGruE242cJ83DJViFSAvcLIA1OsIJ7zV/pS/g+oWnDtpnMmHA+pUjMJ+iV7M3MSY4xSZh1QrNMRziiMxDYxeU2o48jH7ZWAxK2khTByg3WFozZctkwpYETfjUrfR/aCJWGkqBBEFTakm1jBJBIMHwpWwO0z9YlQGgzEe40fw3SZafZU53Z1R5TpTaK9QfyETZFRsLAe2NmutKQFoUFEmAY7URMQTa9L+ISoKIUIVNxEX7t1OHSvb3WqZUQSUJd1UTOYAeGlJ+JdKlFR3x8P0pOuu1rHmOac3WfW1CRYCOE35mT7qKbKZV1zRyqy50CYMe0N+lDW8ScoRaJJ0v57qJbDWkvtAIAVnT2pOki0G1DpE7x5y9b/W3kZo7rqUBS1GEpEk8hV7YG1GnlQ2oKyxPKZ/Q0MDqTIUAQbEESCOBG+rmEWy1dtCEE6lKQme+BfU+dejuxOOJ4dkTYbg7unhAnTpVyP8J33UJedStOGCFJUASDB0ORy3IxBon0oUnEHKyCpzqnAUjU6aeBJjlS5sBsQkCbPEyRFi0oaXvynfSFVj25Hjabmjpj/xVJ5F/wCwYw7OUOrTeJzeqifjXrbmJPViANRvi0GhmHxI6tP4ffVTGYwwkEmCfSD+tRWcdlb5TqNFu3v85N1pV2SlJEb737jXr5g0dWkeQHurwhkRc+lWEhQ3+k1jWm8CYVwrU1bQ0kV5OHU0txpcS2rLYzPZSfjXtsSa1RkXnBL8T1sWPnKo+77xW0pevWJ7Jti1AcUe8VsYN6R1a3tGqYsLS6+4csjcZgXJHCl/buLOdJTIzpk+FqMKBIjjQnbLAJRroReeOnKhaYAPmdUHdggOb69F48a+4lEXqirEAb61lAMyapKy+HKr4t+AFcFI9VAH0JqBOKB0k91/dXjFoWtCgEKki264uNedTtA5gN7XxCjipquo16DThHs+ZHwr0NmvHgP3ziqblHJhXRycAwV0nWRgnzBMIKjHAQT6Cs22dhnCgrLqHEmII7JBgkpIiytDzBBFa5iMIMi0OlBQtJSoE2KVCCOyZFjQXDdEtmT/AOUWtUe0h169ouc/Cgu7Bgyi4kiirIVY2aIDWIg0vNbfxACQl5xAAFkLKALcEkCeep31qO0Pk2YUsOMJVh1D6q3etSdRoZUDf7fhSLtP5O8c0CQ2l1I3tKk/5FAK8hQq1Q1ALj8wmnodkTY+Hy8ZFsCX8Uz84czIKxnKnc5gAmDJMgxEToYrTtq7UbQhLaXuyIypbRcJSISElopCERaCY9KxTE7Oea/isuN/jbUj8wFdhMUsdlK1JnQpURB3aHQ6HvndVKLimbkXhdRTNVCoNoY21h0qffWWSApainIUoSieLYBBveAoDWghaAME+cD31YG0XrgrJ45gJnv1r6cXOqQf3zrm2nicoYCxkSmkAkb4gTaDIvztPnO6q+Ld7RgDjZIT/pTYeFXsyFWhSZ+ybaXsbRAq0wWD9YSQAAWkybj6w0tNwRVSL8SwNuYIDiINzOl+HgmiWye1PVKKVISpwm5lKAVEqsQQANCIvvmvJ6kHU7rdSjd+I1IcQhN0dYCQUkylEpOosk25TXBfGcXtxCW2Oiy0ur6si7pbQ3BBkpQsJB7nExTZsL5KkqAOLxOVZ/u2csg8CtYIJ5BPiaB/JusKx7fZ9kOKkqKiCEFI3wPa4Uz7WcKMV2SQFEiOe40xSoCpfNolqdY1ADFyb/1B/TH5OmWWFOYd10qQCoocKVBQAM5SlIIVF986WrKjW8YjGKcSnNfcedYi9hCFKH2SU+RI+FTq9P2IU35lfh2uOqZxbi0qCiWwT9Ojvqqhkg6A94q5syzyOylNzpN+yeJNK0T/AJB5zQrD/G3kY5h0kwLmpMVhMQBJQQK+9F9kuYpxSW4GSCSTGsx+U0zY/ZeKbQU9WVjjmBPrFbfaX4M852W3Nv6iFs7GLYxCXsslJuDvBBChyJBMHcaN7baYcxmHbw0Dr5ekWAK0wLTbtIEjkrjQnGtOAnM0oeE+6qGzbPpflQKFabhqDrcak95NIhjex8ZotTUjcDkD8YnjArStAAMGB8N1eXEDMJnSRyP7FFukXRUsNt4hmcikIKhrkUR+Q+hMbxS8y8VKJKYtBIFgZGWeEn31SsWA2mEobHO9DiG8KZGnL98jXLZvYCqTGJWmDllEXG9JHvFEmXAsSNOYvWebiaGDHHpuhKMcsAR1qUO95jqz4/Rj9igwXrRb5UgeswzgsqFgHiUkKy+IJtypYexvZSu+VXkFX7J4G3iL8Y0kNqYEtTbOZd2C7/aZ5p/NWxsYsTc8TWGdHMROJHen8wrVn3gELM3IIHiDJrqtMOohkMeMKW1JCgcwOhGlRY3CpWRBiNd8+dJ+wiWwXCohIkFE2JkkSDyPuokvbBCQQJUohKEnSd5VyF+NhG+lTp2U90yTaEMXs/DgErAA4qUQPQgUvvsMg/RpKxxQ2SPOKM4dpIhSj1i/tq4/dGiByF+M61MvEc6lWZfEwTU7+Ai4CqbNr8YHvM1cYw7m8IT4lR+Aoip6vGermoT0lBRtyZ8bw53rI/CAP1Nezg2zqCrvUo+kxXma+gmhknxltq+EkQw2n2UJB4hIB84ry6BXAmvWWqS1h0lNTfD3VC42TRVLVSBgcKnfaVK3gMsmKGYvo/hnP4mFZVzLaZ84mnIYTlXoYAGo7WR2czTF/J9g3CT1JQTvQtQ9CSPShr/yTNH2HXkfiyrHlCT61sXzNI4UPxm0mkWSM55aefCuUsxwJRyiC5Mw3bHyaYxhJU1lfTvy9lyPwHXwUSeFImIBFiIIJBBEEEagg6Gv0LtHaDyl2XlSIgJt4z40hfKds9LvV4kCD2UrMXhQVlzcSC2oT94cqO1FlW5i1PUK72Amb5yRM339/Hx/WuCquJwMHWx17v3eq62oJmLHv/3FDAh2jd8l6wMamdVIcA8ACf3ypw6RYZzPmShRgggwY146Cs36N45LOMwyzMJUkHkHJSo+AX6VvreIJIQq6YtN+8elNaZ9tx4zP11DtAGvxFjCYTMO0rKOMSQToSN4B15Vli9hYtTryeqU4ttZDmUEjOSTNgJnURuI41rL5KiQLD0A40K6YAtpbdbeUlLoIWSB/EAjcJuExefZ7oa11HeFN5m/A9Qq1XQjnP2/Ey9zCupPaacB3ykj3ioG3kpcSVSAJm0m4j408HYQcAV87ZUTH95KhczMkEd1Q4joO66nMhxDkTAKwCOQCjpSA0bKd4M9E1ZW7njI+geOV16wz1q1KAEtoUrLr7doCTztatowbzhYBfSAuLjWLn3iD4mlbobjE4XDNMuICClIBjTNvJgWVJ10OtqYXdotKTZxN9Li/cdD4VcZPeizgqLAYi5tltBWbCkfbmES2tSh7LiTPJYHxH5acdtJ7U8qWNuYQuNKSPaFx3ihk2Yy4F1FxHPo3jGsXhQhSYW3DbiNZFhpqQdOcjeoVmnTTosrDLlMlpc5VDdociuO487Gpti7aUw6jEJ0MJcSdFJ0uOUkd3dWpYrDN4li4ztuCdwOuoOgUFHXQKPBwENizjMym3aapdePfpMEwmNU2oJXpOvI8eVHGUiOwbGu6UdHFYdwoVdJkoXESJjTcQbEbiKXU4h1rsg28x4UjVolTNejWWoLibV0v2kyOpRiCnqXOsCrEqCh1ZStJSDBSZ8/ApTJZZxOXrOvYJuW4hVpgg2uQN+oBBBFevlGfMYeeL3/AMNKWCxcGDofQ02LDumTSfcghbZ+NLmKbOVKO02MqRAHa8yefurWXEJzQ5OUhWmotZUb44VkmDbh5Lg+0nNG4hQhXcZHj31sOx8e3jGMziAl9mBnRAkLsJG8KuCOIkRuizKt+l45SIM9pd+jbGkiSOf7E+VQtufSD7g98kj0HnXzPJKvqiw5AVQ2a/nSV/aUo+E5R6JnxppFsLSha5jGzjrxVtD86UGYbJ3mrAtH60J6Sy24wiXBXtNUWHwauNuCl3S0kZlhCamS3Xho1dbTSrm0m0hSzUqWaspbrluJTzoJa8jiRpYqdLVVHMYrcIqm48o+0q3AVIUmUNS0KOYlCdTeqeI2kY7IgcTrQzEPlJhIvz4VROIUq5OhmOWnxo6UhzFnrHiWcTjPtEqPChTr5O7XhVxvBlZmYFfMVi2WRlADjmgSNAeKo099NJYGwGYnVuRdjYQe7hTlJNtbkxE6Dv0pZ6VIS9gcT1S0qKUocBBtCFgqgi2mbTeaZHNmuPAlcrVBVlFgBcmE+Nt5oY10YDLb+HcJR85GZKJSpSSojNlEdgSdCSDfhV638bQWm/nexExX5opWqh7zVxOGRABKjHcB5XPrWnsfJiwCCt54jgMo9cpPupk2b0RwTUFOHST9pYLiv9cx4RWdum52J6zFcLs1x4nqWFOSTdKCu/4rhPpWz7MW4ppAelpwJT1gsogkCdDGt9d9H+rAH3e6w8BVDaaUhaV2CSkhRNhG43339KLQYhoLU0R2ZkOOw4yAIBsfFXfVPbGRGHIUyl7qxnKVEhNpJMpvMTA36UwYbDFTaVJykkWuBPOCaGdINmupwr0IUT1azCe0pRymICZm9aXbKy7SZ5xNG9KtvUeH2iGvpDs5QAd2akA2+iWQrv8AaTaa8jZWAxJ/sWKWw6f7p6Sk74BEKjmM1LW0th4hElbDyBrKm1C34iIH+9CHWjoR3+HHug6c+FJMxU4m7sBHM0rofh32sUnCY1uW8i1trmUKgpEBY9pPamDBFptatQawraLJbQn8KQPcKxXoT0nekYR5ZIc/gOKMrQ7cI7StQT2b8YMiRWm9EdtnE4fOpOVaVKbWNwWmAYndvHIgbq5GDG0FWDAXML4lA4DypI6SsZTmSALkGBHdTriFWpb28xmSRxHqKZNPchEUWrsqAzPcRs5s5jlIKpJgxc620o10G2x1KzhXFDIq7alXAtHa4pjsqH2TP1RQ5ZqjjWyYUn2kmU9/DuNLUX2nPEc1NEVUsOek0/bWzEvtqbcHZM6jMpCkjiNXECP+Y3xIrIdt7GXh3C24BxSrVKknRSTvBrU+h+3BiGYUTnSkZo9ooTopP+I0bg700VewbazlcQysi4z2RCr52z9lUSU7iDxpw24Pv378JiU6hpn379/WZX08QFfNgeDxjl9F+lKmG2ky0tCggLyqSoiJCgCDBm0GI0NH+nrpDmFI1AWQf5k/pSdgsCpxeVNgNVHRI4n93pSo7BrKOs2tPTBQExzfb6rJi8KVKw6517RbJ9ppyZkXIBVMixkiSxdHto9WZBKUPtqtMgLQqwJF8plUTcSAbSo52rbDjfWMsLIaUAgpgEKAtJkGCeXrFe2cYpHVup1mCDYKSZkHgJHhRUqARwN1mqdIdpdVh1JbMrKYEHfXdH4DLSeCEC+tkilvDYnrkBaCSNIOqYA7J7hA4RG6mLZ2KS4ARCVp1G48x+7U6oubzhGZpwAfv9/sVXefmwqg4/aNDXvDGKjZbMm8IsEjvqy25B/fnVRpdcXLd5oLiSIaweIBt+z3UVwyqV21wBH+1HcPiOzJ3C/dGo86z9QtoUQwtVqoYjGJFUMRtKG0q1lIMjSwP6UGxGOzGJ0/X9E0BKd8xapUsbS1itpKHNJmCNUmwjzNV2MWsE5VSDOt+AFTstJiSR/XWw7zUz+FabTmcUlCfvEDyo4IGIAgnMiBWbnjVXaDiGk5lqyj1MA2A51SxfStsShhHWHQKNkDnxV4R30GOIKlhbqiteoG5IPAaAfu9NUqLtyLRGvqqaDBuZfOPfdEA9U3v3KI5q3eHnV7Y2DznIyNPaXuTxk765vZ4yB7ErLLO4fXc3wE60M2p0gLqepZT1LAtlHtK5rI9wt30yFv3U+/QfsxFqhHfqk/IdT+h8+fCMe0OkLbALWGha/rOm4n7v2jz076WkvnrA6skmbk3JJjiROnGguO2ihlMqvY5Uj2lxrroOfvNqCq6UgwowdeyI7PIcZ4yZt4wypSBA5MY04qalg7YUce/wAzTf8AxEwkoKSm4jUjv4Xrn9pLSm0EnhoO8/pSWnpMwIUAqCdyQdBvntX0tMR3THjOmSQqEtd5mOImCndx4k1nGjmejFURqf2sTqom8RrMiYPHuqviMuKBbcSDllYEzcDkb66aUjudKnjCUhOUyNCFDgZvPdM86LdCscpWIdBOY9Uogicpu0mwIB5xHGiJTUEWgKz3Uwt0R2K0cRlLaCnKSQUgj1HGKZtm7P6/EqVh1uM4dsFJLaoS4viEkFNt0CInWRCzhVKbUqXAEqGVSgLhBIJAvrAp52T0gwiG0ttqCQBvMeM6E03qrjge/Gef0J7Q84Bz8/l+5I6xiWbgh9PCyHf/AKLP+XlNUH8Dg8YCVtNLUmygtADiDwMjOg0bG0UK0UL1A4qSTvpNBvwZpuezNwYlu/J3g+sbWjrGy2pKgErzA5VZh/ECiL8DTVh2UNpyoSEiSYHEkkk8SSSSeJqRRqJSqYp0gvEVq1mbmc8uhmPunuNXHlVSdvI402ixCq8Qtqt5HFDdqO40OWaOdJG7BfCxpfUqs+vT2ORNjSV+1pBp92TtJWGfDiTAJB5BQ39x39/KtcwWJQ62laWOuQZISNWVH20fhJgjxrGcSiRRnox0lcYQpGcJMiZJExMG2/8ApRqR3jaeREtdRIPaKOeePzce/kIO6dNNFTBcWoQ2qEpFzKz9Y2TpzpaxWNKwpKU5EawmBJsJWdVH98a+11BbDECaVD/WJAGCQCEgBSglImTNt9uI1q1tRkoyJjsgEA/aUkwsxrqTrXyuoqoAphCZY2VtANFKkAiP4mY9lQm0ACxG4/suWBl3K6xrGYbtDz3zXV1HpOSCJaljEeMLsB9xtK1JCZA1ULEj7s1cwvRxQJzODuCSfUke6urqy6mvrXsMRkIIQa2AgarV6D4GphsRrfmPj+lfa6g9vUPJkT2NlM8D/mP617c2eyoQpE/zKHuNfa6oLMeTK3nxzZjWQIykJAgAE6d8zVROwWQSRnBPOePEW1rq6rKxg2AJuZM9s7sFLbmRW5eUKI8DYnvpUx/Qh1asxxXWK4uJM+eYx3AV1dRadVkysXq0UqYaU3OiGJSIQEK7lQf9QFTwzgEpW6OuxKrpR/doi0k745f1rq6nKdd6pCNx8pn1dLToKai8ji+bRd2ltN3ELzurKju4JHBI3ChW1NrBkQBmWRIB0A0zK4jkPSurqfc7E7uJnaZBWrd/PWKT2IU4vMs51KN83ppEC+gr6nCkxcyTBP3ib9+6urqQ5m+otiTuFZ6samMqdB7O7zOpry2+lV1mxkgmfaNpJAKjeK6uoDGHE8hXAmROumvDx51Z2XtReGczogHKpMESCk6i2h0M8vCurq68sRiNOB6XtKSht1iVWSSnQk2m9xNWS3hHxLTjrShvEx3EGyvG/OvldR0qM52mLNp6ad5RaWuiuzXhi0ZnUrQkKWezlUcohOlj2ik+FaIVV1dVwMxascyJZqBaq6uoqxJzIXVWqopdxXV1MIIlWMB7ZYnOnjce+kpYrq6ltaP4mO/B2PfXpeRLqk80SbV1dSINjNkgEWM//9k=" alt="">
            <div class="card-body">
              <h4 class="card-title">Space Themed Room</h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque sequi doloribus totam ut praesentium aut.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>
        <div class="col-sm-4 my-4">
          <div class="card">
            <img class="card-img-top" src="http://www.atusdesign.com/wp-content/uploads/2017/03/architecture-magnificent-underwater-hotel-rooms-for-interior-bedroom-design-with-large-double-side-space-line-shaped-brown-wood-base-storage-space-that-have-seating-space-and-simple-brown-wo-830x467.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Under-water Rooms</h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Paradise Hotels 2018</p>
      </div>
      <!-- /.container -->
    </footer>
<!-- Opening modal -->

<div class="container col-lg-12 col-md-4 col-xs-2">

  <!-- Trigger the modal with a button  <h2>Modal Login Example</h2> -->

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 style="text-align: left;"><span class="glyphicon glyphicon-pencil"></span> Register</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
<form name="register" action="restregister" method="post" >
            <div class="form-group">

<input type="text" class="form-control" name="phoneNo" placeholder="Enter your 10 digit mobile number" maxlength="10" pattern="[1-9]{1}[0-9]{9}" onkeypress="return event.charCode >= 48 && event.charCode <= 57" oninput="invalidmsg(this)" title="Should enter a valid phone no i.e., first digit is not zero" required="required">
<!--               <input type="text" class="form-control" id="name" placeholder="Enter Employee Name" name="empName"> -->
            </div>
            <div class="form-group">

<input type="text" class="form-control" name="custName" placeholder="Name" required="required"><br>
            </div>
            <div class="form-group">
              <input type="password" class="form-control" name="password" placeholder="Enter password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter and one special character(!@#\$%^&*), and at least 8 or more characters" required="required">
            </div>
            
<!--              <div class="form-group">
              <input type="password" class="form-control" name="password2" placeholder="Re-Enter password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter and one special character(!@#\$%^&*), and at least 8 or more characters">
            </div> -->
            
              <button type="submit" onclick="return validateregister()" id="registerbutton" class="btn btn-success btn-block"><span class="glyphicon glyphicon-floppy-saved"></span>  Register</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          
        </div>
      </div>
      
    </div>
  </div> 
</div>
<script>
$(document).
ready(function() {
                $('#registerbutton').on('click',function() {
                var	regex2=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
                	if (pass.match(regex2)) {
                		return true;
                	  
                                $.ajax({type : 'POST',
                                                url : 'http://localhost:1111/restregister',
                                                contentType : 'application/json; charset=utf-8',
                                                dataType:'json',
                                                
                                data:JSON.stringify({"phoneNo":$('input[name=phoneNo]').val(),"custName":$('input[name=custName]').val(),"password":$('input[name=password]').val()}),
                                                success : function(html) {
                                                                console.log(html);
                                                if(html.messsage=="registered"){
                                                                alert("Registration Successfull Please login to Continue");
                                                                
                                                                
                                                                
                                                }else{
                                                                alert("Registration Failed Please Try Again");
                                                }
                
                }
                                });
                	} else {

                		alert("Password entered is of wrong format");
                		return false;
                	} 
                                });
                });
                
</script>





<script>
  
	$(document).ready(function(){
	   var test="${message}";
		if(test==""){}
		else
			{alert(test);}
	}); 
	 

$("#errormessage").hide();

$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>

<!-- Closing modal -->
<script>
function validateregister() {
	//alert("validate");
	var phoneno = document.forms["register"]["phoneNo"].value;
	var pass = document.forms["register"]["password"].value;
	
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
	} }
	
	
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





  </body>
  
<script>


</script>
  

</html>












