<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="stylesheet.css" type="text/css" media="all">
		<title>Login</title>
	</head>
	<body>
		<H1>Family History</H1>
	
		<form name="loginForm" method="POST" action="j_security_check">
            <p><strong>Username: </strong>
                <input type="text" name="j_username" size="25"></p>
            <p><strong>Password: </strong>
                <input type="password" size="15" name="j_password"></p>
            <p>
                <input type="submit" value="Submit"/>
                <input type="reset" value="Reset"/></p>
        </form>     	
	</body>
</html>