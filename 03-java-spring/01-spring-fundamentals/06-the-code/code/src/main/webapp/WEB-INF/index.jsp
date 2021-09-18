<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Try code</title>
</head>
<body>
<div class="form">
<p id=errors><c:out value="${errors}" /><p>
<form method="POST" action="/trycode">
    <label>What is the code ?</label>
    <br>
     <input type="text" name="code">
    <br>
    <button>Try Code</button>
</form>
</div>
</body>
</html>