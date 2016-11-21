<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="stylesheet.css" type="text/css" media="all">
		<title>Source</title>
	</head>
	<body>
		<h1>Sources</h1>

		<table width='100%'>
			<thead>
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Author</th>
					<th>Publisher</th>
					<th>Url</th>
				</tr>
			</thead>
		<c:forEach items="${sourceService.getAll()}" var="source">
			<tr>
				<td><c:out value="${source.id}"/></td>
				<td><c:out value="${source.title}"/></td>
				<td><c:out value="${source.author}"/></td>
				<td><c:out value="${source.publisher}"/></td>
				<td><c:out value="${source.url}"/></td>
			</tr>
		</c:forEach>
		</table>
		
		<br />		

	</body>
</html>