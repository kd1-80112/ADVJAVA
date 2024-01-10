<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="rb" class="com.sunbeam.beans.RegisterBean"/>
	<jsp:setProperty name="rb" property="*" />
	
	<% rb.saveuser(); %>
	Login Status: <jsp:getProperty name="rb" property="status" /> <br/><br/>
	<%
		if(rb.getStatus())
			out.println("user is added");
		else
			out.println("user is not added");
	%>
</body>
</html>