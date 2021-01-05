<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rase.model.Students"%>
 <%@ include file="AdminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<jsp:include page="SearchAlumni.jsp"></jsp:include>
<br><br>

	<table>
		<tr>
			<th><b>FIRST NAME</b></th>
			<th><b>LAST NAME</b></th>
			<th><b>EMAIL ID</b></th>
			<th><b>PHONE NUMBER</b></th>
			<th><b>ROLL NUMBER</b></th>
			<th><b>COLLEGE NAME</b></th>
		</tr>

		<% ArrayList<Students> list =  
            (ArrayList<Students>) request.getAttribute("SearchList"); 
        for(Students st :list){%>
		<tr>
			<td><%= st.getFirstName()%></td>
			<td><%= st.getLastName()%></td>
			<td><%= st.getEmail()%></td>
			<td><%= st.getPhone()%></td>
			<td><%= st.getRollNumber()%></td>
			<td><%= st.getCollege().getCollegeName()%></td>
		</tr>
		<%}%>


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