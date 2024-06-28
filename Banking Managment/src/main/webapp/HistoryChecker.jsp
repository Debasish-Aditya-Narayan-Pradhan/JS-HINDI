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
<form action="historySvlt" method="post">
<lable>Phoneno:</lable>
<input type="text" id="phn" name="phn" required placeholder="Enter your phone number"> 
<lable>Password</lable>
<input type="text" id="pass" name="pass" required placeholder="Enter your password">
<button>Check</button>
<br><br>
<a href="BankProcess.jsp" style="font-size:20px;color:blue;text-decoration:nono;">Back</a>
</form>
<%
String err = request.getParameter("user");
if(err != null && err.equals("1"))
{
	%><p><h1 style="color:red;font-size:20px">Invalid username and password</h1></p><% 
}
%>
</div>
</body>
</html>