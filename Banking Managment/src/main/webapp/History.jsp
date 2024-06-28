<%@page import="UserProcess.com.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% UserValid u = new UserImp();  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="front.css">
<title>Insert title here</title>
</head>
<body style="display:flex;justify-content:center;">
<table border="1" cellspacing="1" cellpadding="10px">

<tr><th>Username</th>
<th>Phoneno</th>
<th>phoneno_to</th>
<th>trans_fund</th>
<th>ramiang_fund</th>
<th>Date_time</th></tr>
<%
String phn = request.getParameter("phn");
%>
<%
try
{
	ResultSet rs = null;
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs","root","lulu@2004");
	String qry = "SELECT * FROM transcations WHERE phone_no = ?";
	PreparedStatement pt = con.prepareStatement(qry);
	pt.setString(1, phn);
    rs = pt.executeQuery();
	if(rs==null)
	{
	%><h1>No Data found</h1><%
	}
while(rs.next())
{
	
	%><tr><td><%=rs.getString("username") %></td>
	<td><%=rs.getString("phone_no") %></td>
	<td><%=rs.getString("phone_no_to") %></td>
	<td><%=rs.getString("trans_fund") %></td>
	<td><%=rs.getString("remaining_fund") %></td>
	<td><%=rs.getTimestamp("Date_time") %></td></tr><%
}
}catch(SQLException e)
{
	e.printStackTrace();
}finally
{
	System.out.println("Completed!");
}
%>
</table>
<a href="BankProcess.jsp" style="font-size:20px;color:blue;text-decoration:nono;">Back</a>
</body>
</html>