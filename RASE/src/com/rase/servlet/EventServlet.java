package com.rase.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rase.implementation.EventServicesImplementation;
import com.rase.model.Students;
import com.rase.services.EventServices;

@WebServlet("/events")
public class EventServlet extends HttpServlet  {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EventServices eventServices = new EventServicesImplementation();
		HttpSession session = req.getSession();

		if(req.getParameter("event_id") != null){
			String response = req.getParameter("event_id");
			String[] responseArray = response.split(",");
			System.out.println(responseArray[1]);
			switch(responseArray[1]) {
			case "Register":
				if(eventServices.setUserEvents(((Students)session.getAttribute("studentDetails")).getEmail(), responseArray[0])) {
					req.setAttribute("status", "Resgistered for Event");
					System.out.println("Registered");
				}
				else
					req.setAttribute("status", "Already Registered");
				System.out.println("Already Registered");
				req.getRequestDispatcher("index").forward(req, resp);
				break;
			case "modify":
				req.setAttribute("requiredAction", "modify");
				req.setAttribute("action", "Modify");
				req.setAttribute("event", eventServices.getEvent(responseArray[0]));
				req.getRequestDispatcher("modifyEvents").forward(req, resp);
				break;
			case "delete":
				if(eventServices.removeEvent(responseArray[0])){
					req.setAttribute("status", "Event Deleted");
				}
				else
					req.setAttribute("status", "Unknown Error Occured");
					resp.sendRedirect("events?getTables=admin");
				break;
			case "Remove":
				if(eventServices.removeUserEvent(((Students)session.getAttribute("studentDetails")).getEmail(), responseArray[0])){
					req.setAttribute("status", "Event Deleted");
				}
				else
					req.setAttribute("status", "Unknown Error Occured");
					resp.sendRedirect("events?getTables=user");
				break;
			default:
				break;
			}
		}
		else {
			if(session.getAttribute("type") == "student") {
				if(req.getParameter("getTables") != null)
					if(req.getParameter("getTables").equals("all")) {
						req.setAttribute("result", eventServices.getAllEvents());
						req.setAttribute("buttonName", "Register");
					}
					else {
						req.setAttribute("result", eventServices.getUserEvents(((Students)session.getAttribute("studentDetails")).getEmail()));	
						req.setAttribute("buttonName", "Remove");
					}
			}
			else if(session.getAttribute("type") == "admin") {
				req.setAttribute("result", eventServices.getAllEvents());
			}
			req.getRequestDispatcher("Events.jsp").forward(req, resp);
		}
		
	}
}
