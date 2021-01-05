<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Manage Events</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="css/util1.css">
	<link rel="stylesheet" type="text/css" href="css/main1.css">
</head>
<body>
<c:if test="${not empty requestScope.status}">
<script> alert("${requestScope.status}"); </script>
</c:if>
	<div class="container-contact100">
		<div class="wrap-contact100">
		<c:set value="${requestScope.event}" var = "eve" />
			<form class="contact100-form validate-form" method="post">
				<span class="contact100-form-title">
					${requestScope.action} Events
				</span>

				<div class="wrap-input100 validate-input" data-validate="Event_Id is required">
					<span class="label-input100">Event Id</span>
					<input class="input100" type="text" name="event_id" value="${eve.eventId}" placeholder="Enter Event Id" required>
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Valid event name is required">
					<span class="label-input100">Event Name</span>
					<input class="input100" type="text" name="event_name" value="${eve.eventName}" placeholder="Enter name of event">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Date is required">
					<span class="label-input100">Event Date</span>
					<input class="input100" type="date" name="event_date" value="${eve.eventDate}" placeholder="Select event date">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">Event Name</span>
					<input class="input100" type="text" name="location" value="${eve.location}" placeholder="Enter event location">
					<span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn">
							<span>
								${requestScope.action}
								<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
							</span>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
    