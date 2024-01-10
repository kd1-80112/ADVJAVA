<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session" />
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="password" param="password" />	
	
	${lb.authenticate()}
    <c:choose>
		<c:when test="${empty lb.user}">
			invalid login or password
			<a href="index.jsp">login again</a>
		</c:when>
		<c:when test="${lb.user.role=='admin'}">
			<c:redirect url="result.jsp"/>
		</c:when> 
			<c:when test="${lb.user.role=='voter'}">
			<c:redirect url="vote.jsp"/>
		</c:when> 
		<c:otherwise >
			<c:redirect url="index.jsp"/>
		</c:otherwise>
	</c:choose>
</body>
</html>