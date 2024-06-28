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
<h1>Create Account</h1>
<div class="Container">
<form action="ResisterUser" method="post">
   <lable>Username:</lable><br>
   <input type="text" id="username" name="username" placeholder="Enter your name"  required><br><br>
   <lable>PhoneNo:</lable><br>
   <input type="text" id="phone" name="phone" placeholder="Enter your phone number" required><br><br>
   <lable>Password:</lable><br>
   <input type="text" id="pass" name="pass" placeholder="Enter your password" required><br><br>
   <button type="submit">Create</button>
</form>
<br>
<a href="FrontPage.html" style="font-size:20px;color:blue;">Back to login</a>
<% String ph = request.getParameter("valid");
     if(ph  != null && ph.equals("err"))
    		 {
    	 %><p ><h1 style="color:red;font-size:20px">This phone number is exist please enter another phone number</h1></p> <% 
    		 }
%>

<% String error = request.getParameter("valid");
     if(error  != null && error.equals("success"))
    		 {
    	 %><p><h1 style="color:rgb(0,255,0);font-size:20px">Account is created Successfully<h1></p> <% 
    		 }
%>

<% String error1 = request.getParameter("valid");
     if(error1  != null && error.equals("1"))
    		 {
    	 %><p style="color:#FF0000;font-size:20px">Something Error has happend</p> <% 
    		 }
%>

</div>
</html>