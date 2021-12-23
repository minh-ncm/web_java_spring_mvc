<%-- 
    Document   : logout
    Created on : 23 Dec 2021, 15:51:10
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="url.user.login" var="userLogin"/>

<p class="display-3">Logged out</p>
<a class="btn btn-primary" href="<core:url value="${userLogin}"/>">Log in?</a>