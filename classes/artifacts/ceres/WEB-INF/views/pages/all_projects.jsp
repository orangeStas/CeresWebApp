<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 4/16/2017
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="card-panel z-depth-2">
        <div class="card-title cyan darken-4 row" style="margin-left: -1.75%; width: 103.5%; padding-left: 9%;">
            <h3 class="white-text col s9" style="margin-top: 0; margin-bottom: 0;">Научные проекты</h3>
        </div>

        <div class="card-content row">
            <c:forEach var="project" items="${projects}">
                <div class="card cyan darken-4 col s10 offset-s1 z-depth-2">
                    <div class="card-title row" style="margin-top: 25px; margin-bottom: 0px; margin-left: 1%;">
                        <h5 class="white-text col s11" style="margin-top: 5px;"><a class="white-text" href="/education/project/${project.id}">${project.title}</a></h5>
                    </div>
                    <div class="card-tabs" style="width: 102.5%; margin-left: -1.25%;">
                        <ul class="tabs tabs-fixed-width" style="padding-left: 0;">
                            <li class="tab"><a href="#info-tab${project.id}">Описание</a></li>
                            <li class="tab"><a href="#participants-tab${project.id}">Участники</a></li>
                            <li class="tab"><a href="#short-info-tab${project.id}">Информация</a></li>
                        </ul>
                    </div>

                    <div class="card-content white" style="width: 102.5%; margin-left: -1.25%;">
                        <div id="info-tab${project.id}">
                            <p>${project.description}</p>
                            <c:forEach var="tag" items="${project.tags}">
                                <div class="chip" style="margin-top: 7px">${tag.name}</div>
                            </c:forEach>
                        </div>

                        <div id="participants-tab${project.id}">
                            <c:forEach var="student" items="${project.participants}">
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
                                    <div class="row">
                                        <div class="card-action sol s12" style="padding-left: 5%;">
                                            <a href="/education/profile/${student.id}">Профиль</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <div id="short-info-tab${project.id}">
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
                                    <div class="collapsible-header"><i class="material-icons">info</i>Репозиторий
                                    </div>
                                    <div class="collapsible-body">
                                        <p><a href="${project.repositoryUrl}">${project.repositoryUrl}</a></p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
