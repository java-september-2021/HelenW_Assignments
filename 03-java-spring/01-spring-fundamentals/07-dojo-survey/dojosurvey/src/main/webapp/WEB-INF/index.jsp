<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="form">
<form method="POST" action="/submit">
    <label>Your Name: <input type="text" name="name"></label>
    <br>
    <label for="dojos">Dojo Location: </label>
 
	<select name="location" id="dojos">
	  <option value="sanjose">San Jose</option>
	  <option value="los">Los Angelas</option>
	  <option value="seattle">Seattle</option>
	  <option value="chicago">Chicago</option>
	</select>
<br>
<label for="fav">Favorite Languages:  </label>

<select name="fav" id="langs">
  <option value="python">Python</option>
  <option value="java">Java</option>
  <option value="javascript">Javascript</option>
  
</select>
<br>
<label for="comment">Comment(Optional)</label>
<br>
<textarea id="comment" name="comment" rows="4" cols="50">
  </textarea>
  <br><br>
    <button>Submit</button>
</form>
</div>
</body>
</html>