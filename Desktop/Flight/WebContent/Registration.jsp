<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title> Login Form </title>
<link rel="stylesheet" href="css/Signup1.css">

</head>
<body>
<script language='javascript' type='text/javascript'>
    var password = document.getElementById("password")
  , confirm_password = document.getElementById("confirm_password");

function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>
<div class="loginBox">
<img src="images/user.png" class="user">
<h2>Sign Up Here</h2>
<div style="color:white"><center>${success}</center></div> <div class="col-md-3">
<form action="RegistrationControl?action=registration" method="post">
<p>Full Name</p>
<input type="text" name = "fullName" placeholder="Enter Full Name" required>
<p>Email</p>
<input type="email" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,63}$" name = "email" placeholder="Enter Email" required>
<p>Password</p>
<input type="password" id="password" name="password" placeholder="Enter Password" required>
<p>Phone</p>
<input type="tel" maxlength="10" size="10" name="mobileNumber" pattern="[0-9]{10}" placeholder="xxxxxxxxxx" required>
<p>Date of Birth</p>
<input type="date" name = "dob" placeholder="DD-MM-YYYY" required>
<p>Aadhar Number</p>
<input type="text" name="aadhar" pattern="[0-9]{12}" maxlength="12" size="12" placeholder="xxxxxxxxxxxx" required>
<center><p>Gender</p></center>
<br>
                                   <center>
<select id="select1" name="gender" value="select gender">
<option value="">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp-----Select Gender-----</option>
<option value="1">Male</option>
<option value="1">Female</option>
<option value="1">Other</option>
</select>
</center>
<br>
<br>

<input type="submit" name = "" onclick=validatePassword() value="Sign Up">
<center>
<a href="Login.jsp">Already a user ? Log In</a> 

</form>

</div>
</body>
</html>