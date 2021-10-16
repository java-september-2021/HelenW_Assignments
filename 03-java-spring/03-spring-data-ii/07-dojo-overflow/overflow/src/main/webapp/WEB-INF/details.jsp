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

<a href="/questions">dashboard</a>


		<h1>${question.questionContent}</h1>
		<h4>
			Tags:
			<c:forEach items="${question.tagsForQuestion}" var="tag">
			<span class="tag-type">	<c:out value="${tag.subject}" /></span>
			</c:forEach>
			
		</h4>
		
		<hr>
		<div class="row">

			<div class="col answer-wall">
				<table class="table table-striped table-primary">
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


			</div>


			<div class="col">
				<h3>Add Your Answer</h3>
				<form:form action="/questions/${question.id}/answers/create"
					method="post" modelAttribute="answer">
					<div class="form-group">
						<form:label path="answerContent">Answer</form:label>
						<form:errors class="error-txt" path="answerContent" />
						<form:textarea class="form-control" path="answerContent" />
					</div>


					<div class="form-group">
						<input type="submit" value="Answer it!!" class="btn btn-primary " />
					</div>
				</form:form>

			</div>
		</div>

	</div>
</body>
</html>