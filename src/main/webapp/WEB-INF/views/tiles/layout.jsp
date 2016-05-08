<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<meta id="csrf" content="${_csrf.token}"/>
	<meta id="csrf_header" content="${_csrf.headerName}"/>

<title><tiles:getAsString name="title"></tiles:getAsString></title>
<link rel="stylesheet" href="<jstl:url value="/resources/css/style.css"/> "/>
<link rel="stylesheet" href="<jstl:url value="/resources/css/animation.css"/> "/>
<link rel="stylesheet" href="<jstl:url value="/resources/css/responsive.css"/> "/>
<script src="<jstl:url value="resources/js/script.js"/> "></script>
<script src="<jstl:url value="resources/js/jquery-2.1.4.js"/> "></script>

</head>
<body>
<div class="container">
	<div id="asideSection" >
	<div><tiles:insertAttribute name="header"></tiles:insertAttribute></div>
	<div class="content"><tiles:insertAttribute name="body"></tiles:insertAttribute></div>
	<div><tiles:insertAttribute name="footer"></tiles:insertAttribute></div>
	</div>
</div>
</body>
</html>