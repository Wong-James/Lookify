<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Showing info</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<p>Title: <c:out value="${song.title}"></c:out> </p>
	<p>Artist: <c:out value="${song.artist}"></c:out> </p>
	<p>Rating (1-10): <c:out value="${song.rating}"></c:out> </p>
	<form action ="/songs/${id}" method="post">
		<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
    </form>
</body>
</html>