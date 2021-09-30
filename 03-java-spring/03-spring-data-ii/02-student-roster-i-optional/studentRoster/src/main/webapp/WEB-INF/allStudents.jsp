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
<div class="container">
<h1>All students</h1>
<table class="table table-striped table-dark">
    <thead>
        <tr>
    
            <th>Name</th>
            <th>Age</th>
            <th>address</th>
            <th>City</th>
             <th>state</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${students}" var="student">
        <tr>
          
            <td><c:out value="${student.firstName}"/><c:out value="${student.lastName}"/></td>
            <td><c:out value="${student.age}"/></td>
             <td><c:out value="${student.contact.address}"/></td>
             <td><c:out value="${student.contact.city}"/></td>
             <td><c:out value="${student.contact.state}"/></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table>
 </div>
</body>
</html>