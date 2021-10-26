<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show details</title>
</head>
<body>
	<div class="form">
		<h1>Submitted Info</h1>
		<p>
			Name:
			<c:out value="${result.name}" />
		</p>
		<p>
			Dojo Location:
			<c:out value="${result.location}" />
		</p>
		<p>
			Favorite Languages:
			<c:out value="${result.favLang}" />
		</p>
		<p>
			Comment:
			<c:out value="${result.comment}" />
		</p>
		<a href="/">Go back</a>
	</div>
</body>
</html>