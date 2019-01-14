<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="red">
<% 
if (session != null) {
			if (session.getAttribute("username") != null) {
				String name = (String) session.getAttribute("username");
				out.print("Welcome, " + name);
			} else {
				response.sendRedirect("login.html");
			}
		}
%>
<p><h2>HI</h2></p>
<form action="UserLogOutController" method="post">
<input type="submit" value="Logout"> 
</form>
</body>
</html>