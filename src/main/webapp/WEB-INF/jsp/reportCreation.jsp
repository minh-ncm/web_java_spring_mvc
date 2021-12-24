<%-- 
    Document   : reportCreation
    Created on : 24 Dec 2021, 08:53:11
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<core:if test="${reportedId == null}">
    <ul>
        <form>
            <label>Keyword: </label>
            <input class="form-control" type="text" name="keyword"/>
            <button class="btn btn-primary">Filter</button>
        </form>
        <core:forEach items="${userList}" var="user">
            <core:if test="${sessionScope.currentUser.id != user.id}">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <h5>${user.username}</h5>
                    <form>
                        <input type="text" value="${user.id}" name="reportedId" style="display: none;"/>
                        <button class="btn btn-danger">report</button>
                    </form>
                </li>
            </core:if>
        </core:forEach>
    </ul>    
</core:if>
<core:if test="${reportedId != null}">
    <core:url value="/user/report/" var="action"/>
    <form:form method="post" modelAttribute="report" action="${action}">
        <label>Reason: </label>
        <form:input path="reason" type="text" />
        <form:input path="reported" type="text" value="${reportedId}" cssStyle="display: none;"/>
        <button class="btn btn-danger">Submit</button>
    </form:form>
</core:if>