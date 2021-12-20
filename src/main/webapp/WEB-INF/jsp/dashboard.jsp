<%-- 
    Document   : homeIndex
    Created on : 13 Dec 2021, 21:49:27
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="<core:url value="/js/dashboard.js"/>" type="text/javascript"></script>

<div class="container">
    <h1>Index content</h1>  
    <div class="row-md">
    <core:forEach items="${postList}" var="post">
        <div class="col-md-4">
            <div class="card" onclick="window.location.href = 'post/${post.id}/';" >
                <img src="${post.imageUrl}" class="card-img-top" alt="${post.title}"/>
                <h3 class="card-title">${post.title}</h3>
                <p class="card-subtitle mb-2 text-muted">Ending at: ${post.endDate}</p>
                <div class="card-body">
                </div>
            </div>
        </div>
    </core:forEach>
    </div>
</div>
    
