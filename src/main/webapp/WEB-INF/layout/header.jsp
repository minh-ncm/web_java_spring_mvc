<%-- 
    Document   : header
    Created on : 13 Dec 2021, 23:15:52
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<spring:message code="url.dashboard" var="dashboardUrl"/>
<spring:message code="url.admin" var="adminUrl" />
<spring:message code="url.user.register" var="userRegisterUrl"/>
<spring:message code="url.user.login" var="userLoginUrl" />
<spring:message code="url.user.logout" var="userLogoutUrl" />
<spring:message code="url.post.create" var="postCreateUrl" />
<spring:message code="url.report.create" var="userReportUrl" />

<nav class="navbar navbar-expand-md navbar-dark bg-primary">
  <div class="container-fluid">
      <a class="navbar-brand" href="<core:url value="${dashboardUrl}"/>" aria-current="page">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="<core:url value="${postCreateUrl}"/>">create post</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<core:url value="${userReporturl}"/>">report user</a>
        </li>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <li class="nav-item">
                <a class="nav-link" href="<core:url value="${adminUrl}"/>">admin</a>
            </li>
        </security:authorize>
        <core:if test="${pageContext.request.userPrincipal.name == null}">
            <li class="nav-item">
                <a class="nav-link" href="<core:url value="${userLoginUrl}"/>">login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<core:url value="${userRegisterUrl}"/>">register</a>
            </li>
        </core:if>
        <core:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="nav-item">
                <a class="nav-link" href="#">${pageContext.request.userPrincipal.name}'s account</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Notifications
                    <core:if test="${sessionScope.currentUser.unreadNotiAmount != 0}">
                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">${sessionScope.currentUser.unreadNotiAmount}</span>
                    </core:if>
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="#">Action</a></li>
                  <li><a class="dropdown-item" href="#">Another action</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="<core:url value="/${currentUser.id}/notification/"/>">See all notifications</a></li>
                </ul>
              </li>
            <li class="nav-item">
                <a class="nav-link" href="<core:url value="${userLogoutUrl}"/>">logout</a>
            </li>
        </core:if>
      </ul>
    </div>
  </div>
</nav>