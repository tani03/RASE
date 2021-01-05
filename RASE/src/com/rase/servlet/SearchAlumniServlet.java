package com.rase.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rase.implementation.LoginServicesImplementation;
import com.rase.implementation.SearchAlumniServicesImplementation;
import com.rase.model.Admin;
import com.rase.model.Students;
import com.rase.services.LoginServices;
import com.rase.services.SearchAlumniServices;



@WebServlet("/searchAlumniServlet")
public class SearchAlumniServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
			
		String firstName= request.getParameter("firstName");
		
		SearchAlumniServices searchAlumni = new SearchAlumniServicesImplementation();
		ArrayList<Students>list = searchAlumni.search(firstName);
		
		if (list.size() !=0) {
			System.out.println("List Exist");
			request.setAttribute("SearchList", list);
			RequestDispatcher rd=request.getRequestDispatcher("SearchResult.jsp"); 
			rd.forward(request, response);
			
		}
		
		else {
			
			System.out.println("List Not Exist");
			request.setAttribute("SearchError", "No Data Found");
			RequestDispatcher rd=request.getRequestDispatcher("SearchAlumni.jsp");  
			rd.forward(request, response);
		}
		
		
	}

}
