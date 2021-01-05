<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="AdminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" href="css/Adminhp.css">
</head>
<body>
<div class="about-section">
  <h1>ALP University</h1>
  <h2>Welcome Admin!</h2>
    </div>

<div class="row">
  <div class="column">
    <div class="card">
     <center> <img src="images/Profile.png" alt="Profile" style="width:30%"></center>
      <div class="container">
         <p class="title">View Profile</p>
        <p>View all Profiles.</p>
        <p><button class="button" onclick="document.location='viewStudentsProfileServlet'">View Profiles</button></p>
      </div>
    </div>
  </div>


  <div class="column">
    <div class="card">
     <center> <img src="images/Events.png" alt="Events" style="width:30%"></center>
      <div class="container">
        <p class="title">Manage Events</p>
        <p>Manage all Events.</p> 
        <p><a href="events"><button class="button">View Events</button></a></p>
      </div>
    </div>
  </div>
</div>

<div class="row">
  <div class="column">
    <div class="card">
      <center><img src="images/Profile.png" alt="Profile" style="width:30%"></center>
      <div class="container">
        <p class="title">Manage Profiles</p>
        <p>Manage all Profiles.</p> 
        <p><button class="button" onclick="document.location='ManageProfileSearch.jsp'">Manage Profiles</button></p>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <center><img src="images/Events.png" alt="Events" style="width:30%"></center>
      <div class="container">
         <p class="title">Add Event</p>
        <p>Add New Event</p>
        <p><a href="modifyEvents?action=Create"><button class="button">Add Events</button></a></p>
      </div>
    </div>
  </div>
</div>



<div class="row">
  <div class="column">
    <div class="card">
      <center><img src="images/College.png" alt="College" style="width:30%"></center>
      <div class="container">
        <p class="title">Add Colleges</p>
        <p>Add/Remove Colleges</p> 
        <p><button class="button" onclick="document.location='UpdateColleges.jsp'">Update Colleges</button></p>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <center><img src="images/College.png" alt="College" style="width:30%"></center>
      <div class="container">
         <p class="title">View Colleges</p>
        <p>View all Colleges</p>
        <p><button class="button" onclick="document.location='ViewColleges.jsp'">View Colleges</button></p>
      </div>
    </div>
  </div>
</div>




</body>
</html>