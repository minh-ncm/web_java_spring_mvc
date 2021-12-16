<%-- 
    Document   : homeIndex
    Created on : 13 Dec 2021, 21:49:27
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="url.like.create" var="likeCreateUrl"/>
<spring:message code="url.comment.create" var="commentCreateUrl"/>
<spring:message code="url.bid.create" var="bidCreateUrl"/>

<h1>Index content</h1>
<core:forEach items="${postList}" var="post">
    <div class="card" style="width: 18rem;">
        <img src="..." class="card-img-top" alt="..."/>
        <h5 class="card-title">${post.title}</h5>
         <h6 class="card-subtitle mb-2 text-muted">Ending at: ${post.endDate}</h6>
        <div class="card-body">
          <p class="card-text">${post.description}</p>
          <div class="container btn-group">
              <a class="btn btn-primary" role="button" href="<core:url value="${likeCreateUrl}"/>?postId=${post.id}&userId=${user.id}">Like</a>
              <a class="btn btn-primary" role="button"href="<core:url value="${postCreateUrl}"/>">Comment</a>
              <a class="btn btn-primary" role="button" href="<core:url value="${bidCreateUrl}"/>">Bid</a>
          </div>
        </div>
      </div>
</core:forEach>

    
