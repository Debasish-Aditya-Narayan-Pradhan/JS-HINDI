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
<form action="depositeMoney" method="post">
<lable>Phoneno:</lable>
<input type="text" id="phn" name="phn" required placeholder="Enter your phone number">
<lable>Money</lable>
<input type="text" id="mny" name="mny" required placeholder="Enter your amount"> 
<lable>Password</lable>
<input type="text" id="pass" name="pass" required placeholder="Enter your password">
<button>Deposite</button>
<br><br>
<a href="BankProcess.jsp" style="font-size:20px;color:blue;text-decoration:nono;">Back</a>
</form>
<%
    String sucss = request.getParameter("transfer");
    if(sucss != null && sucss.equals("success"))
    		{
    	%><p ><h1 style="color:rgb(0,255,0);font-size:20px;">Money has been transfered</h1></p><%
    		}
%>

<%
    String s = request.getParameter("transfer");
    if(s != null && s.equals("err"))
    		{
    	%><p><h1 style="color:red;font-size:20px;">Invalid Phone number and password<h1></p><%
    		}
%>
</div>
</body>
</html>