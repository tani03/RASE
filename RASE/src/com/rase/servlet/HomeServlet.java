package com.rase.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 3791691390328383736L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(req.getSession(false));
		RequestDispatcher dispatcher;
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "0"); // Proxy.
		if(req.getSession().getAttribute("type") == null) {
		dispatcher = req.getRequestDispatcher("Home.jsp");
		}
		else {
			if(req.getSession().getAttribute("type") == "admin")
				dispatcher = req.getRequestDispatcher("AdminHome.jsp");
			else
				dispatcher = req.getRequestDispatcher("StudentHome.jsp");
		}
		dispatcher.forward(req,response);
	
	}
}
