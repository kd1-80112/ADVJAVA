<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>authentication</title>
</head>
<body>
<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"/>
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="password" param="passwd" />
	<jsp:setProperty name="lb" property="status" value="false" />
	<% lb.authenticate(); %>
	Login Status: <jsp:getProperty name="lb" property="status" /> <br/><br/>
	<%
		if(lb.getStatus())
			out.println("Welcome, User!");
		else
			out.println("Invalid Login!");
	%>
	</body>
</html>