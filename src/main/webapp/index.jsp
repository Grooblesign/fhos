<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="uk.me.paulgarner.fh.service.PersonServiceUtil" %>
<%@ page import="uk.me.paulgarner.fh.domain.Person" %>
<%@ page import="uk.me.paulgarner.fh.service.PersonService" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Family History</title>
	</head>
	<body>
		<%
			String dbHost = System.getenv().get("OPENSHIFT_POSTGRESQL_DB_HOST");
			String dbPort = System.getenv().get("OPENSHIFT_POSTGRESQL_DB_PORT");
		%>
		
		<h1><%=dbHost%></h1>
		<h1><%=dbPort%></h1>
		<h1><c:out value="${personServiceUtil.find(55287}"/></h1>
		
	</body>
</html>