<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
<title>Insert title here</title>
</head>
<body>
<a href="/">Home</a>
<h1 class="title">New Dojo</h1>
<p class="txt-error"><c:out value="${errors}" /><p>
<form:form action="/dojos/create" method="post" modelAttribute="dojo" class="form" >
    <div class="form-group">
        <form:label path="name">Name</form:label>
        <form:errors class="txt-error" path="name"/>
        <form:input class="form-control" path="name"/>
    </div>
   
   <div class="form-group">
    <input type="submit" value="Create" class="btn btn-primary "/>
    </div>
</form:form> 
</body>
</html>