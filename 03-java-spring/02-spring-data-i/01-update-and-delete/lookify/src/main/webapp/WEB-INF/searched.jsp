<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Search </title>
</head>
<body>
<div class="container">
<h1>search result for <c:out value="${artist}"/> </h1>
<p>songs by  <c:out value="${artist}"/></p>
<!-- search part -->
<div class="form">
<form action="/songs/search" method="POST">
<input type="text" name="artist" placeholder="<c:out value='${artist}' />">
<input type="submit" value="New Search">
</form>
<a href="/dashboard">dashboard</a>
</div>
<table class="table table-striped table-dark">
    <thead>
        <tr>
           
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
           
            <td><a href="/songs/${song.id}/delete">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>