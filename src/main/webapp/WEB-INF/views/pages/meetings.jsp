<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kirilltsivako
  Date: 5/18/17
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="card-panel">
        <div class="card-title teal darken-1" style="margin-left: -2%; width: 104%; padding-left: 9%;">
            <h3 class="white-text">Встречи</h3>
        </div>

        <div class="card-content row">

            <c:forEach var="meeting" items="${meetingsList}">

                <div class="card teal darken-1 col s10 offset-s1">
                    <div class="card-title" style="margin-top: 25px;">
                        <h5 class="white-text">${meeting.title}</h5>
                    </div>

                    <div class="card-tabs" style="width: 102.5%; margin-left: -1.25%;">
                        <ul class="tabs tabs-fixed-width" style="padding-left: 0;">
                            <li class="tab"><a href="#short-info-tab${meeting.id}">Информация</a></li>
                            <li class="tab"><a href="#info-tab${meeting.id}">Описание</a></li>
                            <li class="tab"><a href="#participants-tab${meeting.id}">Участники</a></li>
                        </ul>
                    </div>

                    <div class="card-content white" style="width: 102.5%; margin-left: -1.25%;">
                        <div id="short-info-tab${meeting.id}">
                            <div class="row">
                                <p class="col s4">Организатор :</p>
                                <p class="col s4">${meeting.author}</p>
                            </div>
                        </div>
                        <div id="info-tab${meeting.id}">
                            ${meeting.content}
                        </div>
                        <div id="participants-tab${meeting.id}">
                            <p>PARTICIPANTS</p>
                        </div>
                    </div>
                </div>

            </c:forEach>

        </div>
    </div>
</div>
