<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

    <%@page import="java.util.List"%>

    <%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

<script type="text/javascript">

function new11()

{

document.getElementById("custId").value = u1;


}


// if the count variable is undefined, set its value to zero

if(! count) {

var count = 0;

}


// function to increment value of count variable

incrementCount() {

  count++;

  if(document.getElementById("custId").value<count)

{

  alert("Hello! I am an alert box!");

}

  

}


</script>
<link href="css/booking.css" rel="stylesheet" type="text/css"/>
</head>

    <div class="navbar">

    <a href="welcome.html" class="active">Home</a>

    <a href="about.html">About Us</a>

    <a href="contactus.html">Contact Us</a>

    <a href="home.html">Sign Out</a>

    

    </div>

<body>

<%! int count=0; %>



  <script src="booking.js">

</script>

<center>

<br><br>

<h1>Traveller Details</h1>


<br>


<div class="container">
  <form id="hidden" method="post">
</br>

  <label id="one"><b>Number of Travellers</b></label>

<h2><input type="number" name="users" maxlength="2" pattern="[0-9]{1,2}" id="user_id" required></h2> 

</br>
    <label><b>First Name</b></label>

    <input style="color:black;" type="text" name="firstName" id="first_input" pattern="[a-zA-Z]" required>

</br>
    <label><b>Last Name</b></label>

    <input style="color:black;" type="text" name="lastName" id="last_input" pattern="[a-zA-Z]" required>
</br>


<label><b>AADHAR Number</b></label>

    <input style="color:black;" type="tel" name="aadharNumber" id="aadhar_input" size="10" maxlength="10" pattern="[0-9]{10}" required>
</br>


<label><b>AGE</b></label>

    <input style="color:black;" type="number" name="age" id="age_input" maxlength="2" pattern="[0-9]{1,2}" required>
</br>


  <label><b>Gender</b></label>

  <select style="color:black; height:30px; width:90%;" id="select1" name="gender" value="select gender">
<option value="">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp-----Select Gender-----</option>
<option value="1">Male</option>
<option value="1">Female</option>
<option value="1">Other</option>
</select>
</br>
</br>

<label><b>Phone Number</b></label>

    <input style="color:black;" type="tel" name="phoneNumber" id="phone_input" size="10" maxlength="10"  pattern="[0-9]{10}" required>

</br>

<label><b>EMAIL ID</b></label>

    <input style="color:black;" type="email" name="email" id="email_input" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,63}$" required>


    <input id="custId" name="users" value=<%=request.getParameter("users")%> type="hidden">
    <input id="flightId" name="flightId" value=<%=request.getParameter("flight_id")%> type="hidden">
   
	
    

</br>
    
	<br>
    <button type="button" class="button" id="button" onclick="increaseCounter()">Confirm</button>

   
    </form>
</br>
</br>

</div>


<script>

var count=0;

var array=new Array();

function increaseCounter()

{

var name=document.getElementById('first_input').value;

array[count]=name;

var str = array.join([separator = ','])

console.log(str);

console.log(document.getElementById('user_id').value);

count++;

console.log(count);

if(count==document.getElementById('user_id').value)

{

console.log("stop");

var form=document.getElementById("hidden");

var elements=form.elements;

for(var i=0,len=elements.length;i<len;++i)

{

elements[i].disabled=true;

}

}

console.log(array);

array.toString();

document.getElementById("h2").value+=document.getElementById('first_input').value+" "

+document.getElementById('last_input').value+" "+document.getElementById('aadhar_input').value+";";

}


</script>

 


   

</center>

<br><br>

<br>

<center>


  

<div class = "clear"></div>
 

<form action="SearchControl?action=booking"  name="frm" method="post">

<input type="hidden" id="h2" name="h2" ></input>
 <input id="userId" name="userId" value=<%=(Integer)session.getAttribute("userid")%> type="hidden">
<input id="flightId" name="flightId" value=<%=request.getParameter("plane_id")%> type="hidden">


<a ><button id="button" class="button">Proceed to Payment</button></a> 

</form>

</body>
<div class="footer">
  <p style="text-align:center;" >FlyBy2018</p>
  <i  class="fa" >&#xf082;</i>
  <i  class="fa">&#xf0d5;</i>
  <i class="fa">&#xf1e0;</i>
</div>



</html>