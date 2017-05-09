<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton Shulha
  Date: 01.05.2017
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
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
                        <span class="card-title">Users</span>
                        <c:if test="${not empty studentList}">
                            <table class="highlight teal-text bordered">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Middle name</th>
                                    <th>Surname</th>
                                    <th>Specialty</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty studentList}">
                                    <c:forEach var="student" items="${studentList}">
                                        <tr>
                                            <th>${student.id}</th>
                                            <th>${student.name}</th>
                                            <th>${student.middleName}</th>
                                            <th>${student.surname}</th>
                                            <th>${student.speciality.name}</th>
                                            <th>
                                                <a class="btn waves-effect waves-light teal" href="/admin/users/edit/${student.id}"><i
                                                        class="material-icons">mode_edit</i></a>
                                            </th>
                                            <th>
                                                <a class="btn waves-effect waves-light red" href="/admin/users/delete/${student.id}"><i
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
                            <a class="btn waves-effect waves-light teal right" href="/admin/users/new">Добавить</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
