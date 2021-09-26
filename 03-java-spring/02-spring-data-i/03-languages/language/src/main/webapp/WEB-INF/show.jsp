<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Details</title>
</head>
<body>
<div class="container" >
<h1>Details of <c:out value="${lang.name}"  /></h1>
<p>Name: <c:out value="${lang.name}"/></p>
<p>Creator: <c:out value="${lang.creator}"/></p>
<p>current version: <c:out value="${lang.currentVersion}"/></p>
<a  class="btn btn-primary" href="/languages/${lang.id}/edit">Edit</a>
<a class="btn btn-primary" href="/languages/${lang.id}/delete">Delete</a>
<a href="/languages">Dashboard</a>
</div>
</body>
</html>