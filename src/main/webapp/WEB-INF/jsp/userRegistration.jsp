<%-- 
    Document   : userRegistration
    Created on : 14 Dec 2021, 14:24:47
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>registration page</h1>
<form:form action="" modelAttribute="user" method="post" enctype="multipart/form-data">
    <div class="row mb-3">
        <label for="username" class="form-label">username</label>
        <form:input path="username" type="text" cssClass="form-control" id="username"/>
        <form:errors path="username" element="p" cssClass="text text-danger"/>
    </div>
    <div class="row mb-3">
        <label for="password" class="form-label">password</label>
        <form:input path="password" type="password" cssClass="form-control" id="password"/>
        <form:errors path="password" element="p" cssClass="text text-danger"/>
    </div>
    <div class="row mb-3">
        <label for="imageFile" class="form-label">password</label>
        <form:input path="imageFile" type="file" cssClass="form-control" id="imageFile"/>
    </div>

        <button type="submit" class="btn btn-success">Register</button>
</form:form>
