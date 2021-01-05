package com.rase.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rase.implementation.SearchAlumniServicesImplementation;
import com.rase.model.Students;
import com.rase.services.SearchAlumniServices;
@WebServlet("/studentSearchServlet")
public class StudentSearchServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
			
		String email= request.getParameter("email");
		
		SearchAlumniServices searchAlumni = new SearchAlumniServicesImplementation();
		
		Students students = searchAlumni.searchStudent(email);
		
		if (students !=null) {
			
			request.setAttribute("studentList", students);
			RequestDispatcher rd=request.getRequestDispatcher("ManageProfile.jsp"); 
			rd.forward(request, response);
			
		}
		
		else {
			
			
			request.setAttribute("DataError", "No Data Found");
			RequestDispatcher rd=request.getRequestDispatcher("ManageProfileSearch.jsp");  
			rd.forward(request, response);
		}
		
		
	}

}
