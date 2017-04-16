<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wowru
  Date: 4/12/2017
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col s12">
            <div class="card teal darken-1 hoverable">
                <div class="card-content white-text">
                    <div class="row">
                        <div class="col s3">
                            <img width="230" style="margin-top: 20px;" src="https://upload.wikimedia.org/wikipedia/commons/9/9a/%D0%9D%D0%B5%D1%82_%D1%84%D0%BE%D1%82%D0%BE.png" alt="profile-image" />
                        </div>
                        <div class="col s9">
                            <h4>${student.surname} ${student.name} ${student.middleName}</h4>

                            <div>
                                <p class="row"><b class="col s3">ВУЗ:</b> ${student.speciality.faculty.university.name}</p>
                                <p class="row"><b class="col s3">Факультет:</b> ${student.speciality.faculty.name}</p>
                                <p class="row"><b class="col s3">Специальность:</b> ${student.speciality.name}</p>
                            </div>
                            <div>
                                <h5>Контакты</h5>
                                <p class="row"><b class="col s3">E-mail:</b> ${student.user.mail}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col s6">
            <div class="card white hoverable">
                <div class="card-content">
                    <c:if test="${not empty student.courseWorks}">
                        <h4 class="teal-text">Курсовые работы</h4>

                        <c:forEach var="courseWork" items="${student.courseWorks}">
                            <div class="card teal darken-1 hoverable">
                                <div class="card-content">
                                    <span class="card-title white-text">
                                        ${courseWork.topic}
                                    </span>
                                    <p class="white-text" style="margin-top: 10px">
                                        ${courseWork.statement}
                                    </p>
                                </div>
                                <div class="card-action">
                                    <a href="#">Подробнее...</a>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>

                    <c:if test="${empty student.courseWorks}">
                        <h4 class="teal-text">Нет загруженных работ</h4>
                    </c:if>
                </div>
            </div>
        </div>

        <div class="col s6">
            <div class="card white hoverable">
                <div class="card-content">
                    <c:if test="${not empty projects}">
                        <h4 class="teal-text">Активные проекты</h4>

                        <c:forEach var="project" items="${projects}">
                            <div class="card teal darken-1 hoverable">
                                <div class="card-content">
                                    <span class="card-title white-text">
                                            ${project.title}
                                    </span>
                                    <p class="white-text" style="margin-top: 10px">
                                            ${project.countParticipants}
                                    </p>
                                </div>
                                <div class="card-action">
                                    <a href="/education/project/${project.id}">Проект</a>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>

                    <c:if test="${empty projects}">
                        <h4 class="teal-text">Нет активных проектов</h4>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>