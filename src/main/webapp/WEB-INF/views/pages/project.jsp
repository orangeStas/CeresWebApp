<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 3/25/2017
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h3 class="teal-text text-darken-1">${project.title}</h3>
    <div class="row">
        <div class="col s6">
            <div class="card cyan darken-4 hoverable">
                <div class="card-content white-text">
                    <span class="card-title">Описание</span>
                    <p style="margin-top: 10px">${project.description}</p>
                </div>
                <c:if test="${pageContext.request.userPrincipal.name eq project.author.user.mail}">
                    <div class="card-action">
                        <a href="${pageContext.request.contextPath}/education/project/openEditProject/${project.id}">Редактировать</a>
                    </div>
                </c:if>
            </div>
        </div>
        <div class="col s6">

            <div class="card white hoverable">
                <div class="card-content">
                    <span class="card-title teal-text">Тэги проекта</span>
                    <c:forEach var="tag" items="${project.tags}">
                        <div class="chip">${tag.name}</div>
                    </c:forEach>
                </div>
            </div>

            <h5 class="teal-text text-darken-1">Дополнительная информация:</h5>
            <ul class="collapsible hoverable clear-list" data-collapsible="accordion">
                <li class="clear-list">
                    <div class="collapsible-header"><i
                            class="material-icons">perm_identity</i>Автор: ${project.author.name} ${project.author.surname}
                    </div>
                    <div class="collapsible-body">
                        <p>Университет: ${project.author.speciality.faculty.university.name}</p>
                        <p>Факультет: ${project.author.speciality.faculty.name}</p>
                        <p>Cпециальность: ${project.author.speciality.name}</p>
                    </div>
                </li>
                <li class="clear-list">
                    <div class="collapsible-header"><i class="material-icons">supervisor_account</i>Количество
                        участников: ${fn:length(project.participants) + 1}</div>
                    <div class="collapsible-body">
                        <p>Максимальное количество участников: ${project.countParticipants}</p>
                    </div>
                </li>
                <li class="clear-list">
                    <div class="collapsible-header"><i class="material-icons">info</i>Репозиторий</div>
                    <div class="collapsible-body">
                        <p><a href="${project.repositoryUrl}">${project.repositoryUrl}</a></p>
                    </div>
                </li>
            </ul>


            <c:if test="${userInProject}">
                <a href="/openChat/${project.id}" class="right btn btn-floating btn-large pulse" type="submit"
                   name="action"><i class="material-icons right">chat</i>
                </a>
            </c:if>

            <c:if test="${not userInProject}">
                <form:form method="post" action="${pageContext.request.contextPath}/education/project/join">
                    <input type="hidden" name="projectId" value="${project.id}">
                    <button class="right btn waves-effect waves-light" type="submit" name="action">Присоединиться
                        <i class="material-icons right">verified_user</i>
                    </button>
                </form:form>
            </c:if>
        </div>

    </div>

    <div class="row">
        <div class="col s6">

            <ul class="collection with-header hoverable">
                <h5 class="teal-text" style="padding-top: 20px;">Статус проекта</h5>
                <c:forEach var="status" items="${statuses}">
                    <li class="collection-item row zero-left-padding clear-list">
                        <span class="col s9">${status.status}</span>
                        <span class="col s3 secondary-content">
                            <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${status.time}"/>
                        </span>
                    </li>
                </c:forEach>
            </ul>

            <c:if test="${userInProject}">
                <form action="${pageContext.request.contextPath}/education/project/addStatus" method="post">
                    <input type="hidden" name="project_id" value="${project.id}">
                    <div class="input-field">
                        <input name="status_text" required type="text" maxlength="500" class="validate"
                               placeholder="Новый статус проекта">
                    </div>
                    <button class="right btn waves-effect waves-light" type="submit" name="action">Добавить
                        <i class="material-icons right">send</i>
                    </button>
                </form>
            </c:if>
        </div>

        <div class="col s6">
            <div class="card white hoverable">
                <div class="card-content">
                    <h5 class="teal-text">Состав проекта</h5>

                    <div class="card cyan darken-4 hoverable">
                        <div class="card-content">
                                <span class="card-title white-text">
                                    ${project.author.name} ${project.author.surname}
                                </span>
                            <p class="white-text" style="margin-top: 10px">
                                ${project.author.speciality.faculty.university.name}
                            </p>
                        </div>
                        <div class="card-action">
                            <a href="/education/profile/${project.author.id}">Профиль</a>
                        </div>
                    </div>

                    <c:forEach var="student" items="${project.participants}">
                        <div class="card cyan darken-4 hoverable">
                            <div class="card-content">
                                <span class="card-title white-text">
                                    ${student.name} ${student.surname}
                                </span>
                                <p class="white-text" style="margin-top: 10px">
                                        ${student.speciality.faculty.university.name}
                                </p>
                            </div>
                            <div class="card-action">
                                <a href="/education/profile/${student.id}">Профиль</a>
                                <c:if test="${pageContext.request.userPrincipal.name eq project.author.user.mail}">
                                    <a class="orange-text text-darken-2"
                                       href="/education/project/${project.id}/removeStudent/${student.id}">Исключить</a>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                    <c:if test="${userInProject && (project.author.user.mail ne pageContext.request.userPrincipal.name)}">
                        <form:form method="post" cssStyle="margin-bottom: 50px"
                                   action="${pageContext.request.contextPath}/education/project/leave">
                            <input type="hidden" name="projectId" value="${project.id}">
                            <button class="right btn red darken-1 waves-effect waves-light" type="submit" name="action">
                                Покинуть проект
                                <i class="material-icons right">not_interested</i>
                            </button>
                        </form:form>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
