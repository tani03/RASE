<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="StudentHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>All events</title>
</head>
<body>
<jsp:useBean id="event" class="com.rase.model.Events" scope="session"/>
<c:set value="${requestScope.result}" var = "events" />
<c:set value="${sessionScope.type}"  var="type"></c:set>
<div class="limiter" >
		<div class="container-table100">
			<div class="event-heading"> <p>Upcoming Events</p> </div>
			<div class="wrap-table100">
				<div class="table100">
					<form>
						<table>
						<thead>
							<tr class="table100-head">
								<th class="column1"><b>Event ID</b></th>
								<th class="column2"><b>Event Name</b></th>
								<th class="column3"><b>Created On</b></th>
								<th class="column4"><b>Event Date</b></th>
								<th class="column5"><b>Event Location</b></th>
								<th class="column6"><b></b></th>
							</tr>
							</thead>
							<c:forEach items="${events}" var="event">	
							<tr>
								<td class="column1">${event.eventId}</td>
								<td class="column2">${event.eventName}</td>
								<td class="column3">${event.createdOn}</td>
								<td class="column4">${event.eventDate}</td>
								<td class="column5">${event.location}</td>
								<c:if test="${type == 'student'}">
								<td class="column6"> <a href="/events"><button name="event_id" value="${event.eventId},${requestScope.buttonName}">${requestScope.buttonName}</button></a> </td>
								</c:if>
								<c:if test="${type == 'admin'}">
								<td class="column6"><a href="/events"><button name="event_id" value="${event.eventId},view">View</button></a>
													<a href="/events"><button name="event_id" value="${event.eventId},delete">Delete</button></a> </td>
								</c:if>
							</tr>
							</c:forEach>
						</table>
					</form>
				</div>
			</div>
		</div>
</div>
</body>
</html>