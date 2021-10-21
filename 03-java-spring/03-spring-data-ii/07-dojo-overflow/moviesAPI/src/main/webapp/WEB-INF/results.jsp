<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>result page</title>
</head>
<body>
<h1>search result for ${search} </h1>
<p>total: ${total} </p>
<hr>
<c:forEach items="${results}" var="movie">
<p>
Name:${movie.getString("Title")}    ||
Year: ${movie.getString("Year") }
Poster:<img src="${movie.getString('Poster')}">
</p>
<hr>
</c:forEach>
</body>
</html>