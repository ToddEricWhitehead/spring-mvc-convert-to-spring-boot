<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SessionAttributes</title>
</head>
<body>
	<h1>Session Attributes example</h1>
	
	First Name : ${firstName}
	<br/>
	Last Name : ${lastName}
	<br/>
	
	<hr/>
	
	firstName from request : ${requestScope.firstName}
	<br/>
	firstName from session : ${sessionScope.firstName}
	<br/>
	Address from HttpSession : ${address} 
	<br/>
	
	<hr/>
	
	<a href="/spring-love-calculator/${next}"> Next - ${next}</a>
</body>
</html>