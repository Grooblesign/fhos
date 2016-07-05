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

		<h2>Show surnames starting with:</h2>

		<table>
			<tr>
			<%
			String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			for (int i=0; i<letters.length(); i++) {
				String letter = letters.substring(i, i+1);
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