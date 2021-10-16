<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
<title>New Question</title>
</head>
<body>
<div class="container">
<a href="/questions">dashboard</a>

<h1>What is your question?</h1>
		<form:form action="/questions/create" method="post"
			modelAttribute="question">
			<div class="form-group">
				<form:label path="questionContent">Question</form:label>
				<form:errors class="error-txt" path="questionContent" />
				<form:textarea class="form-control" path="questionContent" />
			</div>
				<div class="form-group">
				<form:label path="tempTags">tags</form:label>
				<form:errors class="error-txt" path="tempTags" />
				<form:input type="text" class="form-control" path="tempTags" />
			</div>
			
			
			<div class="form-group">
				<input type="submit" value="create" class="btn btn-primary " />
			</div>
		</form:form>

</div>
</body>
</html>