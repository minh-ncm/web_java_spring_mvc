<%-- 
    Document   : pagination
    Created on : 15 Dec 2021, 17:29:48
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<nav aria-label="Page navigation">
    <ul class="pagination">
      <core:if test="${currentPage > 1}">
          <li class="page-item"><a class="page-link" href="<core:url value="/"/>?currentPage=${currentPage-1}">Previous</a></li>
      </core:if>
      <core:if test="${empty currentPage}">
          <li class="page-item"><a class="page-link" href="<core:url value="/"/>?currentPage=1">1</a></li>
      </core:if>
      <core:if test="${not empty currentPage}">
          <li class="page-item"><a class="page-link" href="<core:url value="/"/>?currentPage=${currentPage}">${currentPage}</a></li>
      </core:if>
      <core:if test="${currentPage < maxPage}">
          <li class="page-item"><a class="page-link" href="<core:url value="/"/>?currentPage=${currentPage+1}">Next</a></li>
      </core:if>
    </ul>
</nav>