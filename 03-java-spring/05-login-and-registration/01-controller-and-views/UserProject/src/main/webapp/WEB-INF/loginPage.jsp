<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Login Page</title>
</head>
<body>
    <h1>Login</h1>
    <!-- to display error from flash data set in controller -->
    <p class="error-txt"><c:out value="${error}" /></p>
    <form method="post" action="/login">
    <div class="form-group">
        <p>
            <label  for="email">Email</label>
            <input type="text" id="email" name="email" class="form-control"/>
        </p>
        </div>
        <div class="form-group" >
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control"/>
        </p>
        </div>
        <input type="submit" value="Login!"/>
    </form>    
</body>
</html>