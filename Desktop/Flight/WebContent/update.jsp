<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.fb.dao.FlightDao"%>
<%@page import="com.fb.model.FlightMo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/addFlight.css" rel='stylesheet' type='text/css'/><!-- style.css --> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<div class="navbar">
    <a href="admin.jsp" class="active">Home</a>
    <a href="addFlight.jsp">Add Flight</a>
    <a href="ShowFlightControl">Flight List</a>
    <a href="RegistrationControl">Sign Out</a>
    
    </div>
<body>
<%! String flightid=null;
    FlightMo flight=null;
   FlightDao fdao=new FlightDao();
   String flight_id="";
    %>
    
    <%flightid=request.getParameter("flight_id");
    //System.out.println(flightid);
    flight=fdao.getFlightById(flightid);
  	session.setAttribute("flight_id",flightid);
    %>
    <h1 style="color:#1F0C8A;">Update Flight Details</h1>
    
<div class="inputpilot">
<div class="content_pilot">
<form action='FlightController?action=update&flight_id=<%=session.getAttribute("flight_id") %>' method='post'>
<center><div style="color:red"><center>${success}</center></div> </center>
<label>
Franchise:</label>
<input type="text" name="franchise" value=<%=flight.getFlightFranchise() %> required=""/>
Source:</label>
<input type="text" name="source" value=<%=flight.getSource() %> required=""/>
<label>
Destination:</label>
<input type="text" name="destination" value=<%=flight.getDestination() %> required=""/>
<label>Flight Fare:</label>
<input type="text" name="flightfare" pattern="[0-9]{1,6}" maxlength="10" value=<%=flight.getFare() %> required=""/>
<label>No. of seats:</label>
<input type="text" name="noOfSeats" pattern="[0-9]{1,3}" maxlength="10" value=<%=flight.getTotalSeats() %> required=""/>
<label>Departure Date:</label>
<input id="select1" type="date" name="departure_date" value=<%=flight.getDepartureDate() %> required=""/>
<label>Departure Time:</label>
<input id="select1" type="time" name="departure_time" value=<%=flight.getDepartureTime() %> required=""/>
<label>
Journey Time:</label>
<input type="text" name="journey_time" pattern="[0-9]{1,6}" value=<%=flight.getJourneyTime() %> required=""/>
<center>


<button class="registerbtn" id="button" type="submit">Update</button>
</form> 


</div>
</div>
</body>
<div class="footer">
  <p style="text-align:center;" "color:white;" >©FlyBy2018</p>


</div>
</html>
