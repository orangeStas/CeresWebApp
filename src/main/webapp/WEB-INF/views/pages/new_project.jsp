<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 3/25/2017
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h3>Новый проект</h3>

    <form:form method="post" action="${pageContext.request.contextPath}/education/project/create" modelAttribute="project" commandName="project" cssclass="col s12">
        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">label</i>
                <form:input path="title" required="required" type="text" cssclass="validate"
                    id="titleId" autfocus="true"/>
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
                <form:select path="tags" multiple="true" required="required" id="tagsId">
                    <form:option value="тэги" disabled="true"/>
                    <form:options items="${tags}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>

            <div class="input-field col s4">
                <i class="material-icons prefix">supervisor_account</i>
                <form:input path="countParticipants" type="number" cssClass="validate" required="required"
                            id="participantsId" placeholder="Колличество участников проекта"/>
                <label for="participantsId">Количество участников</label>
            </div>

            <div class="input-field col s4">
                <i class="material-icons prefix">description</i>
                <form:input path="repositoryUrl" type="text" cssClass="validate" required="required"
                    id="repId" placeholder="Ссылка на репозиторий (если есть)"/>
                <label for="repId">Репозиторий</label>
            </div>
        </div>

        <button class="right btn waves-effect waves-light" type="submit" name="action">Создать
            <i class="material-icons right">send</i>
        </button>

    </form:form>
</div>
