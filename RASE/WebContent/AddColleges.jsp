<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="AdminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add college</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/addformstyle.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">

</head>
<body>
      <div class="main">
      <p class="login">Add New College</p>
      
      <c:set var="error" value="${requestScope.error}"/>
       <c:if test="${!empty error }">
			<p style="text-align:center; font-size: small; color:red;"><c:out value="${error}"></c:out></p>
      </c:if>
      
      <form class="form1" action="addCollege" method="post"> 
      <table class="center">
         <tr>
         	<td>College ID:</td>
          	<td><input class="number " type="text" name="collegeId"  placeholder="Enter College ID" required></td>
          </tr >
         <tr>
         	<td>College Name:</td>
          	<td><input class="textin " type="text" name="collegeName"  placeholder="Enter College Name" required></td>
          </tr >
          <tr>
          <td>College Address:</td>
          <td><input  class="un "  type="text" name="collegeAdd"  placeholder="Enter College Address" required></td>
          </tr>
         	<!-- <td>Course Name :</td>
          <td><input  class="un "  type="text" name="courseName"  placeholder="Enter Course Name" required></td>
          </tr> -->
          </table>
          <div class="center"><input class="submit" type="submit" value="ADD"></div> 
          </form>    
               <c:set var="success" value="${requestScope.success}"/>
       <c:if test="${!empty success }">
			<p style="text-align: center; font-size: large; font-weight: bold; color:blue;"><c:out value="${success}"></c:out></p>
      </c:if>  
      </div>

      
  </body>
</html>