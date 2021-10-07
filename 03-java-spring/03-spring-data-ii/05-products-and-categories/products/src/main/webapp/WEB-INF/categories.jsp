<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<title>All categories</title>
</head>
<body>
<div class="container">
<h1>All categories</h1>
<a href="/" class="btn btn-primary">dashboard</a>
<a href="products">products</a>


        <c:forEach items="${categories}" var="category">
   
            <li>Category Name: <c:out value="${category.name}"/></li>
       
    
        </c:forEach>

</div>
</body>
</html>