package com.rase.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rase.implementation.RegisterServicesImplementation;
import com.rase.model.College;
import com.rase.model.Course;
import com.rase.model.Students;
import com.rase.services.RegisterServices;

import oracle.jdbc.driver.OracleDriver;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		response.setContentType("text/html");
		
		
		 
		
		Students students = new Students();
		College college = new College();
		Course course=new Course();
		
		students.setEmail(request.getParameter("email"));
		students.setFirstName(request.getParameter("firstName"));
		students.setLastName(request.getParameter("lastName"));
		students.setPhone(request.getParameter("phone"));
		students.setRollNumber(Integer.parseInt(request.getParameter("rollNumber")));
		college.setCollegeId(Integer.parseInt(request.getParameter("collegeId")));
		students.setCollege(college);
	//	students.setCollegeId(Integer.parseInt(request.getParameter("collegeId")));
		students.setPassword(request.getParameter("password"));
	
		course.setCourseId(request.getParameter("courseId"));
		students.setCourse(course);
		
		
			
		students.setCourseStartDate(Date.valueOf(request.getParameter("courseStartDate")));
		students.setCourseEndDate(Date.valueOf(request.getParameter("courseEndDate")));
		
		
		//System.out.println(students.getCourseStartDate());
	
		RegisterServices registerServices =new RegisterServicesImplementation();
		boolean emailExist = registerServices.checkEmailExist (request.getParameter("email"));
		boolean durationCheck=registerServices.checkDuration(course, students);
	
		if (!emailExist) {
			if(durationCheck) {
			
						boolean regsuccess = registerServices.registerStudents(students);
			
						if (regsuccess) {
				
								request.setAttribute("successMessage", "Successfully registered!You may login now!");
								RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
								dispatcher.forward(request, response);
						}else {
				
								request.setAttribute("errorMessage", "Registration Failed.. Try Again");
								RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
								dispatcher.forward(request, response);
						 		}
			}else {
				request.setAttribute("errorMessage", "Please Enter Correct Duration on basis of Course");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			System.out.println("Email already exist");
			request.setAttribute("errorMessage", "Email already Exist");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
			dispatcher.forward(request, response);
		}
		

		
		
	}

}
