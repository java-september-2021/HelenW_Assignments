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
<title>details</title>
</head>
<body>
<div class="container">


<h1>What is your question?</h1>

		<h1>${question.questionContent}</h1>
		<p>Tags:<c:forEach items="{question.tagsForQuestion}" var="tag" >
				<c:out value="${tag.subject}" />
				</c:forEach></p>
		<div class="row">
		<div class="col">
		
		
		</div>	
				
				
		<div class="col">
		<form:form action="/answers/create" method="post"
			modelAttribute="question">
			<div class="form-group">
				<form:label path="answerContent">Answer</form:label>
				<form:errors class="error-txt" path="answerContent" />
				<form:textarea class="form-control" path="answerContent" />
			</div>
<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th>Answers</th>
			
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${question.answersForQuestion}" var="answer">
					<tr>
						<td>${answer.answerContent}</td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
			
			<div class="form-group">
				<input type="submit" value="Answer it!!" class="btn btn-primary " />
			</div>
		</form:form>
		
		</div>
		</div>

</div>
</body>
</html>