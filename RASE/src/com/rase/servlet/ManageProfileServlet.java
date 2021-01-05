package com.rase.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rase.implementation.LoginServicesImplementation;
import com.rase.implementation.ModifyServicesImplementation;
import com.rase.model.Admin;
import com.rase.model.College;
import com.rase.model.Students;
import com.rase.services.LoginServices;
import com.rase.services.ModifyServices;

@WebServlet("/manageProfileServlet")
public class ManageProfileServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
			
		String action = request.getParameter("modify");
		
	ModifyServices modifyServices = new ModifyServicesImplementation();
		
	
			if (action.equals("EDIT")) {
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
					
					request.setAttribute("DataMessage", "Successfully Edited");
					RequestDispatcher rd=request.getRequestDispatcher("ManageProfileSearch.jsp");  
					rd.forward(request, response);
				}
				else {
					request.setAttribute("DataError", "Error in Data Editing");
					RequestDispatcher rd=request.getRequestDispatcher("ManageProfileSearch.jsp");  
					rd.forward(request, response);
				}
			}
			else {
				
				String email = request.getParameter("email");
				System.out.println(email);
				boolean retvalue = modifyServices.deleteDetails(email);
				
				if(retvalue== true) {
					
					request.setAttribute("DataMessage", "Successfully Deleted");
					RequestDispatcher rd=request.getRequestDispatcher("ManageProfileSearch.jsp");  
					rd.forward(request, response);
				}
				else {
					request.setAttribute("DataError", "Error in Deletion");
					RequestDispatcher rd=request.getRequestDispatcher("ManageProfileSearch.jsp");  
					rd.forward(request, response);
				}
				
			}
	}
}
