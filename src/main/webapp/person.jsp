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
		
		<c:set var="person" value="${personService.getById(id)}"/>
		<c:set var="father" value="${personService.getById(personService.getById(id).getFatherId())}"/>
		<c:set var="mother" value="${personService.getById(personService.getById(id).getMotherId())}"/>
		
		<h1>
			<c:out value="${person.getFullName()}"/>
		</h1>

		<h2>Parents</h2>
		
		<table width='75%'>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Birth</th>
					<th>Death</th>
				</tr>
			</thead>
			<tr>
				<c:if test="${null != father}">
					<td width="10%"><c:out value="${father.getId()}"/></td>
					<td><c:out value="${father.getFullName()}"/></td>
					<c:if test="${null == father.getBirthEvent()}">
						<td>&nbsp;</td>
						<td width="30%"></td>
					</c:if>
					<c:if test="${null != father.getBirthEvent()}">
						<td><c:out value="${father.getBirthEvent().getDate()}"/></td>
						<td width="30%"><c:out value="${father.getBirthEvent().getLocation()}"/></td>
					</c:if>
				</c:if>
				<c:if test="${null == father}">
					<td width="10%">&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td width="30%"></td>
				</c:if>
			</tr>
			<tr>
				<c:if test="${null != mother}">
					<td width="10%"><c:out value="${mother.getId()}"/></td>
					<td><c:out value="${mother.getFullName()}"/></td>
					<c:if test="${null == mother.getBirthEvent()}">
						<td>&nbsp;</td>
						<td width="30%"></td>
					</c:if>
					<c:if test="${null != mother.getBirthEvent()}">
						<td><c:out value="${mother.getBirthEvent().getDate()}"/></td>
						<td width="30%"><c:out value="${mother.getBirthEvent().getLocation()}"/></td>
					</c:if>
				</c:if>
				<c:if test="${null == mother}">
					<td width="10%">&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td width="30%"></td>
				</c:if>
			</tr>
		</table>
		
		<h2>Timeline</h2>
		
		<table width='100%'>
			<thead>
				<tr>
					<th width='7%'>Id</th>
					<th width='10%'>Event</th>
					<th width='13%'>Date</th>
					<th width='40%'>Location</th>
					<th width='30%'>Details</th>
				</tr>
			</thead>
		<c:forEach items="${eventDAO.findAllByPersonId(id)}" var="event">
			<tr>
				<td><a href="event.jsp?id=<c:out value="${event.id}"/>"><c:out value="${person.id}"/></a></td>
				<td><c:out value="${event.eventType}"/></td>
				<td><c:out value="${event.date}"/></td>
				<td><c:out value="${event.location}"/></td>
				<td><c:out value="${event.details}"/></td>
			</tr>
		</c:forEach>
		</table>		
		
	</body>
</html>