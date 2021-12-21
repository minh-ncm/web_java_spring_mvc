<%-- 
    Document   : userLogin
    Created on : 21 Dec 2021, 12:07:34
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<core:if test="${param.error != null}">
    <p class="alert alert-danger">Log in failed, please try again.</p>
</core:if>
<form class="form-group">
    <label for="username">username</label>
    <input type="text" id="username", name="username" class="form-control"/>
    <label for="password">password</label>
    <input type="password" id="password", name="password" class="form-control"/>
    <button type="submit" class="btn btn-primary">Login</button>
</form>
