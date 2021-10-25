<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Details</title>
</head>
<body>
<h1>Movie details for ${movie.getString("Title")} </h1>
<hr>
<p>
Title: ${movie.getString("Title") }
</p>
<p>
Director: ${movie.getString("Director") }
</p>
<p>
Year: ${movie.getString("Year") }
</p>
<p>
Rated: ${movie.getString("Rated")}
</p>
<p>
Plot:${movie.getString("Plot")}
</p>

<label>Ratings:</label>
<c:forEach items="${ratings}" var="rating">
	
	<p>${rating.getString("Source")}: ${rating.getString("Value")}</p>


</c:forEach>
</body>
</html>