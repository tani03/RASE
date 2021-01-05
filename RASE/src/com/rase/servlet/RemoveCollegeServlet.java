package com.rase.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rase.implementation.AdminCollegeServicesImplementation;
import com.rase.implementation.ViewCollegeImplementation;
import com.rase.model.College;
import com.rase.model.Course;
import com.rase.services.AdminCollegeServices;
import com.rase.services.ViewCollegeServices;

@WebServlet("/removeCollege")
public class RemoveCollegeServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int collegeId=Integer.parseInt(request.getParameter("collegeId"));
		
		
		
		AdminCollegeServices collegeservices=new AdminCollegeServicesImplementation();
		
			if(collegeservices.removeCollege(collegeId)) {
				System.out.println("method returned true");
				request.setAttribute("successMessage", "College Removed Successfully!!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("removeCollege.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("errorMessage", "Operation failed!!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("removeCollege.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
	
}
