<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Dojo</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="form">
<h1>Submitted Info</h1>
<p> Name:  <c:out value="${name}" /> </p>
<p> Dojo Location:  <c:out value="${location}" /> </p>
<p> Favorite Languages:  <c:out value="${fav}" /> </p>
<p> Comment:  <c:out value="${comment}" /> </p>
<a href="/">Go back</a>
</div>
</body>
</html>