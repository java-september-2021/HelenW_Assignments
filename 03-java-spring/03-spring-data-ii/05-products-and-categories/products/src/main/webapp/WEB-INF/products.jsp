<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<title>All products</title>
</head>
<body>
<div class="container">
<h1>All products</h1>
<a href="/" class="btn btn-primary">dashboard</a>
<a href="/categories">categories</a>


        <c:forEach items="${allProducts}" var="product">
   
            <li>Product Name: <c:out value="${product.name}"/></li>
       
    
        </c:forEach>

</div>
</body>
</html>