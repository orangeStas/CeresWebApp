<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wowru
  Date: 4/12/2017
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="${requestScope['javax.servlet.forward.request_uri']}" var="currUrl"/>

<div class="container">
    <div class="row">
        <div class="col s12">
            <div class="card teal darken-1 hoverable">
                <div class="card-content white-text">
                    <div class="row">
                        <div class="col s3">

                        <c:if test="${currUrl ne '/education/profile/-1'}">
                            <c:if test="${not empty student.imageName}">
                                <img width="230" height="200" class="circle" style="margin-top: 20px;" src="${pageContext.request.contextPath}/files/${student.imageName}" alt="profile-image" />
                            </c:if>

                            <c:if test="${empty student.imageName}">
                                <img width="230" height="200" class="circle" style="margin-top: 20px;" src="https://upload.wikimedia.org/wikipedia/commons/9/9a/%D0%9D%D0%B5%D1%82_%D1%84%D0%BE%D1%82%D0%BE.png" alt="profile-image" />
                            </c:if>
                        </c:if>

                        <c:if test="${currUrl eq '/education/profile/-1'}">
                            <a href="#image-changer">
                                <c:if test="${not empty student.imageName}">
                                    <img width="230" height="200" class="circle" style="margin-top: 20px;" src="${pageContext.request.contextPath}/files/${student.imageName}" alt="profile-image" />
                                </c:if>

                                <c:if test="${empty student.imageName}">
                                    <img width="230" height="200" class="circle" style="margin-top: 20px;" src="https://upload.wikimedia.org/wikipedia/commons/9/9a/%D0%9D%D0%B5%D1%82_%D1%84%D0%BE%D1%82%D0%BE.png" alt="profile-image" />
                                </c:if>
                            </a>
                        </c:if>

                        </div>
                        <div class="col s9">
                            <h4>${student.surname} ${student.name} ${student.middleName}</h4>

                            <div>
                                <p class="row"><b class="col s3">ВУЗ:</b> ${student.speciality.faculty.university.name}</p>
                                <p class="row"><b class="col s3">Факультет:</b> ${student.speciality.faculty.name}</p>
                                <p class="row"><b class="col s3">Специальность:</b> ${student.speciality.name}</p>
                            </div>
                            <br>
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
                                        Тема работы: "${courseWork.topic}"
                                    </span>
                                    <p class="white-text" style="margin-top: 10px">
                                        Дата добаления:  <fmt:formatDate type="both"
                                                         dateStyle="short" timeStyle="short"
                                                         value="${courseWork.modificationDate}" />
                                    </p>
                                </div>
                                <div class="card-action">
                                    <a href="/files/${courseWork.statement}">Заявление</a>
                                    <a href="/files/${courseWork.source}" class="right">Исходный код</a>
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
                                            ${project.description}
                                    </p>
                                </div>
                                <div class="card-action">
                                    <a href="/education/project/${project.id}">Страница проекта</a>
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

<!-- Modal view -->

<div id="image-changer" style="width: 25%" class="modal">
    <form action="${pageContext.request.contextPath}/education/profile/changeImage" enctype="multipart/form-data" method="post">
        <div class="modal-content">
            <h4>Изменить фотографию</h4>
            <c:if test="${not empty student.imageName}">
                <img src="${pageContext.request.contextPath}/files/${student.imageName}" alt="image" id="blah" style="width: 100%"/>
            </c:if>
            <c:if test="${empty student.imageName}">
                <img src="https://upload.wikimedia.org/wikipedia/commons/9/9a/%D0%9D%D0%B5%D1%82_%D1%84%D0%BE%D1%82%D0%BE.png" alt="image" id="blah" style="width: 100%"/>
            </c:if>
        </div>
        <div class="modal-footer">
            <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Отмена</a>
            <button type="submit" name="action" class="modal-action modal-close waves-effect waves-green btn-flat">Ок</button>
            <span class="file-field left" style="margin-top: -6px; margin-left: 20px;">
                <div class="btn modal-action waves-effect waves-green btn-flat">
                    <span>Файл</span>
                    <input type="file" onchange="readURL(this);" name="sourceFile" />
                </div>
            </span>
        </div>
    </form>
</div>