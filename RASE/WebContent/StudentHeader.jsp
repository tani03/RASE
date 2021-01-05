<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Header</title>
</head>
<body>
<div class="header">
  <a  class="logo">ALUMNI SEARCH ENGINE</a>
  <div class="header-right">
    <a href="StudentHome.jsp">HOME</a>
    <a href="Home.jsp">LOGOUT</a>
    
  </div>
</div>
</body>
</html>
<style>
.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}


.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px;
  line-height: 25px;
  border-radius: 4px;
}


.header a.logo {
  font-size: 30px;
  font-weight: bold;
  color: #AD05D6;
}


.header a:hover {
  background-color: #ddd;
  color: blue;
}

.header-right {
  float: right;
}


@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  .header-right {
    float: none;
  }
}


</style>