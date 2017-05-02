<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Partners</title>
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
                        <span class="card-title">Partners</span>
                        <c:if test="${not empty partnerList}">
                            <table class="highlight teal-text bordered">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Address</th>
                                    <th>Phone</th>
                                    <th>Contact person</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty partnerList}">
                                    <c:forEach var="partner" items="${partnerList}">
                                        <tr>
                                            <th>${partner.id}</th>
                                            <th>${partner.name}</th>
                                            <th>${partner.address}</th>
                                            <th>${partner.phone}</th>
                                            <th>${partner.contactPerson.name}</th>
                                            <th>
                                                <a class="btn waves-effect waves-light teal" href="/admin/partners/edit/${partner.id}"><i
                                                        class="material-icons">mode_edit</i></a>
                                            </th>
                                            <th>
                                                <a class="btn waves-effect waves-light red" href="/admin/partners/delete/${partner.id}"><i
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
                            <a class="btn waves-effect waves-light teal right" href="/admin/partners/new">Добавить</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
