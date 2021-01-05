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

import com.rase.implementation.ProfileServicesImplementation;
import com.rase.model.Students;
import com.rase.services.ProfileServices;



@WebServlet("/viewStudentsProfileServlet")
public class ViewStudentsProfileServlet extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
			
		
		
		ProfileServices profileServices = new ProfileServicesImplementation();
		ArrayList<Students>list = profileServices.viewAllProfile();
		
		if (list.size() !=0) {
			request.setAttribute("ProfileList", list);
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllProfile.jsp"); 
			rd.forward(request, response);
			
		}
		
		
		
		
	}
}
