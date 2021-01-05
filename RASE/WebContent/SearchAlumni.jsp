<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <%@ include file="StudentHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="center">

<c:set var="message" value="${requestScope.SearchError }" />
<c:if test="${!empty message }"/>
<h3 style="text-align: center; color: red;"><c:out value="${message}"/></h3>


<h2 style="text-align: center;">Search Alumni</h2>
<form class="example" action="searchAlumniServlet" method="post">
  <input type="text" placeholder="Enter First Name" name="firstName" required>
 <input type="submit" class="btn" value="Search">
</form>
</div>
</body>
</body>
</html>

<style>
.center {
  margin: auto;
  width: 30%;
  border: 3px solid grey;
  padding: 10px;
}

.textcenter {
  margin: auto;
  width: 100%;
  border: 3px ;
  padding: 10px;
}

input[type=text]{
  width: 100%;
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

input[type=submit]:hover {
  background-color: #45a049;
}





</style>