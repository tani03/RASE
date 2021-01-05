package com.rase.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rase.implementation.ModifyServicesImplementation;
import com.rase.model.College;
import com.rase.model.Students;
import com.rase.services.ModifyServices;


@WebServlet("/studentProfileServlet")
public class StudentProfileChangeServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
				
			ModifyServices modifyServices = new ModifyServicesImplementation();
			
				Students students = new Students();
				College college = new College();
				
				students.setEmail(request.getParameter("email"));
				students.setFirstName(request.getParameter("firstName"));
				students.setLastName(request.getParameter("lastName"));
				students.setPhone(request.getParameter("phone"));
				students.setRollNumber(Integer.parseInt(request.getParameter("rollNumber")));
				college.setCollegeId(Integer.parseInt(request.getParameter("collegeId")));
				students.setCollege(college);
				students.setCourseStartDate(Date.valueOf(request.getParameter("courseStartDate")));
				students.setCourseEndDate( Date.valueOf(request.getParameter("courseEndDate")));
				
				boolean retvalue = modifyServices.updateDetails(students);
				if (retvalue==true) {
					HttpSession stusession2 =request.getSession(true);
					stusession2.setAttribute("studentsObject", students);
					request.setAttribute("DataMessage", "Successfully Edited");
					RequestDispatcher rd=request.getRequestDispatcher("StudentHome.jsp");  
					rd.forward(request, response);
				}
				else {
					request.setAttribute("DataError", "Error in Data Editing");
					RequestDispatcher rd=request.getRequestDispatcher("StudentHome.jsp");  
					rd.forward(request, response);
				}
			
			
	}
}
