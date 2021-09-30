<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add new license</title>
</head>
<body>
<h1>New Person</h1>
<form:form action="/licenses/create" method="post" modelAttribute="license" >
    <div class="form-group">
        <form:label path="state">State</form:label>
        <form:errors class="error-txt" path="state"/>
        <form:input class="form-control" path="state"/>
    </div>
    <div class="form-group">
       <form:label path="person">Person:</form:label>
	<form:select path="person" class="form-control">
	
	<c:forEach items="${persons}" var="person">
	<option value="${person.id}">${person.firstName} ${person.lastName}</option>
	</c:forEach>	
	</form:select>
    </div>
    
   
    <input type="submit" value="create"/>
</form:form> 
</body>
</html>