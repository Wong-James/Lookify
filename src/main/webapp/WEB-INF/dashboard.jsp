<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Songs</title>
</head>
<body>
	<div>
		<a href="/songs/new">Add New</a>
		<a href="/topten">Top Songs</a>
		<form action="/search" method="post" >
        		<input name="searchArtist"/>
			<input type="submit" value="Submit"/>
		</form> 
		
	</div>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs}" var="song">
			<tr>
				<td><a href ="/song/${song.id}"><c:out value="${song.title}"/></a></td>
            	<td><c:out value="${song.rating}"/></td>
            	<td><form action="/songs/${song.id}" method="post">
            		<input type="hidden" name="_method" value="delete">
            		<input type="submit" value="Delete">
            		
            		</form> 
            		</td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
	

</body>
</html>