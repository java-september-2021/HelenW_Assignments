<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<title>All Dojos</title>
</head>
<body>
<div class="container">
<h1>All dojos</h1>
<a href="/">home</a>
<table class="table table-striped table-dark">
    <thead>
        <tr>
    
            <th>Dojo Name</th>
      
    </thead>
    <tbody>
        <c:forEach items="${dojos}" var="dojo">
        <tr>
          
            <td><c:out value="${dojo.name}"/></td>
 
            
        </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>