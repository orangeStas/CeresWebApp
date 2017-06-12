<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 10/26/2016
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="card-panel z-depth-2">
        <div class="card-title cyan darken-4 green-header">
            <h3 class="white-text">Партнëры проекта</h3>
        </div>

        <div class="card-content">
            <ul class="collapsible popout clear-list" data-collapsible="accordion">
                <c:forEach var="participants" items="${participantsList}" varStatus="loop">
                    <li class="clear-list">
                        <div class="collapsible-header">
                            <div class="row" style="margin-left: 40px;">
                                <div class="col s8">
                                    <h5>${participants.name}</h5>
                                    <div class="row" style="margin-bottom: 0; margin-top: 0;">
                                        <p class="col s4" style="margin-bottom: 0; margin-top: 0;"><b>Сайт организации:</b></p>
                                        <p class="col s8" style="margin-bottom: 0; margin-top: 0;"><a href="${participants.site}">${participants.site}</a></p>
                                    </div>

                                    <div class="row" style="margin-bottom: 0; margin-top: 0;">
                                        <p class="col s4" style="margin-bottom: 0; margin-top: 0;"><b>Адрес организации:</b></p>
                                        <p class="col s8" style="margin-bottom: 0; margin-top: 0;">${participants.address}</p>
                                    </div>

                                    <div class="row" style="margin-bottom: 0; margin-top: 0;">
                                        <p class="col s4" style="margin-bottom: 0; margin-top: 0;"><b>Контактное лицо:</b></p>
                                        <p class="col s8" style="margin-bottom: 0; margin-top: 0;">${contactPersonsList[loop.index].name}</p>
                                    </div>
                                </div>
                                <div class="col s4">
                                    <c:if test="${not empty participants.imageFileName}">
                                        <img width="200" height="200" class="circle" style="margin-top: 20px;" src="${pageContext.request.contextPath}/files/${participants.imageFileName}" alt="profile-image" />
                                    </c:if>

                                    <c:if test="${empty participants.imageFileName}">
                                        <img width="200" height="200" class="circle" style="margin-top: 20px;" src="resources/images/no_photo.png" alt="profile-image" />
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="collapsible-body">
                            <div class="row" style="margin-left: 40px;">
                                <div class="col s3">
                                    <c:if test="${not empty contactPersonsList[loop.index].imageFileName}">
                                        <img width="200" height="200" class="circle" style="margin-top: 20px;" src="${pageContext.request.contextPath}/files/${contactPersonsList[loop.index].imageFileName}" alt="profile-image" />
                                    </c:if>

                                    <c:if test="${empty contactPersonsList[loop.index].imageFileName}">
                                        <img width="200" height="200" class="circle" style="margin-top: 20px;" src="resources/images/no_photo.png" alt="profile-image" />
                                    </c:if>
                                </div>

                                <div class="col s9" style="margin-top: 30px;">
                                    <div class="row">
                                        <p class="col s2"><b>Ф.И.О.:</b></p>
                                        <p class="col s10">${contactPersonsList[loop.index].name}</p>
                                    </div>
                                    <div class="row">
                                        <p class="col s2"><b>Должность:</b></p>
                                        <p class="col s10">${contactPersonsList[loop.index].position}</p>
                                    </div>
                                    <div class="row">
                                        <p class="col s2"><b>Адрес:</b></p>
                                        <p class="col s10">${contactPersonsList[loop.index].address}</p>
                                    </div>
                                    <div class="row">
                                        <p class="col s2"><b>Телефоны:</b></p>
                                        <p class="col s10">${contactPersonsList[loop.index].phone}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

    </div>
</div>