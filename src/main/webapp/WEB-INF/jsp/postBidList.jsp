<%-- 
    Document   : postBidList
    Created on : 21 Dec 2021, 09:23:54
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<core:if test="${post.winner != null}">
    <p class="display-4">Winner: ${post.winner.username}</p>
</core:if>
<core:if test="${errors != null}">
    <p class="alert alert-danger">${errors}</p>
</core:if>
<table class="table">
    <thead>
        <th>Username</th>
        <th>Bid amount</th>
        <th>Placed date</th>
    </thead>
    <tbody>
        <core:forEach items="${bidList}" var="bid">
            <tr>
                <td>${bid.user.username}</td>
                <td>${bid.amount}</td>
                <td>${bid.createdDate}</td>
                <td class="col-md-2">
                    <core:url value="/post/${post.id}/winner/" var="action"/>
                    <form:form modelAttribute="post" method="post" action="${action}">
                        <form:input path="winner" type="text" value="${bid.user.id}" cssStyle="display: none;"/>
                        <button class="btn btn-primary" type="submit">Set as winner</button>
                    </form:form>
                </td>
            </tr>
        </core:forEach>
    </tbody>
</table>