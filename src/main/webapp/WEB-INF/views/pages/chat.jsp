<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 3/26/2017
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">

    <div class="row" style="margin-top: 10px;">
        <div class="col s12">
            <h4 style="display: inline">Чат: </h4>
            <h4 style="display: inline" class="teal-text text-darken-1">${projectName}</h4>
        </div>
    </div>
    <input type="hidden" id="from" placeholder="Choose a nickname" value="${student.name}"/>
    <input type="hidden" id="chatId" value="${chatId}">
    <input type="hidden" id="studentId" value="${student.id}">

    <div class="row">
        <div class="col s12">
            <button class="btn waves-effect waves-light" id="disconnect" disabled="disabled" onclick="disconnect();">
                Покинуть
            </button>
        </div>
    </div>

    <div class="row">
        <div class="col s12" id="conversationDiv" style="height: 45%; margin-bottom: 0!important; overflow-y: scroll; overflow-x: auto">
            <ul class="collection" id="chat_collection">
                <c:forEach var="message" items="${messages}">
                    <li class="collection-item" style="margin-top: 5px;">
                        <span class="title">${message.student.name}: </span>
                        <c:if test="${message.student.id eq student.id}">
                            <div class="chip teal lighten-2 white-text">${message.message}</div>
                        </c:if>
                        <c:if test="${message.student.id ne student.id}">
                            <div class="chip">${message.message}</div>
                        </c:if>
                        <a class="secondary-content"><fmt:formatDate pattern="HH:mm" value="${message.time}"/></a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="input-field col s6">
            <textarea type="text" id="text" maxlength="250" class="materialize-textarea" placeholder="Write a message..." style="padding-top: 0!important; margin-bottom: 0!important;"></textarea>
        </div>

    </div>
    <div class="row">
        <div class="col s6">
            <button class="btn waves-effect waves-light right" id="sendMessage" onclick="sendMessage();">Отправить
                <i class="material-icons right">send</i></button>
        </div>

    </div>
</div>