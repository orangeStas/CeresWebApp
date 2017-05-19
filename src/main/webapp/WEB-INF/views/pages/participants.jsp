<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 10/26/2016
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row container">
    <h3>Партнёры проекта</h3>
    <ul class="collapsible popout" data-collapsible="accordion">
        <c:forEach var="participants" items="${participantsList}" varStatus="loop">
        <li>
            <div class="collapsible-header">
                <div class="row">
                    <div class="col s8 offset-s1">
                        <b>${participants.name}</b><br>
                        <b>Сайт организации :</b> <a href="${participants.site}">${participants.site}</a><br>
                        <b>Контактное лицо организации :</b> ${contactPersonsList[loop.index].name}
                    </div>
                    <img src="${pageContext.request.contextPath}/files/${participants.imageFileName}" alt="" class="col s2">
                </div>
            </div>
            <div class="collapsible-body">
                <div class="row">
                    <h5 class="col offset-s1 s5">Контактное лицо</h5>
                    <h5 class="col offset-s1 s5">Об организации</h5>
                </div>
                <div class="row">
                    <img src="${pageContext.request.contextPath}/files/${contactPersonsList[loop.index].imageFileName}" alt="" class="col s2 offset-s1">
                    <div class="col s4">
                        <br><b>Ф.И.О. :</b> ${contactPersonsList[loop.index].name}<br>
                        <b>Должность :</b> ${contactPersonsList[loop.index].position}<br>
                        <b>Адрес :</b> ${contactPersonsList[loop.index].address}<br>
                        <b>Телефоны :</b> ${contactPersonsList[loop.index].phone}
                    </div>
                    <div class="col s4">
                        <br><b>Адрес организации :</b> ${participants.address}<br>
                        <b>Телефоны организации :</b> ${participants.phone}
                    </div>
                </div>
            </div>
        </li>
        </c:forEach>
    </ul>
</div>