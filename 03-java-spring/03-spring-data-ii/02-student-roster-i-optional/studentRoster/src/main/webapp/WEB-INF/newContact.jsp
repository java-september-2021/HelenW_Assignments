<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<title>add new student</title>
</head>
<body>
<h1>New contact</h1>
<form:form action="/contact/create" method="post" modelAttribute="contact" class="form" >
    <form:label path="student">student</form:label>
	<form:select path="student" class="form-control">
	
	<c:forEach items="${students}" var="student">
	<option value="${student.id}">${student.firstName} ${student.lastName}</option>
	</c:forEach>	
	</form:select>
    
    <div class="form-group">
        <form:label path="address"> address</form:label>
        <form:errors class="error-txt" path="address"/>
        <form:input class="form-control" path="address"/>
    </div>
      <div class="form-group">
        <form:label path="city">city</form:label>
        <form:errors class="error-txt" path="city"/>
        <form:input class="form-control" path="city"/>
    </div>
      <div class="form-group">
        <form:label path="state">State</form:label>
        <form:errors class="error-txt" path="state"/>
        <form:input class="form-control" path="state"/>
    </div>
   
   <div class="form-group">
    <input type="submit" value="Create" class="btn btn-primary "/>
    </div>
</form:form> 
</body>
</html>