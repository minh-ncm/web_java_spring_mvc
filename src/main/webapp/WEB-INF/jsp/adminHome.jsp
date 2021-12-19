<%-- 
    Document   : adminHome
    Created on : 18 Dec 2021, 14:36:09
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<p class="display-5">post's statistic</p>
<form method="get" class="form-group">
    <div class="row-md mb-3">
        <label for="afterDate" class="h5 col-md-1" >After: </label>
        <input class="form-comtrol" type="datetime-local" name="afterDate" id="afterDate"/>
    </div>
    <div class="row-md mb-3">
        <label for="beforeDate" class="h5 col-md-1">Before: </label>
        <input class="form-comtrol" type="datetime-local" name="beforeDate" id="beforeDate"/>
    </div>
    <div class="row-md">
        <button class="btn btn-primary" type="submit">Filter</button>
    </div>
</form>
<table class="table">
    <thead>
        <tr>
          <th scope="col">POST ID</th>
          <th scope="col">POST'S CREATED DATE</th>
          <th scope="col">TOTAL LIKES</th>
          <th scope="col">TOTAL COMMENTS</th>
        </tr>
    </thead>
    <core:forEach items="${postStatistic}" var="record">
        <tr>
        <core:forEach items="${record}" var="item">
            <td scope="col">${item}</td>
        </core:forEach>
        </tr>
    </core:forEach>
</table>
