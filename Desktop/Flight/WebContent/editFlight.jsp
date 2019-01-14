<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<%@page import="com.fb.model.FlightMo"%>
<head>
<title>Add Flight Details</title>
<link href="css/font-awesome.css" rel="stylesheet"><!-- Font-awesome-CSS --> 
<link href="addFlight.css" rel='stylesheet' type='text/css'/><!-- style.css --> 
<link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Basic Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
</head>
<body>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>



</style>
</head>
<div class="navbar">
    <a href="adminlogin.html" class="active">Home</a>
    <a href="addflight.html">Add Flight</a>
    <a href="cancelflight.html">Flight List</a>
    <a href="home.html">Sign Out</a>
    
    </div>
<body>



    &nbsp;
    &nbsp;
    &nbsp;
    &nbsp;
    &nbsp;
    &nbsp;
    &nbsp;
    &nbsp;
    
    

&nbsp;
&nbsp;
&nbsp;
  


<% FlightMo flight=(FlightMo)request.getAttribute("flight");
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
%>

<h1>Edit Flight Details</h1>
<div class="inputpilot">
<div class="content_pilot">
<form action="FlightController" method="post">
<label>
Franchise:</label>
<input type="text" name="franchise" value=<%=flight.getFlightFranchise() %> required=""/>
Source:</label>
<input type="text" name="source" value=<%=flight.getSource() %> required=""/>
<label>
Destination:</label>
<input type="text" name="destination" value=<%=flight.getDestination() %> required=""/>
<label>Flight Fare:</label>
<input type="text" name="flightfare"  maxlength="10" value=<%=flight.getFare() %> required=""/>
<label>No. of seats:</label>
<input type="text" name="noOfSeats"  maxlength="10" value=<%=flight.getTotalSeats() %> required=""/>
<label>Departure Date:</label>
<input id="select1"  name="departure_date" value=<%=sdf.format(flight.getDepartureDate())%> required=""/>

<label>Departure Time:</label>
<input id="select1"  name="departure_time" value=<%=flight.getDepartureTime() %> required=""/>
<label>
Journey Time:</label>
<input type="text" name="journey_time"  value=<%=flight.getJourneyTime() %> required=""/>
<center>
<button type="submit" class="registerbtn">Save</button>
 </form>

</div>
</div>

   


</body>

<div class="footer">
  <p style="text-align:center;" "color:white;" >©FlyBy2018</p>
  <i  class="fa" >&#xf082;</i>
  <i class="fa">&#xf0d5;</i>
  <i  class="fa">&#xf1e0;</i>

</div>
</html>