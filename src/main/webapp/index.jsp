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

		<c:forEach items="${personServiceDAO.findAll()}" var="person">
			<c:out value="${person.surname}"/>
			<c:out value="${person.forenames}"/>
		</c:forEach>			
	</body>
</html>