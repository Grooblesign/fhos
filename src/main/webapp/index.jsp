<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="stylesheet.css" type="text/css" media="all">
		<title>Family History</title>
	</head>
	<body>
		<H1>Family History</H1>

		<h2>Show people with surnames starting with:</h2>

		<table width="50%">
			<tr>
			<%
			String letters1 = "ABCDEFGHIJKLM";
			for (int i=0; i<letters1.length(); i++) {
				String letter = letters1.substring(i, i+1);
				%>	
				<td>
					<a href='surnames.jsp?letter=<%=letter%>'><%=letter%></a>
				</td>					
				<%
			}
			%>
			</tr>
		</table>
		<br />
		<table width="50%">
			<tr>
			<%
			String letters2 = "NOPQRSTUVWXYZ";
			for (int i=0; i<letters2.length(); i++) {
				String letter = letters2.substring(i, i+1);
				%>	
				<td>
					<a href='surnames.jsp?letter=<%=letter%>'><%=letter%></a>
				</td>					
				<%
			}
			%>
			</tr>
		</table>
	</body>
</html>