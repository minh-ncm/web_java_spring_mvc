<%-- 
    Document   : accessDenied
    Created on : 23 Dec 2021, 16:38:10
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="url.user.logout" var="userLogoutUrl"/>


<core:if test="${param.accessDenied != null}">
    <p class="alert alert-danger">Your account don't have permission to view this page. Try login with an account has permission.</p>
</core:if>
    <a class="btn btn-primary" href="<core:url value="${userLogoutUrl}"/>">Logout</a>
