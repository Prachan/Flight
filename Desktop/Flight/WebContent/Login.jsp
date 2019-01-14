
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Login Form </title>
<link rel="stylesheet" href="css/login.css">

</head>
<body>
<div class="loginBox">
<div style="color:red; text-align:center;">${message}</div> 
<img src="images/a.jpg" class="user">
<h2>Log In Here</h2>
<form action="RegistrationControl?action=login" method="post">
<p>Email</p>
<input type="email" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,63}$" name = "email" placeholder="Enter Email" required>
<p>Password</p>
<input type="password" name = "password" placeholder="Enter Password" required>
<input type="submit" value="Sign In">
<center>
<a href="Registration.jsp">New User Register here</a> <br><br>

</center>
</form>
</div>
</body>
</html>