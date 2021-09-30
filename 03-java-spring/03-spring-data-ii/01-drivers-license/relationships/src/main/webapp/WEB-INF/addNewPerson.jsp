<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add new person</title>
</head>
<body>
<h1>New Person</h1>
<form:form action="/persons/create" method="post" modelAttribute="person" >
    <div class="form-group">
        <form:label path="firstName">First Name</form:label>
        <form:errors class="error-txt" path="firstName"/>
        <form:input class="form-control" path="firstName"/>
    </div>
    <div class="form-group">
        <form:label path="lastName">Last Name</form:label>
        <form:errors class="error-txt" path="lastName"/>
        <form:input class="form-control" path="lastName"/>
    </div>
    
   
    <input type="submit" value="create"/>
</form:form> 
</body>
</html>