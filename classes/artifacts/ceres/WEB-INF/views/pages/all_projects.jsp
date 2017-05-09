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
    <div class="row" style="margin-top: 30px">
        <div class="col s12">
            <div class="card-panel grey lighten-5">

                <div class="card-title">
                    <h3 class="teal-text text-darken-1">Научные проекты</h3>
                </div>

                <c:forEach var="project" items="${projects}">
                    <div class="card teal darken-1 hoverable">
                        <div class="card-content white-text" style="padding-bottom: 0">
                            <h5><a class="white-text" href="/education/project/${project.id}">${project.title}</a></h5>
                        </div>

                        <div class="card-tabs">
                            <ul class="tabs tabs-fixed-width tabs-transparent" style="padding-left: 0">
                                <li class="tab"><a class="active" href="#description${project.id}">Описание</a></li>
                                <li class="tab"><a href="#participants${project.id}">Участники</a></li>
                                <li class="tab"><a href="#info${project.id}">Информация</a></li>
                            </ul>
                        </div>

                        <div class="card-content white">
                            <div id="description${project.id}">
                                <p>${project.description}</p>
                                <c:forEach var="tag" items="${project.tags}">
                                    <div class="chip" style="margin-top: 7px">${tag.name}</div>
                                </c:forEach>
                            </div>

                            <div id="participants${project.id}">
                                <c:forEach var="student" items="${project.participants}">
                                    <div class="card teal darken-3 hoverable">
                                        <div class="card-content">
                                            <span class="card-title white-text">
                                                ${student.name} ${student.surname}
                                            </span>
                                            <p class="white-text" style="margin-top: 10px">
                                                    ${student.speciality.faculty.university.name}
                                            </p>
                                            <p class="white-text" style="margin-top: 10px">
                                                    ${student.speciality.faculty.name}
                                            </p>
                                            <p class="white-text" style="margin-top: 10px">
                                                    ${student.speciality.name}
                                            </p>
                                        </div>
                                        <div class="card-action">
                                            <a href="/education/profile/${student.id}">Профиль</a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>

                            <div id="info${project.id}">
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

</div>
