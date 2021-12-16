<%-- 
    Document   : homeIndex
    Created on : 13 Dec 2021, 21:49:27
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="url.like.create" var="likeCreate"/>
<core:url value="${likeCreate}" var="likeCreateUrl"/>
<spring:message code="url.comment.create" var="commentCreate"/>
<core:url value="${commentCreate}" var="commentCreateUrl"/>
<spring:message code="url.bid.create" var="bidCreate"/>
<core:url value="${bidCreate}" var="bidCreateUrl"/>

<h1>Index content</h1>
<core:forEach items="${postList}" var="post">
    <div class="card" style="width: 18rem;">
        <img src="..." class="card-img-top" alt="..."/>
        <h5 class="card-title">${post.title}</h5>
         <h6 class="card-subtitle mb-2 text-muted">Ending at: ${post.endDate}</h6>
        <div class="card-body">
          <p class="card-text">${post.description}</p>
          <div class="container btn-group">
              <form:form method="post" modelAttribute="like" action="${likeCreateUrl}" cssClass="likeHiddenForm">
                  <form:select path="user" id="user" cssStyle="display:none;">
                      <option value="${user.id}"></option>
                  </form:select>
                  <form:select path="post" id="post" cssStyle="display:none;">
                      <option value="${post.id}">${post.id}</option>
                  </form:select>
                      <button class="btn btn-primary" type="submit">Like</button>
              </form:form>
                  
            <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#commentForm${post.id}" aria-expanded="false" aria-controls="commentForm${post.id}">Comment</button>
            <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#bidForm${post.id}" aria-expanded="false" aria-controls="bidForm${post.id}">Bid</button>
                  
          </div>
        </div>
      </div>
              
    <div class="collapse" id="commentForm${post.id}">
        <form:form method="post" modelAttribute="comment" action="" >
            <form:select path="user" id="user" cssStyle="display:none;">
                <option value="${user.id}"></option>
            </form:select>
            <form:select path="post" id="post" cssStyle="display:none;">
                <option value="${post.id}">${post.id}</option>
            </form:select>
            <form:textarea path="text" type="text" rows="3"/>
            <form:errors path="text" cssClass="text text-danger"/>
              <button class="btn btn-primary" type="submit">Create</button>
        </form:form>
      </div>
          
    <div class="collapse" id="bidForm${post.id}">
        <form:form method="post" modelAttribute="bid" action="${bidCreateUrl}">
            <form:select path="user" id="user" cssStyle="display:none;">
                <option value="${user.id}"></option>
            </form:select>
            <form:select path="post" id="post" cssStyle="display:none;">
                <option value="${post.id}">${post.id}</option>
            </form:select>
            <form:input path="amount" type="number"/>
            <button class="btn btn-primary" type="submit">Bid</button>
        </form:form>
    </div>    
</core:forEach>

    
