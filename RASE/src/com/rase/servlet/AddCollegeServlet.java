package com.rase.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rase.implementation.AdminCollegeServicesImplementation;
import com.rase.model.College;
import com.rase.model.Course;
import com.rase.services.AdminCollegeServices;

@WebServlet("/addCollege")
public class AddCollegeServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int collegeId=Integer.parseInt(request.getParameter("collegeId"));
		String collegeName=request.getParameter("collegeName");
		String collegeAdd=request.getParameter("collegeAdd");
		String courseName=request.getParameter("courseName");
		
		AdminCollegeServices collegeservices=new AdminCollegeServicesImplementation();
		if((collegeservices.checkCollegeNameExists(collegeName,collegeId))){ // as college name exists,return error msg
			request.setAttribute("error", "College Name or CollegeID already exists!!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddColleges.jsp");
			dispatcher.forward(request, response);
		}
		else {
			College college=new College();
			Course course=new Course();
			college.setCollegeId(collegeId);
			college.setCollegeName(collegeName);
			college.setCollegeAddress(collegeAdd);
			course.setCourseId(courseName);
			if(collegeservices.addCollegeDetails(college,course)) {
				request.setAttribute("success", "College Added Successfully!!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddColleges.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("error", "College registration failed!!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddColleges.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
	}

}
