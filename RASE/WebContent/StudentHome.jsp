<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="StudentHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Home Page</title>
<link rel="stylesheet" href="css/Studenthp.css">
</head>
<body>
<div class="about-section">
  <h1>Welcome to ALP University</h1>
  <h2>Together we can go far beyond</h2>
  </div>


<div class="row">
  <div class="column">
    <div class="card">
    <center>   <img src="images/Profile.png" alt="Profile" style="width:30%"> </center>
      <div class="container">
         <p class="title">Profile</p>
        <p>View your Profile.</p>
        <p><button class="button" onclick="document.location='StudentProfileView.jsp'">Profile</button></p>
      </div>
    </div>
  </div>


  <div class="column">
    <div class="card">
     <center>  <img src="images/Events.png" alt="Events" style="width:30%">  </center>
      <div class="container">
        <p class="title">Events</p>
        <p>View all events.</p> 
        <p><button class="button" onclick="document.location='Events.jsp'">Events</button></p>
      </div>
    </div>
  </div>
</div>


<div class="row">
  <div class="column">
    <div class="card">
       <center><img src="images/Career.png" alt="Career" style="width:30%"> </center>
      <div class="container">
        <p class="title">Career Assistance</p>
        <p>Get our experts advice.</p> 
        <p><button class="button" onclick="document.location='CareerAssistance.jsp'">Career Assistance</button></p>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
   <center>   <img src="images/Helpdesk.png" alt="Helpdesk" style="width:45%"> </center>
      <div class="container">
         <p class="title">Helpdesk</p>
        <p>Reach out to us.</p>
        <p><button class="button" onclick="document.location='Helpdesk.jsp'">Helpdesk</button></p>
      </div>
    </div>
  </div>
</div>
</body>
</html>