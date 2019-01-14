<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.fb.model.UserMo" import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>FlyBy Admin Portal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Consultancy Profile Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script src="js/adminlogin.js"></script>
<link href="css/admin.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/smoothbox.css" type='text/css' media="all" />
<link href="//fonts.googleapis.com/css?family=Pathway+Gothic+One" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
</head>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

</style>
</head>
<body>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>



</style>
</head>
<body>


  
    

    <div class="navbar">
    <a href="login.jsp" class="active">Home</a>
    <a href="addFlight.jsp">Add Flight</a>
    <a href="ShowFlightControl">Flight List</a>
    
    <a href="RegistrationControl">Sign Out</a>
    
    </div>



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
  







     
</body>
<%!
String fullName="";
String email="";
String phoneNumber="";
%>

<% 


List<UserMo> list=(List<UserMo>)session.getAttribute("List");
for(UserMo l1:list)
{

if(l1.getRole().equalsIgnoreCase("ADMIN"))
	{
	fullName=l1.getFullName();
	email=l1.getEmail();
	phoneNumber=l1.getMobileNumber();
}


} %>

<div class="main">
<h1>flyBy Admin Portal</h1>
<div id="wrapper" class="w3ls_wrapper w3layouts_wrapper">
<div id="steps" style="margin:0 auto;" class="agileits w3_steps">
<form id="formElem" name="formElem" action="#" method="post" class="w3_form w3l_form_fancy">
<fieldset class="step agileinfo w3ls_fancy_step">
<legend></legend>
<div class="abt-agile">
<div class="abt-agile-left">
</div>
<div class="abt-agile-right">
<h3><%=fullName %></h3>
<ul class="address">
<li>
<ul class="address-text">
<li><b>D.O.B </b></li>
<li>: 03-02-1984</li>
</ul>
</li>
<li>
<ul class="address-text">
<li><b>PHONE </b></li>
<li>:<%=phoneNumber %></li>
</ul>
</li>
<li>
<ul class="address-text">
<li><b>ADDRESS </b></li>
<li>: 22 Russell Street, Andheri East.</li>
</ul>
</li>
<li>
<ul class="address-text">
<li><b>E-MAIL </b></li>
<li>:<%=email %></li>
</ul>
</li>
</ul>
</div>

<div class="clear"></div>
</div>
</fieldset>
<fieldset class="step wthree">
</form>
</div>
</div>
<div class="agileits_copyright">
</div>
</div>
<script type="text/javascript" src="js/smoothbox.jquery2.js"></script>
</body>

<div class="footer">
  <p style="text-align:center;" >©FlyBy2018</p>
  <i  class="fa" >&#xf082;</i>
  <i s class="fa">&#xf0d5;</i>
  <i class="fa">&#xf1e0;</i>

</div>
</html>



    