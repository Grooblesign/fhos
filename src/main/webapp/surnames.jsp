<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="stylesheet.css" type="text/css" media="all">
		<title>Surnames</title>
	</head>
	<body>
		<%
			pageContext.setAttribute("letter", request.getParameter("letter"));
		%>
		<h1>Surnames starting with <c:out value="${letter}" /></h1>
		
		<table width='100%'>
			<thead>
				<tr>
					<th width='7%'>Id</th>
					<th width='15%'>Surname</th>
					<th width='25%'>Forenames</th>
					<th width='15%'>Birth Date</th>
					<th width='38%'>Birth Location</th>
				</tr>
			</thead>
		<c:forEach items="${personService.getAllBySurnameStartingWithLetter(letter)}" var="person">
			<tr>
				<td><a href="person.jsp?id=<c:out value="${person.id}"/>"><c:out value="${person.id}"/></a></td>
				<td><c:out value="${person.surname}"/></td>
				<td><c:out value="${person.forenames}"/></td>
				<td><c:out value="${person.birthEvent.date}"/></td>
				<td><c:out value="${person.birthEvent.location}"/></td>
			</tr>
		</c:forEach>
		</table>
	</body>
</html>