<%-- 
    Document   : tagCreation
    Created on : 22 Dec 2021, 15:00:13
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<core:if test="${isCreated}">
    <p>Create more?</p>
</core:if>
    
<form:form method="post" modelAttribute="tag" cssClass="form-group">
    <form:input path="type" type="text" cssClass="form-control"/>
    <button type="submit" class="btn btn-success">Create</button>
</form:form>

