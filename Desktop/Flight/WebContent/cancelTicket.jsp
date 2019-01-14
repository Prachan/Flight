<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.Connection"%>

    <%@page import="java.sql.DriverManager"%>

    <%@page import="java.sql.Statement"%>

    <%@page import="java.sql.ResultSet" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
function SomeDeleteRowFunction(o) {
    //no clue what to put here?
    var p=o.parentNode.parentNode;
        p.parentNode.removeChild(p);
   }
   
</script>

<link rel="stylesheet" href="css/cancelTicket.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Ticket</title>
</head>
<div class="navbar">
    <a href="adminlogin.html" class="active">Home</a>
    <a href="addflight.html">Add Flight</a>
    <a href="cancelflight.html">Flight List</a>
    <a href="home.html">Sign Out</a>
    
    </div>
<body>
<h1>Cancel Ticket</h1>
<br>
<br>
<div class="container">


       <form action="SearchControl?action=cancel" method="post">

<h2>Ticket Details:</h2>
<br>
 <div style="color:red"><center>${success}</center></div>  
<table id="tab" border="2" align="center">

<tr>
<th>TICKET ID</th>
<th>USER ID</th>
<th>DEPARTURE DATE</th>
<th>PRICE</th>
<th>Ticket Cancel</th>
</tr>

<%

try

{

Class.forName("oracle.jdbc.driver.OracleDriver");

String url="jdbc:oracle:thin:@localhost:1521:xe";

String username="hr";

String password="hr2";
String query="select * from tickets where departure_date > sysdate and userid='"+session.getAttribute("userid")"'";
String query1 = "select ticketId.nextval from dual";

Connection conn=DriverManager.getConnection(url,username,password);

Statement stmt=conn.createStatement();

ResultSet rs=stmt.executeQuery(query);
SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

while(rs.next())
{
	String ticketid = rs.getString(1);
	//System.out.println(ticketid);
%>

    
	
    <tr>

    <td><%=rs.getString(1) %></td>
	<td><%=rs.getString(2) %></td>
    <td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	<td>
	<input type="hidden" id="inp" name="cancel" value="<%=rs.getString(1)%>">
	<button class="button" type="submit" >CONFIRM</button>
</tr>

        <%
request.setAttribute("cancel",rs.getString(1));

}

%>

  
    <%

    rs.close();

    stmt.close();

    conn.close();

    }

catch(Exception e)

{

    e.printStackTrace();

    }





%>
  </table>

</form>
</div>

</body>

<div class="footer">
  <p style="text-align:center; color:white;" >©FlyBy2018</p>
  <i  class="fa" >&#xf082;</i>
  <i class="fa">&#xf0d5;</i>
  <i  class="fa">&#xf1e0;</i></div>
</html>