<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.Connection"%>

    <%@page import="java.sql.DriverManager"%>

    <%@page import="java.sql.Statement"%>

    <%@page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Recipient</h1>

<table>

    <tr>

       <form method="post">

<h2>Traveller Details:</h2>

<table border="2">

<tr>

<td>First Name</td>

<td>Last Name</td>

</tr>

<%

try

{

Class.forName("oracle.jdbc.driver.OracleDriver");

String url="jdbc:oracle:thin:@localhost:1521:";

String username="hr";

String password="hr2";

String query="select * from emp";
String query2="select * from ticket";
String query1="select inv_no.nextval from dual";
Connection conn=DriverManager.getConnection(url,username,password);

Statement stmt=conn.createStatement();
Statement stmt1=conn.createStatement();
Statement stmt2=conn.createStatement();
ResultSet rs1=stmt1.executeQuery(query1);
ResultSet rs=stmt.executeQuery(query);
ResultSet rs2=stmt2.executeQuery(query2);
while(rs.next())

{


%>
    <tr>

    <td><%=rs.getString("first_name") %></td>

    <td><%=rs.getString("last_name") %></td>

</tr>

 <% 
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

    }%>

    </table><br><br>
    
    <table border="2">

<tr>

<td>First Name</td>

<td>Last Name</td>

</tr>

<%

try

{

Class.forName("oracle.jdbc.driver.OracleDriver");

String url="jdbc:oracle:thin:@localhost:1521:";

String username="hr";

String password="hr2";

String query="select * from emp";
String query2="select * from ticket";
String query1="select inv_no.nextval from dual";
Connection conn=DriverManager.getConnection(url,username,password);

Statement stmt=conn.createStatement();
Statement stmt1=conn.createStatement();
Statement stmt2=conn.createStatement();
ResultSet rs1=stmt1.executeQuery(query1);
ResultSet rs=stmt.executeQuery(query);
ResultSet rs2=stmt2.executeQuery(query2);
while(rs.next())

{


%>
    <tr>

    <td><%=rs.getString("source") %></td>

    <td><%=rs.getString("last_name") %></td>

</tr>

 <% 
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

    }%>

    </table><br><br>

</body>
</html>