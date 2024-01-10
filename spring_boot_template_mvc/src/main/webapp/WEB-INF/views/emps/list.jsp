<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
import spring supplied JSP tag lib 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp List</title>
</head>
<body>
	<table style="background-color: lightgrey; margin: auto">
		<caption>List Of Emps from Dept ${param.deptId}</caption>
		<c:forEach var="emp" items="${requestScope.emp_list}">
			<tr>

				<td>${emp.id}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.joinDate}</td>
				<td>${emp.salary}</td>
				<td><a href="/emps?deptId=${deptId}">Delete</a>
				<td><a href="/emps?deptId=${deptId}">Update</a>
			</tr>
		</c:forEach>
	</table>

</body>
</html>