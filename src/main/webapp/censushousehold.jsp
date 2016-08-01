<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="stylesheet.css" type="text/css" media="all">
		<title>Census Household</title>
	</head>
	<body>
		<%
			pageContext.setAttribute("id", request.getParameter("id"));
		%>

		<c:set var="censusHousehold" value="${censusService.getCensusHouseholdById(id)}"/>
		<c:set var="census" value="${censusService.getCensusById(censusHousehold.getCensusId())}"/>
	
		<h1>Census Household</h1>
		
		<table width='70%'>
			<tr>
				<td class='header' width='2	0%'>Census</td>
				<td><c:out value="${census.getTitle()}"/></td>
			</tr>
			<tr>
				<td class='header'>Address</td>
				<td><c:out value="${censusHousehold.getAddress()}"/></td>
			</tr>
			<tr>
				<td class='header'>Reference</td>
				<td><c:out value="${censusHousehold.getPiece()}/${censusHousehold.getFolio()}/${censusHousehold.getPage()}"/></td>
			</tr>
			<tr>
				<td class='header'>Notes</td>
				<td><c:out value="${censusHousehold.getNotes()}"/></td>
			</tr>
		</table>
		
		<br />

		<table width='100%'>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Rel</th>
					<th>Age</th>
					<th>Status</th>
					<th>Occupation</th>
					<th>Birthplace</th>
				</tr>
			</thead>
		<c:forEach items="${censusService.getAllCensusHouseholdPersonByCensusHouseholdId(id)}" var="censusPerson">
			<tr>
				<td><a href="censushouseholdentry.jsp?id=<c:out value="${censusPerson.id}"/>"><c:out value="${censusPerson.id}"/></a></td>
				
				<c:if test="${null == censusPerson.personId or 0 == censusPerson.personId}">
					<td><c:out value="${censusPerson.name}"/></td>
				</c:if>
				<c:if test="${0 < censusPerson.personId}">
					<td><a href="person.jsp?id=<c:out value="${censusPerson.personId}"/>"><c:out value="${censusPerson.name}"/></a></td>
				</c:if>
				
				<td><c:out value="${censusPerson.relationshipToHead}"/></td>
				<td><c:out value="${censusPerson.age}"/></td>
				<td><c:out value="${censusPerson.status}"/></td>
				<td><c:out value="${censusPerson.occupation}"/></td>
				<td><c:out value="${censusPerson.birthplace}"/></td>
			</tr>
		</c:forEach>
		</table>
		
		<br />		
	</body>
</html>