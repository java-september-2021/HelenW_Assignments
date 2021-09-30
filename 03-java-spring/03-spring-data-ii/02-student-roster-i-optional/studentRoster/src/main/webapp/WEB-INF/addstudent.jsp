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
<h1>New student</h1>
<form:form action="/students/create" method="post" modelAttribute="student" class="form" >
    <div class="form-group">
        <form:label path="firstName"> First Name</form:label>
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
   
   <div class="form-group">
    <input type="submit" value="Create" class="btn btn-primary "/>
    </div>
</form:form> 
</body>
</html>