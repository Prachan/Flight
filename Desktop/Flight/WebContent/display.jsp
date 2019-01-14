<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.fb.model.FlightMo"%>
<%@page import="java.util.List"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<script src="js/display.js">
</script>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/display.css" rel='stylesheet' type='text/css'/><!-- style.css -->
<title>display data from the table using jsp</title>
</head>
<div class="navbar">
    <a href="welcome.jsp" class="active">Home</a>
    <a href="about.html">About US</a>
    <a href="contactus.html">Contact Us</a>
    <a href="RegistrationControl">Sign Out</a>
   
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
<center>
<br>
<br>
<h1>FLIGHT LIST</h1>
<%! String flight_id = ""; %>

<center><button class="button" type="submit" onclick="sortTable()"><span>Sort By Price </span></button></center>
<br>
<br>
<TABLE cellpadding="35" id = "myTable" border="1" style="background-color: #ffffcc;">
<tr>
    <th>FlightID</th>
    <th>Franchise</th>
    <th>Departure</th>
<th>Arrival</th>
<th>Departure Date</th>
<th>Fare</th>
<th>Select</th>
  </tr>
<%

List<FlightMo> list=(List<FlightMo>)request.getAttribute("list");
SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

for(FlightMo l:list)
{%>

<TR>
<TD><%=l.getFlightID()%></TD>
<TD><%=l.getFlightFranchise()%></TD>
<TD><%=l.getSource()%></TD>
<TD><%=l.getDestination()%></TD>
<TD><%=sdf.format(l.getDepartureDate())%></TD>
<TD><%=l.getFare()%></TD>
<TD><a href="booking.jsp?plane_id=<%=l.getFlightID()%>"
					class="button_home button5" style="color:white"> Select</a></TD> 
</TR>



<%} %>


<font size="+3" color="red"></b>

</TABLE><TABLE>

</TABLE>
<br>
<br>


</font>
</body>

<div class="footer">
  <p style="text-align:center;" > FlyBy2018</p>
  <i  class="fa" >&#xf082;</i>
  <i  class="fa">&#xf0d5;</i>
  <i class="fa">&#xf1e0;</i>

</div>
</html>