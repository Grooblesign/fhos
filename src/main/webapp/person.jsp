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

		<c:if test="${null ne person.getFatherId() and 0 ne person.getFatherId()}">
			<c:set var="father" value="${personService.getById(personService.getById(id).getFatherId())}"/>
		</c:if>			
		<c:if test="${null eq person.getFatherId() or 0 eq person.getFatherId()}">
			<c:set var="father" value="${null}"/>
		</c:if>			
		
		<c:if test="${null ne person.getMotherId() and 0 ne person.getMotherId()}">
			<c:set var="mother" value="${personService.getById(personService.getById(id).getMotherId())}"/>
		</c:if>			
		<c:if test="${null eq person.getMotherId() or 0 eq person.getMotherId()}">
			<c:set var="mother" value="${null}"/>
		</c:if>			

		<c:if test="${null != person.getImage()}">
			<img width="15%" class="portraitImage" src="images/<c:out value="${person.getImage()}"/>" />
		</c:if>
		
		<h1>
			<c:out value="${person.getFullName()}"/>
		</h1>

		<h2>Parents</h2>
		
		<table width='80%'>
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
					<td width="10%"><a href="person.jsp?id=<c:out value="${father.getId()}"/>"><c:out value="${father.getId()}"/></a></td>
					<td><c:out value="${father.getFullName()}"/></td>
					<c:if test="${null == father.getBirthEvent()}">
						<td width="30%">&nbsp;</td>
					</c:if>
					<c:if test="${null != father.getBirthEvent()}">
						<td width="30%"><c:out value="${father.getBirthEvent().getDate()}" />&nbsp;<c:out value="${father.getBirthEvent().getLocation()}"/></td>
					</c:if>
					
					<c:if test="${null == father.getDeathEvent()}">
						<td width="30%">&nbsp;</td>
					</c:if>
					<c:if test="${null != father.getDeathEvent()}">
						<td width="30%"><c:out value="${father.getDeathEvent().getDate()}" />&nbsp;<c:out value="${father.getDeathEvent().getLocation()}"/></td>
					</c:if>
					
				</c:if>
				<c:if test="${null == father}">
					<td width="10%">&nbsp;</td>
					<td>&nbsp;</td>
					<td width="30%">&nbsp;</td>
					<td width="30%">&nbsp;</td>
				</c:if>
			</tr>
			<tr>
				<c:if test="${null != mother}">
					<td width="10%"><a href="person.jsp?id=<c:out value="${mother.getId()}"/>"><c:out value="${mother.getId()}"/></a></td>
					<td><c:out value="${mother.getFullName()}"/></td>
					<c:if test="${null == mother.getBirthEvent()}">
						<td width="30%">&nbsp;</td>
					</c:if>
					<c:if test="${null != mother.getBirthEvent()}">
						<td width="30%"><c:out value="${mother.getBirthEvent().getDate()}" />&nbsp;<c:out value="${mother.getBirthEvent().getLocation()}"/></td>
					</c:if>
					
					<c:if test="${null == mother.getDeathEvent()}">
						<td width="30%">&nbsp;</td>
					</c:if>
					<c:if test="${null != mother.getDeathEvent()}">
						<td width="30%"><c:out value="${mother.getDeathEvent().getDate()}" />&nbsp;<c:out value="${mother.getDeathEvent().getLocation()}"/></td>
					</c:if>
				</c:if>
				<c:if test="${null == mother}">
					<td width="10%">&nbsp;</td>
					<td>&nbsp;</td>
					<td width="30%">&nbsp;</td>
					<td width="30%">&nbsp;</td>
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
		<c:forEach items="${timelineService.getAllByPersonId(id)}" var="event">
			<tr>
				<c:choose>
					<c:when test="${event.timelineEventType.asString() eq 'Census'}">
						<td><a href="censushousehold.jsp?id=<c:out value="${event.id}"/>"><c:out value="${event.id}"/></a></td>
					</c:when>
					<c:when test="${event.timelineEventType.asString() eq 'Marriage'}">
						<td><a href="marriage.jsp?id=<c:out value="${event.id}"/>"><c:out value="${event.id}"/></a></td>
					</c:when>
					<c:otherwise>
						<td><a href="event.jsp?id=<c:out value="${event.id}"/>"><c:out value="${event.id}"/></a></td>
					</c:otherwise>
				</c:choose>
				<td><c:out value="${event.timelineEventType.asString()}"/></td>
				<td><c:out value="${event.date}"/></td>
				<td><c:out value="${event.location}"/></td>
				<td><c:out value="${event.details}"/></td>
			</tr>
		</c:forEach>
		</table>
		
		<h2>Census</h2>
		
		<table width='100%'>
			<thead>
				<tr>
					<th width='7%'>Id</th>
					<th>Date</th>
					<th>Census</th>
					<th>Address</th>
					<th>Name</th>
					<th>Age</th>
					<th>Occupation</th>
				</tr>
			</thead>
		<c:forEach items="${censusService.getAllCensusSummaryForPerson(id)}" var="censusSummary">
			<tr>
				<td><a href="censushousehold.jsp?id=<c:out value="${censusSummary.getId()}"/>"><c:out value="${censusSummary.getId()}"/></a></td>
				<td><c:out value="${censusSummary.getDate()}"/></td>
				<td><c:out value="${censusSummary.getTitle()}"/></td>
				<td><c:out value="${censusSummary.getAddress()}"/></td>
				<td><c:out value="${censusSummary.getName()}"/></td>
				<td><c:out value="${censusSummary.getAge()}"/></td>
				<td><c:out value="${censusSummary.getOccupation()}"/></td>
			</tr>
		</c:forEach>
		</table>
		
		<h2>Marriages</h2>

		<table width='75%'>
			<thead>
				<tr>
					<th width='10%'>Id</th>
					<th width='20%'>Date</th>
					<th width='30%'>Spouse</th>
					<th width='40%'>Localtion</th>
				</tr>
			</thead>
		<c:forEach items="${marriageService.getAllForPersonId(id)}" var="marriage">
			<tr>
				<td><a href="marriage.jsp?id=<c:out value="${marriage.getId()}"/>"><c:out value="${marriage.getId()}"/></a></td>
				<td><c:out value="${marriage.getDate()}"/></td>
				<c:if test="${id == marriage.getHusbandId()}">
					<c:set var="spouse" value="${personService.getById(marriage.getWifeId())}"/>
				</c:if>
				<c:if test="${id == marriage.getWifeId()}">
					<c:set var="spouse" value="${personService.getById(marriage.getHusbandId())}"/>
				</c:if>
				<td><a href="person.jsp?id=<c:out value="${spouse.getId()}"/>"><c:out value="${spouse.getFullName()}"/></a></td>
				<td><c:out value="${marriage.getLocation()}"/></td>
			</tr>
		</c:forEach>
		</table>
		
		<h2>Children</h2>

		<table width='75%'>
			<thead>
				<tr>
					<th width='10%'>Id</th>
					<th>Name</th>
					<th width='30%'>Birth</th>
					<th width='30%'>Death</th>
				</tr>
			</thead>
		<c:forEach items="${personService.getAllChildrenByPersonId(id)}" var="child">
			<tr>
				<td><a href="person.jsp?id=<c:out value="${child.getId()}"/>"><c:out value="${child.getId()}"/></a></td>
				<td><c:out value="${child.getFullName()}"/></td>
				<c:if test="${null == child.getBirthEvent()}">
					<td>&nbsp;</td>
				</c:if>
				<c:if test="${null != child.getBirthEvent()}">
					<td><c:out value="${child.getBirthEvent().getDate()}" />&nbsp;<c:out value="${child.getBirthEvent().getLocation()}"/></td>
				</c:if>
				<c:if test="${null == child.getDeathEvent()}">
					<td>&nbsp;</td>
				</c:if>
				<c:if test="${null != child.getDeathEvent()}">
					<td><c:out value="${child.getDeathEvent().getDate()}" />&nbsp;<c:out value="${child.getDeathEvent().getLocation()}"/></td>
				</c:if>
			</tr>
		</c:forEach>
		</table>
		
		<br />
	</body>
</html>