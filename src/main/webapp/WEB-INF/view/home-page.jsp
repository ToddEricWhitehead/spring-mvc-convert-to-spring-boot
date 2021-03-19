<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>
<title>Lov Calc</title>
<script>
	function validateNames() {
		var userName = document.getElementById("yn").value;
		if (userName.length < 2) {
			alert("userName length less than 2")
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>

	<h1 align="center">Love Calculators</h1>
	<hr />

	<form:form action="process-homepage" method="get" modelAttribute="userInfoDTO">
		<div align="center">
			<p>
				<label for="yn">Your Name : </label>
				<form:input id="yn" path="userName" />
				<form:errors path="userName" cssClass="error" />
			</p>
			<p>
				<label for="cn">Crush Name : </label>
				<form:input id="cn" path="crushName" />
				<form:errors path="crushName" cssClass="error"/>
			</p>
			<p>
			    <form:checkbox path="termAndCondition" id="check"/>
			    <label>I am agreeing this is just for fun</label>
			    <form:errors path="termAndCondition" cssClass="error"/>
			</p>
			<input type="submit" value="calculate" />
		</div>
	</form:form>

</body>
</html>