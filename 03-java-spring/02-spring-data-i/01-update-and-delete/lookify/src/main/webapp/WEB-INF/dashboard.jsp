<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<div class="container">
<a href="/songs/new" class="btn btn-primary">Add New</a>
<a href="/songs/topten" class="btn btn-primary">Top Songs</a>
<!-- search part -->
<div class="form">
<form action="/songs/search" method="POST">
<input type="text" name="artist" placeholder="search artist">
<input type="submit" value="Search Artist">
</form>
</div>

<h1>All Songs</h1>
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