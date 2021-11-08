<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<title>Ninjas at <c:out value="${ninja.dojoNinja.name}"/></title>
</head>
<body>
<h1><c:out value="${ninja.dojoNinja.name}"/> Location Ninjas</h1>
<a href="/">Home</a> <a href="/dojos">All dojos</a>


<table class="table table-striped table-dark">
    <thead>
        <tr>
    
            <th>First Name</th>
            <th>Last Name</th>
            <th>Ages</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ninja.dojoNinja.ninjas}" var="ninja">
        <tr>
          
            <td><c:out value="${ninja.firstName}"/></td>
            <td><c:out value="${ninja.lastName}"/></td>
             <td><c:out value="${ninja.age}"/></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table>
 
</body>
</html>