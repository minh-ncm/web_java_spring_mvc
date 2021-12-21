<%-- 
    Document   : userNotificationList
    Created on : 21 Dec 2021, 10:02:41
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <thead>
        <th>Post</th>
        <th>Action</th>
        <th>User</th>
        <th>Time</th>
    </thead>
    <tbody>
        <core:forEach items="${notificationList}" var="notification">
            <tr>
                <td>${notification.post.title}</td>
                <core:if test="${not empty notification.like}">
                    <td>Like</td>
                </core:if>
                <core:if test="${not empty notification.comment}">
                    <td>Comment</td>
                </core:if>
                <core:if test="${not empty notification.bid}">
                    <td>Bid</td>
                </core:if>
                <td>${notification.user.username}</td>
                <td>${notification.createdDate}</td>
            </tr>
        </core:forEach>
    </tbody>
</table>