<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container">
<p><label>Your Gold: </label> <c:out  value="${totalgold}" />   <a href="/reset">Reset</a></p>

<div class="room">
<form action="/findgold" method="POST">
<label>Farm</label>
<p>(Earns 10-20 gold)</p>
<input type="hidden" name="building" value="farm">
<input type="submit" value="Find Gold!">
</form>
</div>

<div class="room">
<form action="/findgold" method="POST">
<label>cave</label>
<p>(Earns 5-10 gold)</p>
<input type="hidden" name="building" value="cave">
<input type="submit" value="Find Gold!">
</form>
</div>

<div class="room">
<form action="/findgold" method="POST">
<label>house</label>
<p>(Earns 2-5 gold)</p>
<input type="hidden" name="building" value="house">
<input type="submit" value="Find Gold!">
</form>
</div>

<div class="room">
<form action="/findgold" method="POST">
<label>casino</label>
<p>(Earns 0-50 gold)</p>
<input type="hidden" name="building" value="casino">
<input type="submit" value="Find Gold!">
</form>
</div>

<p>Activities</p>
<div class="act">

<c:forEach items="${actsss}" var="act" >
<c:choose>
<c:when test="${act.contains('ouch')}" >
<p class="red"><c:out value="${act}" /></p>
</c:when>
<c:otherwise>
<p class="green"><c:out value="${act}" /></p>
</c:otherwise>
</c:choose>
</c:forEach>
</div>



</div>

</body>
</html>