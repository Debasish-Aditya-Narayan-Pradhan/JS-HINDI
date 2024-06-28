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
<form action="NewTransfer" method="post">
<lable>From:</lable>
<input type="text" id="phn" name="phn" required placeholder="Enter your phone number">
<lable>To</lable>
<input type="text" id="to" name="to" required placeholder="Enter phone number to where you want to transfer">
<lable>Money</lable>
<input type="text" id="mny" name="mny" required placeholder="Enter the fund that you want to transfer"> 
<lable>Password</lable>
<input type="text" id="pass" name="pass" required placeholder="Enter your password">
<button>Transfer</button>
<br><br>
<a href="BankProcess.jsp" style="font-size:20px;color:blue;text-decoration:nono;">Back</a>
</form>


<%
String err = request.getParameter("err");
if(err != null && err.equals("no"))
{
	%><p style="color:red">Don't have sufficient fund</p><%
}
%>


<%
String err1 = request.getParameter("err");
if(err1 != null && err1.equals("yes"))
{
	%><p style="color:green">Money has been transfered</p><%
}
%>

<%
String err2 = request.getParameter("err");
if(err2 != null && err2.equals("1"))
{
	%><p style="color:red">Something went wrong</p><%
}
%>


<%
String err3 = request.getParameter("err");
if(err3 != null && err3.equals("0"))
{
	%><p style="color:red">invalid phone number or password</p><%
}
%>

</div>
</body>
</html>