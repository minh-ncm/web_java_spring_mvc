<%-- 
    Document   : postBidList
    Created on : 21 Dec 2021, 09:23:54
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

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
            </tr>
        </core:forEach>
    </tbody>
</table>