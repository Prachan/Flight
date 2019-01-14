<%@page import="java.text.SimpleDateFormat"  import="com.fb.controller.*"%>
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
    <a href="index.php" class="active">Home</a>
    <a href="contactus.html">About US</a>
    <a href="create_account.php">Contact Us</a>
    <a href="Login.jsp">Sign Out</a>
   
   </div>
   
<body background="images/a.jpg" background-size="cover">

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
<! String flight_id="";>
<h1>FLIGHT LIST</h1>


<br>

<br>
<div style="color:red"><center>${success}</center></div> 
   <div style="color:red"><center>${success1}</center></div> 
<TABLE cellpadding="35" id = "myTable" border="1" style="background-color: #ffffcc;">
<tr>
    <th>FlightID</th>
    <th>Franchise</th>
    
<th>Departure Date</th>
<th>Fare</th>
<th>Update</th>
<th>Delete</th>


  </tr>
<%

List<FlightMo> list=(List<FlightMo>)request.getAttribute("list");
SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

for(FlightMo l:list)
{%>

<TR>
<TD><%=l.getFlightID()%></TD>
<TD><%=l.getFlightFranchise()%></TD>
<TD><%=l.getDepartureDate()%></TD>
<TD><%=l.getFare()%></TD>



<td><a href="update.jsp?flight_id=<%=l.getFlightID()%>">
				<button	class="button" type="submit"> Update</a></button></td> 
					
<td><form action='FlightController?action=delete&flight_id=<%=l.getFlightID() %>' method='post'>

<button class="button" type="submit">Delete</button>
</form> 






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