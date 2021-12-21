<%-- 
    Document   : postDetail
    Created on : 17 Dec 2021, 12:32:49
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="url.like.create" var="likeCreate"/>
<core:url value="${likeCreate}" var="likeCreateUrl"/>
<spring:message code="url.comment.create" var="commentCreate"/>
<core:url value="${commentCreate}" var="commentCreateUrl"/>
<spring:message code="url.bid.create" var="bidCreate"/>
<core:url value="${bidCreate}" var="bidCreateUrl"/>

<script type="text/javascript" src="<core:url value="/js/postDetail.js"/>"></script>


<div class="container-md">
    <img src="${post.imageUrl}" class="img-fluid" alt="${post.title}">
    <p class="h2">${post.title}</p> 
    <p class="text-muted">Ending at: ${post.endDate}</p>
    <a href="edit/">Edit post</a>
    <a href="bid/">Bid details</a>
    <p>${post.description}</p>
</div>
<div>
    <div class="btn-group">
        <form:form method="post" modelAttribute="like" action="${likeCreateUrl}" cssClass="likeHiddenForm">
                      <form:select path="user" id="user" cssStyle="display:none;">
                          <option value="${user.id}"></option>
                      </form:select>
                      <form:select path="post" id="post" cssStyle="display:none;">
                          <option value="${post.id}">${post.id}</option>
                      </form:select>
                          <button class="btn btn-primary" type="submit">Like</button>
        </form:form>
        <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#commentForm" aria-expanded="false" aria-controls="commentForm" >Comment</button>
        <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#bidForm" aria-expanded="false" aria-controls="bidForm">Bid</button>
    </div>
    <div class="collapse" id="commentForm">
        <form:form method="post" modelAttribute="comment" action="${commentCreateUrl}" onsubmit="return validateComment();">
            <form:select path="user" id="user" cssStyle="display:none;">
                <option value="${user.id}"></option>
            </form:select>
            <form:select path="post" id="post" cssStyle="display:none;">
                <option value="${post.id}">${post.id}</option>
            </form:select>
                <p class="text text-danger" id="commentTextError"></p>
                <form:textarea path="text" type="text" rows="3" id="commentText"/>
              <button class="btn btn-primary" type="submit">Create</button>
        </form:form>
      </div>
          
    <div class="collapse" id="bidForm">
        <form:form method="post" modelAttribute="bid" action="${bidCreateUrl}" onsubmit="return validateBid();">
            <form:select path="user" id="user" cssStyle="display:none;">
                <option value="${user.id}"></option>
            </form:select>
            <form:select path="post" id="post" cssStyle="display:none;">
                <option value="${post.id}">${post.id}</option>
            </form:select>
                <p class="text text-danger" id="bidAmountError"></p>
                <form:input path="amount" type="number" step="0.01" id="bidAmount" />
            <button class="btn btn-primary" type="submit">Bid</button>
        </form:form>
    </div> 
</div>
<div>
    <ul class="list-group">
        <core:forEach items="${commentList}" var="comment">
            <li class="list-group-item">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${comment.user.username}</h4>
                        <h6 class="card-subtitle text-muted">Commented on: ${comment.createdDate}</h6>
                        <hr/>
                        <p class="card-text">${comment.text}</p>
                    </div>
                </div>
            </li>
        </core:forEach>
    </ul>
</div>