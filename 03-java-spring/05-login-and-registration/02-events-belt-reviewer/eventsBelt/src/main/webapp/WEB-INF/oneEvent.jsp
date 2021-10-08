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
<title>Details</title>
</head>
<body>
	<div class="container">
		<a href="/events">dashboard</a>
		<h1>
	
			<c:out value="${event.eventName}" />
		</h1>
		<div class="row">
			<div class="col">
				<p>
					Host:
					<c:out value="${event.eventCreator.firstName}" />
				</p>
				<p>
					Date:
					<c:out value="${event.eventDate}" />
				</p>
				<p>
					Location:
					<c:out value="${event.location}" />
				</p>
				<p>
					People who are attending this event:
					<c:out value="${event.usersJoined.size()}" />
				</p>

				<table class="table table-striped table-dark">
					<thead>
						<tr>

							<th>Name</th>
							<th>Location</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${event.usersJoined}" var="user">
							<tr>
								<td><c:out value="${user.firstName}" /></td>
								<td><c:out value="${user.location}" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col">
				<h4>Message Wall</h4>

				<div class="message-wall">
					<c:forEach items="${messages}" var="message">
						
							<p><c:out value="${message.messageOwner.firstName}"/> says: <c:out value="${message.content}"/></p>
							
					
					</c:forEach>


				</div >
				<div >
				<form:form action="/events/${event.id}/message" method="post"
					modelAttribute="message">
					<div class="form-group">
						<form:label path="content">Add Comment</form:label>
						<form:errors class="error-txt" path="content" />
						<form:input class="form-control" path="content" />
					</div>

				
					<!-- A message must be posted by some loggedIn user for a specific event -->
					<!-- if only sending eventId, message can display without message owner -->
					<!-- without sending event ID, the message just won't display even though userId exists -->
					<!--<form:input type="hidden" value="${userId}" path="messageOwner" />  -->
				<!--<form:input type="hidden" value="${event.id}" path="eventHasMessages" /> -->
					<input type="submit" value="submit" class="btn btn-primary" /> 
				</form:form>
				</div>
			</div>

		</div>
	</div>

</body>
</html>