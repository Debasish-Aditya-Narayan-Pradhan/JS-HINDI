<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="BalanceMoney.css">
<title>Insert title here</title>
</head>
<body>
<div class="Container">
<h1 style="color:green;">Your Balance</h1>
<%
  String s = request.getParameter("fund");
 %><p style="font-size:30px;"><%=s%> rupess</p><%
%>
<a href="BankProcess.jsp" style="font-size:20px;color:blue;text-decoration:nono;">Back</a>
</div>
</body>
</html>