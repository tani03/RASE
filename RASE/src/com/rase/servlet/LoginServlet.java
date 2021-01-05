package com.rase.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rase.implementation.LoginServicesImplementation;
import com.rase.model.Admin;
import com.rase.model.Students;
import com.rase.services.LoginServices;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = -836760996003335261L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher ;
		if(req.getSession().getAttribute("type") == null) {
			dispatcher = req.getRequestDispatcher("Login.jsp");
			}
			else if(req.getSession().getAttribute("type") == "student" ){
				dispatcher = req.getRequestDispatcher("StudentHome.jsp");
			}
			else if(req.getSession().getAttribute("type") == "admin" ){
				dispatcher = req.getRequestDispatcher("AdminHome.jsp");
			}
			else {
				dispatcher = req.getRequestDispatcher("Login.jsp");
			}
			dispatcher.forward(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String role = request.getParameter("role");
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Pragma","no-cache"); 
		response.setDateHeader ("Expires", -1); 
		LoginServices loginservices = new LoginServicesImplementation();
		RequestDispatcher dispatcher = null;
		
		try {
			if (role.equals("admin")) {
				Admin admin;
				admin = loginservices.adminLogin(request.getParameter("username"),request.getParameter("password"));
				
				
				
				if (admin!=null) {
					request.getSession().setAttribute("adminDetails", admin);
					dispatcher = request.getRequestDispatcher("AdminHome.jsp");
					request.getSession().setAttribute("type", "admin");
				}
				else {
					request.setAttribute("errorMessege", "Invalid Credential");
					dispatcher = request.getRequestDispatcher("Login.jsp");
				}
			}
			else {
				Students student;
				student = loginservices.studentLogin(request.getParameter("username"),request.getParameter("password"));
				 
				if (student != null) {
					request.getSession().setAttribute("studentDetails", student);
					request.getSession().setAttribute("type", "student");
					dispatcher = request.getRequestDispatcher("StudentHome.jsp");
				}
				else {
					request.setAttribute("errorMessege", "Invalid Credential");
					dispatcher = request.getRequestDispatcher("Login.jsp");
				}
			}
		}
		catch(SQLException e) {
			request.setAttribute("errorMessege", e.toString());
			dispatcher = request.getRequestDispatcher("Login.jsp");
		}
		dispatcher.forward(request, response);
		
	}

}
