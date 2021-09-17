<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/timealert.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Insert title here</title>
</head>
<body>
<h1 id="time">
<fmt:formatDate type="time" pattern="hh:mm a" value="${time}"/></h1>

</body>
</html>