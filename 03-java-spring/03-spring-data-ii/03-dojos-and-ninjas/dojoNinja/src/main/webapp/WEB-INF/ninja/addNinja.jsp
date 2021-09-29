<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<a href="/">dashboard</a>
<h1 class="title">New Ninja</h1>
<form:form action="/ninjas/newninja" method="post" modelAttribute="ninja" class="form"  >
	<form:label path="dojoNinja">Dojo</form:label>
	<form:select path="dojoNinja" class="form-control">
	
	<c:forEach items="${dojos}" var="dojo">
	<option value="${dojo.id}">${dojo.name} </option>
	</c:forEach>	
	</form:select>
    <div class="form-group">
        <form:label path="firstName">First Name</form:label>
        <form:errors class="error-txt" path="firstName"/>
        <form:input class="form-control" path="firstName"/>
    </div>
     <div class="form-group">
        <form:label path="lastName">Last Name</form:label>
        <form:errors class="error-txt" path="lastName"/>
        <form:input class="form-control" path="lastName"/>
    </div>
     <div class="form-group">
        <form:label path="age">Age</form:label>
        <form:errors class="error-txt" path="age"/>
        <form:input class="form-control" path="age"/>
    </div>
   
   
    <input type="submit" value="Create"/>
</form:form> 
</body>
</html>