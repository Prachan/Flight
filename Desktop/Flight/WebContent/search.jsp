<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
 <script src='https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.16.1/lodash.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
<script src='https://unpkg.com/fuse.js@2.5.0/src/fuse.min.js'></script>
<script src='https://screenfeedcontent.blob.core.windows.net/html/airports.js'></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Booking Form HTML Template</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans:400" rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css" />

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="css/search.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head>


    <div class="navbar">
    <a href="welcome.jsp" class="active">Home</a>
    <a href="about.html">About Us</a>
    <a href="contactus.html">Contact Us</a>
    <a href="RegistrationControl">Sign Out</a>
   
    </div>

<body background="images/background.jpg">

<div id="booking" class="section">
<div class="section-center">
<center><h1 style="color:#0B4D3E;">SEARCH FLIGHT</h1></center>
</br>
</br>
<div class="container" id="co">
<div class="row">
<div class="booking-form">

<form action="SearchControl?action=search" method="post" id="form2">
<div class="form-group">
<div class="form-checkbox">

</div>
</div>
<div class="row">
<div class="col-md-6">
<div class="form-group">
<span class="form-label">Flying from</span>
<input style="border-radius:10px; height:40px;" name="source" id="select1" type="text" />
</div>
</div>
<div class="col-md-6">
<div class="form-group">
<span class="form-label">Flying to</span>
<input style="border-radius:10px; height:40px;" name="destination" id="select2" type="text" />

<div id="test"></div>
<span class="select-arrow"></span>
</div>
</div>
</div>
<div class="row">
<div class="col-md-3">
<div class="form-group">
<span class="form-label">Departing</span>
<input  class="form-control" name="departure_date" type="date" required>
</div>
</div>
<div style="color:white"><center>${dateError}</center></div> <div class="col-md-3">

<div class="col-md-2">
<div class="form-group">
<span class="form-label">Prefered Airline</span>
<select name = "airline" class="form-control" required>
<option value="">--Select Flight--</option>
<option value = "spicejet">SpiceJet</option>
<option value="airindia">AirIndia</option>
<option value="kingfisher">KingFisher Airline</option>
<option value="indigo">Indigo</option>
</select>
<span class="select-arrow"></span>
</div>
</div>
</div>
</div>
<div class="row">
<div class="col-md-3">
<div class="form-group">
<span class="form-label">Travel class</span>
<select class="form-control">
<option>Economy class</option>
<option>Business class</option>
<option>First class</option>
</select>
<span class="select-arrow"></span>
</div>
</div>
<div style="color:white"><center>${error}</center></div> <div class="col-md-3">
<div class="form-btn">
<button class="submit-btn">Show flights</button>
</div>
</div>
</div>
</form>
</div>
</div>
</div>
</div>
</div>
<script>

$('#select1, #select2').on('change',
    function () {
    if ($('#select1').val() == $('#select2').val()) {
            $("#test").text("Destination can't be the same as Departure").css("color","white");
        }
        else {
            $("#test").text("");
        }
    }
);
</script>


</body>
<div class="footer">
  <p style="text-align:center;">FlyBy2018</p>
  <i  class="fa" >&#xf082;</i>
  <i  class="fa">&#xf0d5;</i>
  <i  class="fa">&#xf1e0;</i>

</div>


</html>
