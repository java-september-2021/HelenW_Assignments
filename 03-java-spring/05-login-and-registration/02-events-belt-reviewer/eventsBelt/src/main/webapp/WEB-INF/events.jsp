<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css">
<title>Events</title>
</head>
<body>
	<div class="container">
	
		<h1>
			Welcome
			<c:out value="${user.firstName}" />
		</h1>
		<a href="/logout">logout</a>


	</div>
	<p>Here are some of the events in your state</p>
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th>Event ID</th>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${eventsInState}" var="event">
				<tr>
					<td>${event.id }</td>
					<td><a href="/events/${event.id}"><c:out value="${event.eventName}" /></a></td>
					<td><c:out value="${event.eventDate}" /></td>
					<td><c:out value="${event.location}" /></td>
					<td><c:out value="${event.eventCreator.firstName}" /></td>
					<td><c:if test="${event.eventCreator.id == user.id}">
							<a href="/events/${event.id}/edit">Edit</a>
							<a href="/events/${event.id}/delete">Delete</a>
						</c:if> <c:choose>
							<c:when test="${event.usersJoined.contains(user)}">
								<a href="/events/${event.id}/cancel">Cancel</a>
							</c:when>

							<c:otherwise>

								<a href="/events/${event.id}/join">Join</a>

							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Here are some of the events in other states</p>
	<div>
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th> Event ID </th>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>State
					<th>Host</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${eventsOutState}" var="event">
					<tr>
						<td> ${event.id} </td>
						<td><a href="/events/${event.id}"><c:out value="${event.eventName}" /></a></td>
						<td><c:out value="${event.eventDate}" /></td>
						<td><c:out value="${event.location}" /></td>
						<td><c:out value="${event.state}" /></td>
						<td><c:out value="${event.eventCreator.firstName}" /></td>
						<td><c:choose>
								<c:when test="${event.usersJoined.contains(user)}">
									<a href="#">Cancel</a>
								</c:when>

								<c:otherwise>

									<a href="#">Join</a>

								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>



	<div class="event-form">
		<h1>Create new event</h1>
		<form:form action="/events/create" method="post"
			modelAttribute="newEvent">
			<div class="form-group">
				<form:label path="eventName">Name</form:label>
				<form:errors class="error-txt" path="eventName" />
				<form:input class="form-control" path="eventName" />
			</div>
			<div class="form-group">
				<form:label path="eventDate">Date</form:label>
				<form:errors class="error-txt" path="eventDate" />
				<form:input type="date" class="form-control" path="eventDate" />
			</div>
			<div class="form-group">
				<form:label path="location">Location</form:label>
				<form:errors class="error-txt" path="location" />
				<form:input class="form-control" path="location" />
			</div>
			<div class="form-group">
				<form:label path="state">State</form:label>
				<select name="state">
					<c:forEach items="${states}" var="state">
						<option value="${state}">${state}</option>
					</c:forEach>
				</select>
			</div>
			<!-- hidden input for userId , event can not live without user, so a useId is transferred-->
			<form:input type="hidden" value="${userId}" path="eventCreator" />

			<div class="form-group">
				<input type="submit" value="create" class="btn btn-primary " />
			</div>
		</form:form>
	</div>
</body>
</html>