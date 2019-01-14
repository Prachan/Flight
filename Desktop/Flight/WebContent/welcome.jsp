<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="javax.servlet.http.HttpSession" %>
    <!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Welcome||FLyBy</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Different Tab Forms Widget Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"
/>
<script>
addEventListener("load", function () {
setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
window.scrollTo(0, 1);
}
</script>
<!-- //for-mobile-apps -->
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!-- //font-awesome icons -->
<link href="css/welcomefile.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&subset=latin-ext" rel="stylesheet">
</head>
<body>

<div>
<%!
String uname=null;
int userid=0;
%>
<%
if(session==null){
	response.sendRedirect("Login.jsp");
}else{
 uname=(String)session.getAttribute("username");
 userid=(Integer)session.getAttribute("userid");
}
%>

</div>

    <div class="navbar">
    <a href="welcome.jsp" class="active">Home</a>
    <a href="about.html">About Us</a>
    <a href="contactus.html">Contact Us</a>
   <div style="color:white;font-size:25px;" align="right" id="zoo">Hello <%=uname%></div>
    
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
   
   
  
</br>
</br>
</br>
<center><h1><b>WELCOME TO FLYBY</b></h1></center>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
<center>

<a  href="search.jsp"><button class="button"><span>Search Flight </span></button></a>
<a href="cancelTicket.jsp"><button class="button"><span>Cancel Ticket </span></button></a>
<a href="editProfile.jsp"><button class="button"><span>Edit Profile </span></button></a>
<a href="RegistrationControl" ><button class="button"><span>Logout </span></button></a>

</center>




</body>
<div class="footer">
  <p style="text-align:center;" >©All right reserved FlyBy 2018</p>
  <i  class="fa" >&#xf082;</i>
  <i  class="fa">&#xf0d5;</i>
  <i  class="fa">&#xf1e0;</i>

</div>

</html>
