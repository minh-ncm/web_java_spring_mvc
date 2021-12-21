<%-- 
    Document   : header
    Created on : 13 Dec 2021, 23:15:52
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="url.dashboard" var="dashboardUrl"/>
<spring:message code="url.admin" var="adminUrl" />
<spring:message code="url.user.register" var="userRegisterUrl"/>
<spring:message code="url.post.create" var="postCreateUrl" />

<nav class="navbar navbar-expand-md navbar-dark bg-primary">
  <div class="container-fluid">
      <a class="navbar-brand" href="<core:url value="${dashboardUrl}"/>" aria-current="page">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Notifications</a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="<core:url value="/1/notification/"/>">See all notifications</a></li>
          </ul>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Account</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<core:url value="${postCreateUrl}"/>">create post</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<core:url value="${adminUrl}"/>">admin</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<core:url value="${userRegisterUrl}"/>">register</a>
        </li>
      </ul>
    </div>
  </div>
</nav>