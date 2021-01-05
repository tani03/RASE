<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rase.model.Students"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tr>
			<th><b>FIRST NAME</b></th>
			<th><b>LAST NAME</b></th>
			<th><b>EMAIL ID</b></th>
			<th><b>PHONE NUMBER</b></th>
			<th><b>ROLL NUMBER</b></th>
			<th><b>COLLEGE NAME</b></th>
			<th><b>COURSE START DATE</b></th>
			<th><b>COURSE END DATE</b></th>
		</tr>

		<c:set var="list" value="${requestScope.ProfileList }" />
		<c:forEach items="${list}" var="students">
			<tr>
				<td><c:out value="${students.getFirstName()}" /></td>
				<td><c:out value="${students.getLastName()}" /></td>
				<td><c:out value="${students.getEmail()}" /></td>
				<td><c:out value="${students.getPhone()}" /></td>
				<td><c:out value="${students.getRollNumber()}" /></td>
				<td><c:out value="${students.getCollege().getCollegeName()}" /></td>
				<td><c:out value="${students.getCourseStartDate()}" /></td>
				<td><c:out value="${students.getCourseEndDate()}" /></td>
				

			</tr>
		</c:forEach>
	</table>





</body>
</html>

<style>
table {
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
}
</style>