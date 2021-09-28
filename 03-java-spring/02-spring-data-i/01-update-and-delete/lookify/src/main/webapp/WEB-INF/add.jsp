<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
   <link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Add a New Song</title>
</head>
<body>
<div class="container">
<a href="/dashboard">dashboard</a>
<form:form action="/songs/new" method="post" modelAttribute="song">
    <div class="form-group">
        <form:label path="title">Title</form:label>
        <form:errors class="error-txt" path="title"/>
        <form:input class="form-control" path="title"/>
    </div>
    <div class="form-group">
        <form:label path="artist">Artist</form:label>
        <form:errors class="error-txt" path="artist"/>
        <form:input class="form-control" path="artist"/>
    </div>
    <div class="form-group">
        <form:label path="rating">Rating(1-10)</form:label>
        <form:errors class="error-txt" path="rating"/>
        <form:input  class="form-control" type="number" path="rating" min="1" max="10"/>
    </div>
   
    <input type="submit" value="Add Song"/>
</form:form> 
</div>
</body>
</html>