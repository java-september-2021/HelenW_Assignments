<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
	    <link rel="stylesheet" href="/css/style.css">
    <title>Registration Page</title>
</head>
<body>
<div class="container">
    <h1>Register!</h1>
    

    
    <form:form method="POST" action="/registration" modelAttribute="user">
    <div class="form-group">
        <p>
            <form:label path="email">Email:</form:label>
            <form:errors class="error-txt" path="email" />
            <form:input  path="email" class="form-control"/>
        </p>
     </div>
     <div class="form-group">
        <p>
            <form:label path="password">Password:</form:label>
            <form:errors class="error-txt" path="password" />
            <form:password path="password" class="form-control" />
        </p>
      </div>
       <div class="form-group">
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:errors class="error-txt" path="passwordConfirmation" />
            <form:password path="passwordConfirmation" class="form-control"/>
        </p>
        </div>
        <input type="submit" value="Register!" class="btn btn-primary"/>
    </form:form>
    
    </div>
    
</body>
</html>