<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="stylesheet.css" type="text/css" media="all">
		<title>Person</title>
	</head>
	<body>
		<%
			pageContext.setAttribute("id", request.getParameter("id"));
		%>
		
		<c:set var="person" value="${personServiceDAO.findById(id)}"/>
		<c:set var="father" value="${personServiceDAO.findById(personServiceDAO.findById(id).getFatherId())}"/>
		<c:set var="mother" value="${personServiceDAO.findById(personServiceDAO.findById(id).getMotherId())}"/>
		
		<h1>
			<c:out value="${person.getForenames()}"/>
			<c:out value="${person.getSurname()}"/>
		</h1> 
		<h2> 
			<c:out value="${father.getForenames()}"/>
			<c:out value="${father.getSurname()}"/>
		</h2>
		<h2> 
			<c:out value="${mother.getForenames()}"/>
			<c:out value="${mother.getSurname()}"/>
		</h2>
	</body>
</html>