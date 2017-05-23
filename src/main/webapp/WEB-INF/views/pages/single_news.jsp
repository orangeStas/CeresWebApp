<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kirilltsivako
  Date: 5/23/17
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container z-depth-2">
        <div class="card-panel">
            <div class="card-title cyan darken-4" style="margin-left: -1.75%; width: 103.5%; padding-left: 5%; padding-right: 5%;">
                <h5 class="white-text">${news.title}</h5>
            </div>

            <div class="card-content" style="padding-left: 5%; padding-right: 5%;">
                <div class="row center">
                    <img src="/resources/images/news/${news.imageFileName}" alt="">
                </div>

                <div class="row cyan darken-4" style="margin-left: -7.5%; width: 115%; padding-left: 5%; padding-right: 5%;">
                    <p class="white-text col s6"><fmt:formatDate type="both" dateStyle="short" timeStyle="short"
                                                                 value="${news.creationDate}" /></p>
                    <p class="white-text col s6 right-align">${news.author.student.name} ${news.author.student.surname}</p>
                </div>

                <div class="row">
                    ${news.content}
                </div>
            </div>
        </div>

        <div>
            <ul class="collection with-header-hoverable">
               <div class="cyan darken-4" style="width: 110%; margin-left: -5%; padding-left: 5%;">
                    <h5 class="white-text">Комментарии</h5>
               </div>

                <c:if test="${empty news.comments}">
                <li class="collection-item zero-left-padding clear-list">
                    <p>Коментарии отсутствуют.</p>
                </li>
                </c:if>

                <c:if test="${not empty news.comments}">

                    <c:forEach var="comment" items="${news.comments}" varStatus="loop">
                        <li class="collection-item zero-left-padding clear-list">
                            <div class="row">

                                <img width="70" height="70" class="circle left" style="margin-top: 20px;" src="${pageContext.request.contextPath}/files/${comment.author.imageName}" alt="profile-image" />

                                <div class="col s10">
                                    <div class="row" style="padding: 0 0 0 9px; margin: 0;">
                                        <p class="col s2 teal-text" style="padding-bottom: 0;">${comment.author.name} ${comment.author.surname}</p>
                                        <p class="col s4 teal-text"><fmt:formatDate type="both" dateStyle="short" timeStyle="short"
                                                                                    value="${comment.datetime}" /></p>
                                    </div>
                                    <div class="row" style="padding: 0 0 0 20px; margin: 0;">
                                        <p style="padding: 0; margin: 0;">${comment.content}</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
            </c:if>
            </ul>

            <c:if test="${not empty pageContext.request.userPrincipal.name}">
                <form action="${pageContext.request.contextPath}/news/addComment" method="post">
                    <input type="hidden" name="news_id" value="${news.id}">
                    <div class="row">
                        <div class="input-field col s9" style="padding-left: 2.5%; padding-right: 2.5%; margin-top: 0;">
                            <input name="comment_text" required type="text" class="validate"
                                   placeholder="Новый комментарий">
                        </div>
                        <button class="right btn waves-effect waves-light col s2" type="submit" name="action" style="margin-right: 60px; margin-top: 10px;">Добавить
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </form>
            </c:if>
        </div>
</div>