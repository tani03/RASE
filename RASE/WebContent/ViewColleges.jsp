<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rase.model.College" %>    
<%@page import="com.rase.model.Course" %>
<%@include file="AdminHeader.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/addformstyle.css">
<title>college list</title>
</head>
<body>
	<jsp:useBean id="collegeList" class="com.rase.implementation.ViewCollegeImplementation" scope="session"></jsp:useBean>
	
	<table class="center">
		<tr>
			<th><b>COLLEGE ID</b></th>
			<th><b>COLLEGE NAME</b></th>
			<th><b>COLLEGE ADDRESS</b></th>
			
			
		</tr>

		<% ArrayList<College> li= collegeList.sendCollegeList();
        	for(College cl :li){%>
		<tr>
			<td><%= cl.getCollegeId()%></td>
			<td><%= cl.getCollegeName() %></td>
			<td><%=cl.getCollegeAddress()%></td>
		</tr>
		<%}%>


	</table>
</body>
</html>