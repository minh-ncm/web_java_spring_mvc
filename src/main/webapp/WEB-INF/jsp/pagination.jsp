<%-- 
    Document   : pagination
    Created on : 15 Dec 2021, 17:29:48
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="url.dashboard" var="dashboard"/>
<core:url value="${dashboard}" var="dashboarUrl"/>

<nav aria-label="Page navigation">
    <ul class="pagination justify-content-center">
      <core:if test="${currentPage > 1}">
          <li class="page-item"><a class="page-link" href="${dashboardUrl}?currentPage=${currentPage-1}">Previous</a></li>
      </core:if>
          <li class="page-item"><a class="page-link" href="${dashboardUrl}?currentPage=${currentPage}">${currentPage}</a></li>
      <core:if test="${currentPage < maxPage}">
          <li class="page-item"><a class="page-link" href="${dashboardUrl}?currentPage=${currentPage+1}">Next</a></li>
      </core:if>
    </ul>
</nav>