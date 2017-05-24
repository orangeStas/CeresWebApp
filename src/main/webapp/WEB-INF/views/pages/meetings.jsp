<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kirilltsivako
  Date: 5/18/17
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="card-panel z-depth-2">
        <div class="card-title cyan darken-4 row green-header" style="margin-left: -1.75%">
            <h3 class="white-text col s9" style="margin-top: 0; margin-bottom: 0;">Встречи</h3>
            <c:if test="${not empty pageContext.request.userPrincipal.name}">
                <div class="col s3"><a href="/meetings/addmeeting" class="btn" style="margin-top: 3%;">Создать встречу</a></div>
            </c:if>
        </div>

        <div class="card-content row">

            <c:forEach var="meeting" items="${meetingsList}" varStatus="loop">

                <div class="card cyan darken-4 col s10 offset-s1 z-depth-2">
                    <div class="card-title row" style="margin-top: 25px; margin-bottom: 0px; margin-left: 1%;">
                        <h5 class="white-text col s11" style="margin-top: 5px;">${meeting.title}</h5>

                        <c:if test="${not empty pageContext.request.userPrincipal.name}">
                            <c:if test="${meeting.author.user.id ne currentUserId}">
                                <c:if test="${not userInMeetingList[loop.index]}">
                                    <form:form method="post" action="${pageContext.request.contextPath}/meetings/join" cssClass="col s1 right">
                                        <input type="hidden" name="meetingId" value="${meeting.id}">
                                        <button type="submit" name="action" class="btn-floating waves-effect"><i class="material-icons">add</i></button>
                                    </form:form>
                                </c:if>

                                <c:if test="${userInMeetingList[loop.index]}">
                                    <form:form method="post" action="${pageContext.request.contextPath}/meetings/leave" cssClass="col s1 right">
                                        <input type="hidden" name="meetingId" value="${meeting.id}">
                                        <button type="submit" name="action" class="btn-floating waves-effect red"><i class="material-icons">delete</i></button>
                                    </form:form>
                                </c:if>
                            </c:if>
                        </c:if>
                    </div>

                    <div class="card-tabs"">
                        <ul class="tabs tabs-fixed-width" style="padding-left: 0;">
                            <li class="tab"><a href="#short-info-tab${meeting.id}">Информация</a></li>
                            <li class="tab"><a href="#info-tab${meeting.id}">Описание</a></li>
                            <li class="tab"><a href="#participants-tab${meeting.id}">Участники</a></li>
                        </ul>
                    </div>

                    <div class="card-content white" style="width: 102.5%; margin-left: -1.25%;">
                        <div id="short-info-tab${meeting.id}">
                            <div class="row">
                                <p class="col s3"><b>Организатор</b></p>
                                <p class="col s3"><b>Дата</b></p>
                                <p class="col s3"><b>Начало в</b></p>
                                <p class="col s3"><b>Место</b></p>
                            </div>
                            <div class="row">
                                <p class="col s3">${meeting.author.name} ${meeting.author.surname}</p>
                                <p class="col s3"><fmt:formatDate type="date" dateStyle="short" value="${meeting.created_at}" /></p>
                                <p class="col s3"><fmt:formatDate type="time" timeStyle="short" value="${meeting.created_at}" /></p>
                                <p class="col s3">${meeting.place}</p>
                            </div>
                        </div>
                        <div id="info-tab${meeting.id}">
                            ${meeting.content}
                        </div>
                        <div id="participants-tab${meeting.id}">
                            <c:forEach var="student" items="${meeting.participants}">
                                <div class="card cyan darken-4 hoverable">
                                    <div class="row">
                                        <div class="card-content col s9" style="padding-left: 5%;">
                                            <div class="card-title white-text">
                                                <h5>${student.name} ${student.surname}</h5>
                                            </div>
                                            <p class="white-text">
                                                ${student.speciality.faculty.university.name}
                                            </p>
                                            <p class="white-text">
                                                ${student.speciality.faculty.name}
                                            </p>
                                            <p class="white-text">
                                                ${student.speciality.name}
                                            </p>
                                        </div>

                                        <div class="card-content col s2 right">
                                            <c:if test="${not empty student.imageName}">
                                                <img width="100" height="100" class="circle" style="margin-top: 20px;" src="${pageContext.request.contextPath}/files/${student.imageName}" alt="profile-image" />
                                            </c:if>

                                            <c:if test="${empty student.imageName}">
                                                <img width="100" height="100" class="circle" style="margin-top: 20px;" src="https://upload.wikimedia.org/wikipedia/commons/9/9a/%D0%9D%D0%B5%D1%82_%D1%84%D0%BE%D1%82%D0%BE.png" alt="profile-image" />
                                            </c:if>
                                        </div>
                                    </div>
                                    <c:if test="${not empty pageContext.request.userPrincipal.name}">
                                        <div class="row">
                                            <div class="card-action sol s12" style="padding-left: 5%;">
                                                <a href="/education/profile/${student.id}">Профиль</a>
                                            </div>
                                        </div>
                                    </c:if>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>

            </c:forEach>

        </div>
    </div>
</div>
