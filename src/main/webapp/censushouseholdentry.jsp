<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="stylesheet.css" type="text/css" media="all">
		<title>Census Household Entry</title>
	</head>
	<body>
		<%
			pageContext.setAttribute("id", request.getParameter("id"));
		%>
		<c:set var="entry" value="${censusService.getCensusHouseholdPersonById(id)}"/>
	
		<h1>Census Household Entry</h1>

		<table width='50%'>
			<tr>
				<td class='header' width='20%'>Name</td>
				<td><c:out value="${entry.getName()}"/></td>
			</tr>
			<tr>
				<td class='header' width='20%'>Rel</td>
				<td><c:out value="${entry.getRelationshipToHead()}"/></td>
			</tr>
			<tr>
				<td class='header' width='20%'>Age</td>
				<td><c:out value="${entry.getAge()}"/></td>
			</tr>
			<tr>
				<td class='header' width='20%'>Status</td>
				<td><c:out value="${entry.getStatus()}"/></td>
			</tr>
			<tr>
				<td class='header' width='20%'>Occupation</td>
				<td><c:out value="${entry.getOccupation()}"/></td>
			</tr>
			<tr>
				<td class='header' width='20%'>Birthplace</td>
				<td><c:out value="${entry.getBirthplace()}"/></td>
			</tr>
		</table>

		<br />
		
		<!-- 	
		<a href="/fh/censushouseholdentryedit.jsp?id=<c:out value="${id}"/>"><button type="button">Edit</button></a>
		<a href="/fh/censushouseholdentrydelete.jsp?id=<c:out value="${id}"/>"><button type="button">Delete</button></a>
		 -->
		
	</body>
</html>