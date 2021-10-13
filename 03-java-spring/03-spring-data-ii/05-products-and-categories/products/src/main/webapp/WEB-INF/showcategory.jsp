<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<title>Details of Product</title>
</head>
<body>
<div class="container">
<a href="/categories/create" class="btn btn-primary">create another category</a>
<a href="/" class="btn btn-primary">Home</a>
<div>

<h1><c:out value="${onecategory.name}" /> </h1> 

 <h3></h3>
 
 <ul>
        <c:forEach items="${productsInCate}" var="product">
   
            <li><c:out value="${product.name}"/></li>
       
    
        </c:forEach>
  </ul>
  </div>

  
 <div>
 




<form action="/categoryHasProduct/${onecategory.id}" method="post"  class="form"  >
	<label >add products </label>
	<select name="productId" class="form-control">
	
	<c:forEach items="${productsOutCate}" var="product">
	<option value="${product.id}">${product.name} </option>
	</c:forEach>	
	</select>
 
   
   
    <input type="submit" value="add" class="btn btn-primary"/>
</form> 
 </div> 
</div>
</body>
</html>