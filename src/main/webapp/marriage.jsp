<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="stylesheet.css" type="text/css" media="all">
		<title>Marriage</title>
	</head>
	<body>
		<%
			pageContext.setAttribute("id", request.getParameter("id"));
		%>

		<c:set var="marriage" value="${marriageService.getById(id)}"/>
		<c:set var="husband" value="${personService.getById(marriage.getHusbandId())}"/>
		<c:set var="wife" value="${personService.getById(marriage.getWifeId())}"/>
		<c:set var="sourceCitation" value="${sourceCitationService.getByCitationId(marriage.getCitationId())}"/>
	
		<h1>Marriage</h1>
		
		<table width='50%'>
			<tr>
				<td class='header' width='20%'>Husband</td>
				<td><c:out value="${husband.getFullName()}"/></td>
			</tr>
			<tr>
				<td class='header' width='20%'>Wife</td>
				<td><c:out value="${wife.getFullName()}"/></td>
			</tr>
			<tr>
				<td class='header' width='20%'>Date</td>
				<td><c:out value="${marriage.getDate()}"/></td>
			</tr>
			<tr>
				<td class='header' width='20%'>Location</td>
				<td><c:out value="${marriage.getLocation()}"/></td>
			</tr>
			<tr>
				<td class='header' width='20%'>Notes</td>
				<td><c:out value="${marriage.getNotes()}"/></td>
			</tr>
			<tr>
				<td class='header' width='20%'>Citation</td>
				<c:if test="${null eq sourceCitation}">
					<td>&nbsp;</td>
				</c:if>
				<c:if test="${null ne sourceCitation}">
					<td><c:out value="${sourceCitation.getSource().getTitle()}:  ${sourceCitation.getCitation().getDetails()}"/></td>
				</c:if>
				
			</tr>
		</table>
	
	</body>
</html>