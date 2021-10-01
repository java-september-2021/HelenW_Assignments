<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<title>New Product</title>
</head>
<body>
<div class="container">
<a href="/" class="btn btn-primary">Home</a>
<h1>New category</h1>
<form:form action="/categories/create" method="post" modelAttribute="category" class="form" >
    <div class="form-group">
        <form:label path="name">Name</form:label>
        <form:errors class="error-txt" path="name"/>
        <form:input class="form-control" path="name"/>
    </div>
     
   
   <div class="form-group">
    <input type="submit" value="Create" class="btn btn-primary "/>
    </div>
</form:form> 

</div>
</body>
</html>