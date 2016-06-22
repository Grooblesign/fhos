<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="uk.me.paulgarner.fh.domain.Person" %>
<%@ page import="uk.me.paulgarner.fh.service.PersonService" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="stylesheet.css" type="text/css" media="all">
		<title>Family History</title>
	</head>
	<body>
		<H1>Family History</H1>
		
		<table>
		<c:forEach items="${personServiceDAO.findAll()}" var="person">
			<tr>
				<td><a href="person.jsp?id=<c:out value="${person.id}"/>"><c:out value="${person.id}"/></a></td>
				<td><c:out value="${person.surname}"/></td>
				<td><c:out value="${person.forenames}"/></td>
				<td><c:out value="${person.fatherId}"/></td>
				<td><c:out value="${person.motherId}"/></td>
			</tr>
		</c:forEach>
		</table>			
	</body>
</html>