<%-- 
    Document   : postEdit
    Created on : 19 Dec 2021, 21:38:13
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Post edit page</h1>
<form:form modelAttribute="post" action="" method="post">
    <div class="row mb-3">
        <label for="title" class="form-label">title</label>
        <form:input path="title" type="text" cssClass="form-control" id="title"/>
        <form:errors path="title" element="p" cssClass="text text-danger"/>
    </div>
    <div class="row mb-3">
        <label for="description" class="form-label">description</label>
        <form:textarea path="description" type="text-area" cssClass="form-control" id="description" rows="5"/>
        <form:errors path="description" element="p" cssClass="text text-danger"/>
    </div>
    <p class="text text-danger">${errors}</p>
    <button class="btn btn-success" type="submit">Update</button>
</form:form>
<core:url value="/post/${post.id}/delete/" var="deleteActionUrl"/>
<form:form modelAttribute="post" action="${deleteActionUrl}" method="post">
    <button class="btn btn-danger">Delete</button>
</form:form>
    
    
