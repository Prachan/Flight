<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Flight Details</title>
<link href="css/font-awesome.css" rel="stylesheet"><!-- Font-awesome-CSS --> 
<link href="css/addFlight.css" rel='stylesheet' type='text/css'/><!-- style.css --> 
<link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="keywords" content="Basic Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
</head>

<div class="navbar">
    <a href="admin.jsp" class="active">Home</a>
    <a href="addFlight.jsp">Add Flight</a>
    <a href="ShowFlightControl">Flight List</a>
    <a href="RegistrationControl">Sign Out</a>
    
    </div>
<body>

<h1 style="color:#1F0C8A; font-size:40px;">Add Flight Details</h1>
<div class="inputpilot">
<div class="content_pilot">
<div style="color:red"><center>${success}</center></div> 
<form action="FlightController?action=addFlight" method="post">

<label>
Franchise:</label>
<input type="text" name="franchise" placeholder="Enter the franchise name" required=""/>
<label>Source:</label>
<input type="text" name="source" placeholder="Enter the source" required=""/>
<label>
Destination:</label>
<input type="text" name="destination" placeholder="Enter the destination" required=""/>
<label>Flight Fare:</label>
<input type="text" name="flightfare" pattern="[0-9]{1,5}" maxlength="6" placeholder="Enter the flight fare" required=""/>
<label>No. of seats:</label>
<input type="text" name="noOfSeats" pattern="[0-9]{1,3}" maxlength="3" placeholder="Enter the no of seats" required=""/>
<label>Departure Date:</label>
<input id="select1" type="date" name="departure_date" placeholder="Enter the date of the flight" required=""/>
<label>Departure Time:</label>
<input id="select1" type="time" name="departure_time" placeholder="Enter the time of the flight" required=""/>
<label>
Journey Time:</label>
<input type="text" name="journey_time" pattern="[0-9]{1,6}" placeholder="Enter the journey time" required=""/>

<center><button type="submit" class="registerbtn">Save</button></center>
 </form>

</div>
</div>
</body>

<div class="footer">
  <p style="text-align:center; color:white;" >©FlyBy2018</p>
  
</div>
</html>
