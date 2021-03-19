<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>

<style type="text/css">
.error {
	color: purple;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>
</head>
<body>
	<h1 align="center">Please register here</h1>
	<form:form action="registration-success" method="get" modelAttribute="userReg">
	
		<div align="center">
			<label>Name : </label>
			<form:input path="name"/>
			<form:errors path="name" cssClass="error"/>	
			<br/>
			<label>User Name : </label>
			<form:input path="userName" />
			<form:errors path="userName" cssClass="error"/>	
			<br/>
			<label>Password : </label>
			<form:input path="password" />
			<br/>
			<label>Age : </label>
			<form:input path="age"/>
			<form:errors path="age" cssClass="error"/>
			
		</div>
	
		<div align="center">
			<h3>Communication</h3>
			<label>Email : </label>
			<form:input path="communicationDTO.email"/>
			<form:errors path="communicationDTO.email" cssClass="error"/>
			<br/>
			<label>Phone : </label>
			<form:input path="communicationDTO.phone"/>
		</div>
		<div align="center">
			<br/>
			<input type="submit" value="Register" />
		</div>	
	</form:form>
	
</body>
</html>