<%-- 
    Document   : postCreation
    Created on : 15 Dec 2021, 09:19:18
    Author     : sie


--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="url.tag.create" var="tagCreate"/>


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
    <div class="row mb-3"
         
         <label for="tagListCheckboxes">Tags</label>
        <div class="form-checkbox">
            <core:forEach items="${tagList}" var="tag">
                <label for="tag#${tag.id}" class="form-checkbox-label">${tag.type}</label>
                <form:checkbox path="tagList" value="${tag.id}" cssClass="form-checkbox-input" id="tag#${tag.id}"/>
            </core:forEach>
        </div>
        <%--<form:checkboxes items="${tagList}" path="tagList" itemValue="id" itemLabel="type" id="tagListCheckboxes" cssClass="form-check-input"/>--%>
        
        <a href="<core:url value="${tagCreate}"/>">Create new tag</a>
    </div>
    <div class="row mb-3">
        <label for="imageFile" class="form-label">end date</label>
        <form:input path="imageFile" type="file" cssClass="form-control" id="imageFile"/>
        <form:errors path="imageFile" element="p" cssClass="text text-danger"/>
    </div>
    <button class="btn btn-success" type="submit">Create</button>
</form:form>

