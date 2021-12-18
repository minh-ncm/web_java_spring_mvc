<%-- 
    Document   : postCreation
    Created on : 15 Dec 2021, 09:19:18
    Author     : sie


--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Post creation page</h1>
<form:form modelAttribute="post" action="" method="post" enctype="multipart/form-data">
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
    <div class="row mb-3">
        <label for="endDate" class="form-label">end date</label>
        <form:input path="endDate" type="datetime-local" cssClass="form-control" id="endDate"/>
        <form:errors path="endDate" element="p" cssClass="text text-danger"/>
    </div>
    <div class="row mb-3">
        <label for="imageFile" class="form-label">end date</label>
        <form:input path="imageFile" type="file" cssClass="form-control" id="imageFile"/>
        <form:errors path="imageFile" element="p" cssClass="text text-danger"/>
    </div>
    <button class="btn btn-success" type="submit">Create</button>
</form:form>

