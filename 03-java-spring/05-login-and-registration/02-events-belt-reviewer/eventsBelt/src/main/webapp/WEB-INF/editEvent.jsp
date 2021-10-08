<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
<title>edit event</title>
</head>
<body>
	<div class="container">
			<a href="/events">dashboard</a>
		<h1>edit an event</h1>
		<form:form action="/events/${event.id}/edit" method="post"
			modelAttribute="event"><c:out value="${event.id }"/>
			<form:input type="hidden" value="${event.id}" path="id" />
			<div class="form-group">
				<form:label path="eventName">Name</form:label>
				<form:errors class="error-txt" path="eventName" />
				<form:input class="form-control" path="eventName"  />
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
			<!--<form:input type="hidden" value="${userId}" path="eventCreator" /> -->
			

			<div class="form-group">
				<input type="submit" value="edit" class="btn btn-primary " />
			</div>
		</form:form>
	</div>

</body>
</html>