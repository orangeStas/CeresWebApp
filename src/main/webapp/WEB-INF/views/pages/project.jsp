<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 3/25/2017
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h3>${project.title}</h3>
    <div class="row">
        <div class="col s6">
            <div class="card teal darken-1">
                <div class="card-content white-text">
                    <span class="card-title">Описание</span>
                    <p>${project.description}</p>
                </div>
            </div>
        </div>
        <div class="col s6">

            <h5>Тэги:</h5>

            <c:forEach var="tag" items="${project.tags}">
                <div class="chip">
                        ${tag.name}
                </div>
            </c:forEach>

            <h5>Дополнительная информация:</h5>
            <ul class="collapsible" data-collapsible="accordion">
                <li>
                    <div class="collapsible-header"><i
                            class="material-icons">perm_identity</i>Автор: ${project.author.name} ${project.author.surname}
                    </div>
                    <div class="collapsible-body">
                        <p>Университет: ${project.author.speciality.faculty.university.name}</p>
                        <p>Факультет: ${project.author.speciality.faculty.name}</p>
                        <p>Cпециальность: ${project.author.speciality.name}</p>
                    </div>
                </li>
                <li>
                    <div class="collapsible-header"><i class="material-icons">supervisor_account</i>Количество
                        участников: ${fn:length(project.participants) + 1}</div>
                    <div class="collapsible-body">
                        <p>Максимальное количество участников: ${project.countParticipants}</p>
                    </div>
                </li>
                <li>
                    <div class="collapsible-header"><i class="material-icons">info</i>Репозиторий</div>
                    <div class="collapsible-body">
                        <p>
                            <a href="${project.repositoryUrl}">${project.repositoryUrl}</a>
                        </p>
                    </div>
                </li>
            </ul>

            <c:if test="${userInProject}">

                <a href="/openChat/${project.id}" class="right btn waves-effect waves-light" type="submit" name="action">Чат
                    <i class="material-icons right">chat</i>
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
</div>
