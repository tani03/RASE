<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rase.model.College" %>    
<%@page import="com.rase.model.Course" %>
<%@ include file="Header.jsp" %>

<jsp:useBean id="collegeList" class="com.rase.implementation.ViewCollegeImplementation" scope="session"></jsp:useBean>
<jsp:useBean id="courseList" class="com.rase.implementation.ViewCourse" scope="session"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<script>
		function sendId()
		{
			var a=document.getElementById('collegeName').value;
			var c=courseList;
			
		}
	</script>

<title>Registration</title>
 <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<body>
	<%
		String errorMessage=(String)request.getAttribute("errorMessage");
		String successMessage=(String)request.getAttribute("successMessage");
		if(errorMessage!=null){
			out.println("<p style=\"color:red;\">"+errorMessage+"</p>");
		}
		if(successMessage!=null){
			out.println("<p style=\"color:blue;\">"+successMessage+"</p>");
		}
		
	%>
	<form class="signup-form" action="RegisterServlet" method="post">

      <!-- form header -->
      <div class="form-header">
        <h1>Student Registration</h1>
      </div>

<div class="form-group">
        <!-- firstname and lastname -->
        <div class="horizontal-group">
          <div class="form-group left">
            <label for="firstname" class="label-title">First name*</label>
            <input type="text" id="firstname" class="form-input" name="firstName" placeholder="enter your first name" required="required" />
          </div>
          <div class="form-group right">
            <label for="lastname" class="label-title">Last name*</label>
            <input type="text" id="lastname" name="lastName" class="form-input" placeholder="enter your last name" required="required" />
          </div>
        </div>

        <!-- Email -->
        <div class="form-group">
          <label for="email" class="label-title">Email*</label>
          <input type="email" id="staticEmail" name="email" class="form-input" placeholder="enter your email" required="required">
        </div>

        <!-- Password -->
         <div class="form-group">
            <label for="password" class="label-title">Password *</label>
            <input type="password" id="password" name="password" class="form-input" placeholder="enter your password" required="required">
          </div>

           <!---Phone Number -->
         <div class="form-group">
            <label for="phonenumber" class="label-title">Phone Number*</label>
            <input type="text" id="phonenumber" name="phone" class="form-input" placeholder="enter your contact number" required="required" />
          </div>

        <!---Roll Number -->
           <div class="form-group">
            <label for="rollnumber" class="label-title">Roll Number *</label>
            <input type="text" class="form-input" id="rollnumber" name="rollNumber" placeholder="enter your roll number" required="required">
          </div>
        

        <!-- Start and End Date -->
        <div class="horizontal-group">
          <div class="form-group left">
            <label class="label-title">Course Start Date:</label>
            <div class="input-group">
            <label for="startdate">
            <input type="date" name="courseStartDate"   placeholder="dd-mm-yyyy" value=""min="1997-01-01" max="2030-12-31" required="required">
              </label>
            </div>
          </div>
          <div class="form-group right">
            <label class="label-title">Course End Date:</label>
            <div class="input-group">
            <label for="enddate">
            <input type="date" name="courseEndDate"   placeholder="dd-mm-yyyy" value=""min="1997-01-01" max="2030-12-31" required="required">
              </label>
            </div>
          </div>
        </div>

        <!-- College Name -->
        <div class="form-group">
            <label class="label-title">College Name</label>
         
		<select class="form-input" id="collegeName" name="collegeId" onchange='sendId()'>
			<% 
				int id;
				ArrayList<College> li= collegeList.sendCollegeList();
        		for(College cl :li){
        	%>
        	<option value="<%= cl.getCollegeId()  %>" ><%= cl.getCollegeName() %> </option>
		
		<%
				id=cl.getCollegeId();
        		}
		%>
         </select> 
      
  		</div>
  		<label class="label-title">Course Name</label>
         <!-- Course Name -->
        <div class="form-group">
            <select class="form-input" id="courseName" name="courseId">
			<% 
				ArrayList<Course> c= courseList.sendCourseList();
        		for(Course cr :c){
        	%>
        	<option value="<%= cr.getCourseId()  %>" ><%= cr.getCourseName() %> </option>
        	
		
			<%
        		}
			%>
         </select> 
          </div>
    </div>
      <!-- form-footer --> 
      <div class="form-footer">
           <div class="center"><input type="submit" class="btn" value="Register"></div>
      </div>
 
    </form>
    

</body>
</html>

