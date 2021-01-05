<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rase.model.College" %>    
<%@page import="com.rase.model.Course" %>
<%@ include file="AdminHeader.jsp" %>
<jsp:useBean id="collegesList" class="com.rase.implementation.ViewCollegeImplementation" scope="session"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Remove College</title>
<link rel="stylesheet" href="css/addformstyle.css">
</head>
<body>
	<div class="about-section">
  		<h1>Welcome to ALP University</h1>
  		<h2>REMOVE COLLEGE</h2>
	</div>

 	<div class="container">
 		<c:set var="errorMessage" value="${requestScope.SearchError }" />
 		<c:if test="${!empty errorMessage }"/>
 		<h2 style="text-align: center; color: red;"><c:out value="${errorMessage}"/></h2>
 		<c:set var="sucessMessage" value="${requestScope.sucessMessage }" />
		<c:if test="${!empty sucessMessage }"/>
	 	<h2 style="text-align: center; color: blue;"><c:out value="${errorMessage}"/></h2>
	 

 		<form action="removeCollege" method="post">
 		<table class="center">
 			<tr>
 				<td><label for="collegeName">College Name</label></td>
 				<td>
 				<select id="collegeName" name="collegeId" onchange="javascript:getVal()">
 				<option value=null>Select College Name</option>
 				<% 
						ArrayList<College> li= collegesList.sendCollegeList();
        				for(College cl :li){
       			 %>
        		<option value="<%= cl.getCollegeId()  %>" ><%= cl.getCollegeName() %> </option>
		
				<%
        			}
				%>
        		</select>
 		</table>
 
 
 
 			<div class="center">
 				<input type="submit" class="button" value="Remove">
 			</div>
 		</form>
 
 
 	</div>
</body>
</html>