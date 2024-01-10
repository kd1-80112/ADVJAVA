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
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegistrationBean" scope="session" />
	Hello, ${rb.firstName} ${rb.lastName} 
		
	<jsp:setProperty name="rb" property="firstName" param="firstName" />
	<jsp:setProperty name="rb" property="lastName" param="lastName" />	
	<jsp:setProperty name="rb" property="email" param="email" />
	<jsp:setProperty name="rb" property="password" param="password" />
	<jsp:setProperty name="rb" property="birth" param="birth" />
	<jsp:setProperty name="rb" property="role" param="role" />	
	${rb.saveuser()}
	
	<c:choose>
		<c:when test="${rb.status}">
			registerd succesfully
		</c:when>
		
	</c:choose>
	   
	
	


</body>
</html>