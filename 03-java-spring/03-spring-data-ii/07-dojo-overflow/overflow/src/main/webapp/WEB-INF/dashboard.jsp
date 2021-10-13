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
<title>dashboard page</title>
</head>
<body>
<div class="container">
<h1>Questions Dashboard</h1>

<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th>ID</th>
				<th>Questoin</th>
				<th>tags</th>
		
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questions}" var="question">
				<tr>
					<td>${quesion.id }</td>
			
					<td><c:out value="${question.question}" /></td>
					<td>
						<c:forEach items ="${question.tagsForQuestion}"  var="tag">
						<span><c:out value="${tag.subject}" /></span>
						</c:forEach>
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/questions/new">new question</a>
</div>
</body>
</html>