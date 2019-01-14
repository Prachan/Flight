
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

    <%@page import="java.sql.Connection"%>

    <%@page import="java.sql.DriverManager"%>

    <%@page import="java.sql.Statement"%>

    <%@page import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>


<link rel="stylesheet" href="css/invoice.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>
<body>
<% String price=request.getAttribute("price").toString(); %>
<%int invoiceNO=0; %>

<header>
<input id="userId" name="userId" value=<%=(Integer)session.getAttribute("userid")%> type=""> 




<h1>Invoice</h1>

<address >

<p>Mr.${name} </p>


</address>




<span><img alt="" src="https://www.designfreelogoonline.com/wp-content/uploads/2016/01/000679-Free-logo-maker-Aircraft-Logo-Templates-02.png"><input type="file" accept="image/*"></span>

</header>



<h1>Recipient</h1>

<table>

    <tr>

       <form method="post">

<h2>Traveller Details:</h2>

<table border="2">

<tr>

<td>Name</td>



</tr>



<%

try

{

Class.forName("oracle.jdbc.driver.OracleDriver");

String url="jdbc:oracle:thin:@localhost:1521:";

String username="hr";

String password="hr2";

String query="select name from booking where userid=? and ticket_id=?";
String query2="select * from ticket1";
String query1="select inv_no.nextval from dual";
String query3="SELECT TO_CHAR(SYSDATE, 'DD-MON-YYYY HH:MI:SS') FROM dual";
Connection conn=DriverManager.getConnection(url,username,password);
PreparedStatement pstmt=null;
pstmt=conn.prepareStatement(query);
System.out.println(session.getAttribute("userid"));
System.out.println(session.getAttribute("ticketid"));

//pstmt.setString(1,(session.getAttribute("ticketid").toString()));
pstmt.setString(1,(session.getAttribute("userid").toString()));
pstmt.setString(2,(session.getAttribute("ticketId").toString()));
//pstmt.execute();
Statement stmt=conn.createStatement();
Statement stmt1=conn.createStatement();
Statement stmt2=conn.createStatement();
Statement stmt3=conn.createStatement();
ResultSet rs1=stmt1.executeQuery(query1);
ResultSet rs=pstmt.executeQuery();
//ResultSet rs2=stmt2.executeQuery(query2);
ResultSet rs3 = stmt3.executeQuery(query3);


while(rs.next())
{
%>
    <tr>

    <td><%=rs.getString("name") %></td>



</tr>

        <%


}

%>

    </table><br><br>
<%

while(rs1.next())
{
	 invoiceNO=rs1.getInt(1);
//System.out.println(invoiceNO);
	%>


</form>

    </tr>

</table>

<table >

<tr>

<th>Invoice No</th>

<td><%=invoiceNO %></td>

</tr>
<%


}

%>

<tr>

<th><span >Amount </span></th>

<td>Rs. ${price}</td>

</tr>

</table><br><br>


<h2>Flight Details:</h2>

<table>

<tr>


<th>Source</th>

<th>Destination</th>

<th>Departure Date</th>

</tr>
<%


	
System.out.println(session.getAttribute("source"));
System.out.print(session.getAttribute("destination"));
	%>
<tr>

    <td><%=session.getAttribute("source") %></td>

 <td><%=session.getAttribute("destination") %></td>
    
  <td><%=session.getAttribute("departuredate") %></td>

</tr>
<%




%>
</table>


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


</body>
</html>
