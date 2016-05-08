<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec"%>
<header> 
        <a  href="<jstl:url value="/"/>"> <img src="<jstl:url value="resources/img/logo.jpg"/>" class="logo" ></a>
    <sec:authorize access="isAuthenticated()">
       <form action="logout" method="post" class="logout">
            <sec:authentication property="name" />
            <input type="submit" value="LogOut"> <input type="hidden"
                                                        name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </sec:authorize>
        <form action="" method="post" class="search">
            <input type="text" name="search" placeholder="Пошук" value='' class="input" />
            <input type="submit"  value="Пошук" class="submit" />
        </form>
        <h1>Java Router</h1>
</header>