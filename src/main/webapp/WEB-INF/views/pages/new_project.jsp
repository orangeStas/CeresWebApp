<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 3/25/2017
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="${requestScope['javax.servlet.forward.request_uri']}" var="currUrl"/>

<div class="container">

    <c:choose>
        <c:when test="${fn:contains(currUrl, 'Edit')}">
            <c:set var="projectAction" value="${pageContext.request.contextPath}/education/project/update"/>
            <h3>Изменить проект</h3>
        </c:when>
        <c:otherwise>
            <h3>Новый проект</h3>
            <c:set var="projectAction" value="${pageContext.request.contextPath}/education/project/create"/>
        </c:otherwise>
    </c:choose>


    <form:form method="post" action="${projectAction}" modelAttribute="project" commandName="project" cssclass="col s12">

        <input type="hidden" name="projectId" value="${project.id}">

        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">label</i>
                <form:input path="title" required="required" type="text" cssclass="validate"
                    id="titleId" maxlength="45" autfocus="true"/>
                <label for="titleId">Название проекта</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <i class="material-icons prefix">subject</i>
                <form:textarea path="description" cssClass="materialize-textarea" id="descId" required="required"/>
                <label for="descId">Описание</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s4">
                <i class="material-icons prefix">toc</i>
                <form:select path="tags" multiple="true" id="tagsId">
                    <form:options items="${tags}" itemValue="id" itemLabel="name"/>
                </form:select>
                <label class="active">Тэги</label>
            </div>

            <div class="input-field col s4">
                <i class="material-icons prefix">supervisor_account</i>
                <form:input path="countParticipants" type="number" min="0" cssClass="validate" required="required"
                            id="participantsId" placeholder="Колличество участников проекта"/>
                <label for="participantsId">Количество участников</label>
            </div>

            <div class="input-field col s4">
                <i class="material-icons prefix">description</i>
                <form:input path="repositoryUrl" type="text" maxlength="255" cssClass="validate"
                    id="repId" placeholder="Ссылка на репозиторий (если есть)"/>
                <label for="repId">Репозиторий</label>
            </div>
        </div>

        <button class="right btn waves-effect waves-light" type="submit" name="action">Сохранить
            <i class="material-icons right">send</i>
        </button>

    </form:form>
</div>
