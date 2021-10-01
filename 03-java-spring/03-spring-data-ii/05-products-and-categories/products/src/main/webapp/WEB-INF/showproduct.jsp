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
<div>
<a href="/" class="btn btn-primary">Home</a>
<a href="/products/create" class="btn btn-primary">create another product</a> 

<h1><c:out value="${oneproduct.name}" /> </h1>
<p><c:out value="${oneproduct.description}" /> </p>
<p><c:out value="${oneproduct.price}" /> </p>
<div>

 <h3>Categories</h3>
 <ul>
        <c:forEach items="${categoriesWithProduct}" var="category">
   
            <li><c:out value="${category.name}"/></li>
       
    
        </c:forEach>
  </ul>
  </div>
  <div>
  
  </div>


 </div>
 <div>

<form action="/productBelongCate/${oneproduct.id}" method="post"  class="form"  >
	<label >add category </label>
	<select name="cateId" class="form-control">
	
	<c:forEach items="${categoriesWithoutProduct}" var="category">
	<option value="${category.id}">${category.name} </option>
	</c:forEach>	
	</select>
 
   
   
    <input type="submit" value="add" class="btn btn-primary"/>
</form> 
 </div> 
 
</div>
</body>
</html>