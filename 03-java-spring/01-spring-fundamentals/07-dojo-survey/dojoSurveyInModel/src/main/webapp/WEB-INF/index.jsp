<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<!-- <div class="form">-->
	<div class="container">
		<form:form action="/result" method="post" modelAttribute="survey">
			<div class="form-group">
				<form:label path="name">Name</form:label>
				<form:errors class="error-txt" path="name" />
				<form:input class="form-control" path="name" />
			</div>
			<div class="form-group">
			<form:label path="location">Location</form:label>
					<form:select path="location" class="form-control">

				<c:forEach items="${locations}" var="location">
					<option value="${location}">${location}</option>
				</c:forEach>
				</form:select>
			</div>
				<div class="form-group">
				<form:label path="favLang">Favorite Language</form:label>
					<form:select path="favLang" class="form-control">

				<c:forEach items="${languages}" var="lang">
					<option value="${lang}">${lang}</option>
				</c:forEach>
				</form:select>
			</div>

		
	
	
	<div class="form-group">
		<form:label path="comment">Comment</form:label>
		<form:errors class="error-txt" path="comment" />
		<form:input type="textarea" class="form-control" path="comment" />
	</div>

	<input type="submit" value="create" class="btn btn-primary" />
	</form:form>
	</div>

</body>
</html>