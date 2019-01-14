<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/PaymentStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<div class="navbar" id="nav">
    <a href="welcome.jsp" class="active">Home</a>
    <a href="about.html">About US</a>
    <a href="contactus.html">Contact Us</a>
    <a href="RegistrationControl">Sign Out</a>
   </div>

<body>

<div class="container">
<div id="cont">
<center><h1>PAYMENT PORTAL</h1></center>


<form action="SearchControl?action=payment" method="post">
<p>Name : </p><b><input type="text" name="Name" pattern="[A-Za-z]{1,20}" required/></b>
<br />
<p>Card Number : </p><b><input type="text" name="card_no" pattern="[0-9]{16}" maxlength="16" required/></b>
<br />
<p>Amount : </p><b><input type="text" name="amount" pattern="[0-9]{2,10}" maxlength="10" required/></b>
<br />
<p>Number of passengers : </p><b><input type="text" name="no_of_passengers" pattern="[0-9]{1,20}" required/></b>
<br />
<br>
<div style="color:red"><center>${errorMessage1}</center></div>
<div style="color:red"><center>${errorMessage}</center></div>
<br>
<center><button class="button" type="submit" ahref="Invoice.jsp"><span>Submit </span></button></center>
<br />
</form>
</div>
</div>
</body>
<div class="footer">
  <p style="text-align:center;" >FlyBy2018</p>
  <i  class="fa" >&#xf082;</i>
  <i  class="fa">&#xf0d5;</i>
  <i class="fa">&#xf1e0;</i>
</div>

</html>