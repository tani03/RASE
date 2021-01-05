<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.rase.model.Students"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rase.model.College"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Student Profile</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate"); %>
	<br>
	<br>
	<table>
		<jsp:useBean id="Alist"
			class="com.rase.implementation.CollegeServicesImplementation"
			scope="session"></jsp:useBean>


		<c:set var="message" value="${requestScope.DataMessage }" />
		<c:if test="${!empty message }">
			<h3 style="text-align: center; color: red;">
				<c:out value="${message}" />
			</h3>
		</c:if>

		<c:set var="students" value="${requestScope.studentList }" />
		<form action="manageProfileServlet" method="post">
			<tr>
				<th><b>EMAIL ID</b></th>
				<td><input type="text" value="${students.getEmail()}"
					name="email" readonly></td>
			</tr>
			<tr>
				<th><b>FIRST NAME</b></th>
				<td><input type="text" value="${students.getFirstName()}"
					name="firstName"></td>
			</tr>
			<tr>
				<th><b>LAST NAME</b></th>
				<td><input type="text" value="${students.getLastName()}"
					name="lastName"></td>
			</tr>
			<tr>
				<th><b>PHONE NUMBER</b></th>
				<td><input type="text" value="${students.getPhone()}"
					name="phone"></td>
			</tr>
			<tr>
				<th><b>ROLL NUMBER</b></th>
				<td><input type="text" value="${students.getRollNumber()}"
					name="rollNumber"></td>
			</tr>
			<tr>
				<th><b>COLLEGE NAME</b></th>
				<td><select required="required" name="collegeId">
						<option value="${students.getCollege().getCollegeId()}"
							name="collegeId">${students.getCollege().getCollegeName()}</option>
						<%
							ArrayList<College> list = Alist.viewAllCollege();
							for (College college : list) {
						%>

						<option value="<%=college.getCollegeId()%>" name="collegeId"><%=college.getCollegeName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th><b>COURSE START DATE</b></th>
				<td><input type="Date" value="${students.getCourseStartDate()}"
					name="courseStartDate"></td>
			</tr>

			<tr>
				<th><b>COURSE END DATE</b></th>
				<td><input type="Date" value="${students.getCourseEndDate()}"
					name="courseEndDate"></td>
			</tr>

			<tr>
				<th><b>WHICH ACTION YOU NEED</b></th>
				<td><select name="modify" required="required">
						<option value="EDIT">EDIT</option>
						<option value="DELETE">DELETE</option>

				</select></td>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" value="SUBMIT"></td>
			</tr>
	</table>

	</form>
</body>
</html>


</body>
</html>

<style>
input[type=text], input[type=Date], select {
	width: 120%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid green;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: blue;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>