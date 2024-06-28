<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Bank.css">
<title>Insert title here</title>
</head>
<body style="background-image:url(BankProcess.jpg);background-repeat:no-repeat;background-position:center;background-size:cover;">
<%
String name = request.getParameter("name");
String CpyNme = name;
%>
<center><h1>Hello <%=CpyNme %></h1>
</center>
<div class="Container">

<button><a href="deposite.jsp" style="color:white;text-decoration:none">Deposite</a></button>
<br>
<button><a href="withdraw.jsp" style="color:white;text-decoration:none">Withdraw</a></button>
<br>
<button><a href="transfer.jsp" style="color:white;text-decoration:none">Transfer</a></button>
<br>
<button><a href="balance.jsp" style="color:white;text-decoration:none">Balance</a></button>
<br>
<button><a href="HistoryChecker.jsp" style="color:white;text-decoration:none">History</a></button>
<br><br>
<a href="FrontPage.html" style="font-size:20px;color:blue;text-decoration:nono;">Back to home</a>
</div>
</body>
</html>