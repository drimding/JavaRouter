<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Random Login Form</title>
	  <link rel="stylesheet" href="<jstl:url value="/resources/css/login_page.css"/> "/>

 </head>

  <body>

    <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Site<span>Random</span></div>
		</div>
		<br>
		<form class="login" action="/login" method="POST">
				<input type="text" placeholder="username" name="username"><br>
				<input type="password" placeholder="password" name="password"><br>
				<input type="submit" value="Login">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
  </body>
</html>
