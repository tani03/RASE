<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">

</head>
<body>
 		<c:set var="error" value="${requestScope.error}"/>
       <c:if test="${!empty error }">
			<p class="error" style="color:red;"><c:out value="${error }"></c:out></p>
      	</c:if>
      	<c:set var="error" value="${requestScope.successMessage}"/>
       	<c:if test="${!empty error }">
			<p class="error" style="color:blue;"><c:out value="${error }"></c:out></p>
      	</c:if>
      <div class="main">
      <p class="login">Login</p>
      
    
      
      <form class="form1" action="login" method="post"> 
      		<center>
          <input  type="radio"  name="role" value="admin" id="admin" required> 
		  <label for="admin">Admin</label>
          <input type="radio"  name="role" value="student" id="student" required>  
          <label for="student">Student</label></center>
        <br> 
          <input class="un " type="text" name="username"  placeholder="Username">
          <input class="pass" type="password" name="password" placeholder="Password">
          <input class="submit" type="submit" value="Login">
          </form>           
      </div>

      
  </body>
</html>