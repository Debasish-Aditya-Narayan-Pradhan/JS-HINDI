<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="front.css">
<title>Insert title here</title>
</head>
<body>
<div class="Container">
<form action="withdrawMoney" method="post">
<lable>Phoneno:</lable>
<input type="text" id="phn" name="phn" required placeholder="Enter your phone number">
<lable>Money</lable>
<input type="text" id="mny" name="mny" required placeholder="Enter your amount to withdraw"> 
<lable>Password</lable>
<input type="text" id="pass" name="pass" required placeholder="Enter your password">
<button>Withdraw</button>
<br><br>
<a href="BankProcess.jsp" style="font-size:20px;color:blue;text-decoration:nono;">Back</a>
</form>
<%
String err = request.getParameter("fund");
if(err != null && err.equals("no"))
{
	%><p ><h1 style="color:red;font-size:20px">Not Sufficient Money to Withdraw</h1></p><%
}
%>

<%
String err1 = request.getParameter("fund");
if(err != null && err.equals("yes"))
{
	%><p><h1 style="color:rgb(0,255,0);font-size:20px">Withdraw Succesfull</h1></p><%
}
%>

<%
String err2 = request.getParameter("fund");
if(err != null && err.equals("1"))
{
	%><p><h1 style="color:red;font-size:20px">Invalid Phoneno or Password</h1></p><%
}
%>
</div>
</body>
</html>