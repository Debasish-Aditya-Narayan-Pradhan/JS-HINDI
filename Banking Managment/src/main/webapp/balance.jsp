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

</body><div class="Container">
<form action="balanceUser" method="post">
<lable>Phoneno:</lable>
<input type="text" id="phn" name="phn" required placeholder="Enter your phone number">
<lable>Password</lable>
<input type="text" id="pass" name="pass" required placeholder="Enter your password">
<button>Check</button>
<br><br>
<a href="BankProcess.jsp" style="font-size:20px;color:blue;text-decoration:nono;">Back</a>
<%
 String err = request.getParameter("fund");
if(err != null && err.equals("err"))
{
	%><p style="color:red;">Invalid phonenumber or password</p><%
}
%>
</form>
</html>