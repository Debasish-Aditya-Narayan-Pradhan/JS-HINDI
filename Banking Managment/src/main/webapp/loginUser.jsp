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
<form action="authentication" method="post">
<label style="font-size:20px">Phoneno:</label><br>
<input style="border:2px solid black" type="text" id="phn" name="phn" required >
<label style="font-size:20px;">Password:</label><br>
<input style="border:2px solid black" type="text" id="pass" name="pass" required>
<button>Login</button>

</form>
<br>
<a href="FrontPage.html" style="font-size:20px;color:blue;">Back to Home</a>
<%
    String err = request.getParameter("user");
    if(err != null && err.equals("success"))
    		{
    	     %><p style="color:green;font-size:20px">You logged Successfully</p> <%
    		}
%>



<%
    String err1 = request.getParameter("user");
    if(err1 != null && err1.equals("1"))
    		{
    	     %><p><h1 style="color:red;font-size:20px">Invalid username and password</h1></p> <%
    		}
%>
</div>
</body>
</html>