package com.rase.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rase.implementation.EventServicesImplementation;
import com.rase.model.Events;

@WebServlet("/modifyEvents")
public class ModifyEventServlet extends HttpServlet {

	private static final long serialVersionUID = 6212474060598147579L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("action") != null)
			req.setAttribute("action", req.getParameter("action"));
		req.getRequestDispatcher("AddEvents.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EventServicesImplementation eventServices = new EventServicesImplementation();
		Events event = new Events();
		event.setEventId(req.getParameter("event_id"));
		event.setEventName(req.getParameter("event_name"));
		event.setCreatedOn(new java.sql.Date(new Date().getTime()));
		event.setEventDate(java.sql.Date.valueOf(req.getParameter("event_date")));
		event.setLocation(req.getParameter("location"));
		if(eventServices.addEvent(event)) {
			req.setAttribute("status", "Event Created");
			req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("status", "Event Already Exists");
			req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
		}
	}
}
