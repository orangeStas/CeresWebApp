<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton Shulha
  Date: 01.05.2017
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menus</title>
</head>
<body>
<div class="wrapper">

</div>
<div class="container">
    <div class="row">
        <div class="col s12">
            <div class="card darken-1 hoverable">
                <div class="card-content teal-text">
                    <div class="card-content">
                        <span class="card-title">Menu items</span>
                        <c:if test="${not empty menuList}">
                            <table class="highlight teal-text bordered">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Active</th>
                                    <th>Weight</th>
                                    <th>Title</th>
                                    <th>URL</th>
                                    <th>Icon</th>
                                    <th>Position</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty menuList}">
                                    <c:forEach var="menu" items="${menuList}">
                                        <tr>
                                            <th>${menu.id}</th>
                                            <th>${menu.active}</th>
                                            <th>${menu.weight}</th>
                                            <th>${menu.title}</th>
                                            <th>${menu.url}</th>
                                            <th>${menu.icon}</th>
                                            <th>${menu.position}</th>
                                            <th>
                                                <a class="btn waves-effect waves-light teal" href="/admin/menus/edit/${menu.id}"><i
                                                        class="material-icons">mode_edit</i></a>
                                            </th>
                                            <th>
                                                <a class="btn waves-effect waves-light red" href="/admin/menus/delete/${menu.id}"><i
                                                        class="material-icons">delete</i>
                                                </a>
                                            </th>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                </tbody>
                            </table>
                        </c:if>
                        <div class="card-action">
                            <a class="btn waves-effect waves-light teal right" href="/admin/menus/new">Добавить</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
