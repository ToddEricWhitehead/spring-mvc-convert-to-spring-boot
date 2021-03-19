<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lov Calc</title>
</head>
<body>
  <h1 align="center">Love Calculator</h1>
  <hr/>
  
  <h2>The Love Calculator Predicts : </h2>
  <br/>
  ${userInfoDTO.userName} and ${userInfoDTO.crushName} are :
  <br/>
  <!-- {result} --> 
  ${result} ZONE
  ${userInfoDTO.result}
  <br/>
  <!-- <a href="/spring-love-calculator/sendMail">Send Result to Your Email</a> -->
  <a href="<c:url value="/sendMail" />">Send Result to Your Email</a>
  
  <!-- <a href="/spring-love-calculator/sendMail/?userName=${userInfoDTO.userName}">Send Result to Your Email</a> -->
</body>
</html>