<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tags</title>
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
                        <span class="card-title">Tags</span>
                        <c:if test="${not empty tagList}">
                            <table class="highlight teal-text bordered">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty tagList}">
                                    <c:forEach var="tag" items="${tagList}">
                                        <tr>
                                            <th>${tag.id}</th>
                                            <th>${tag.name}</th>
                                            <th>
                                                <a class="btn waves-effect waves-light teal" href="/admin/tags/edit/${tag.id}"><i
                                                        class="material-icons">mode_edit</i></a>
                                            </th>
                                            <th>
                                                <a class="btn waves-effect waves-light red" href="/admin/tags/delete/${tag.id}"><i
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
                            <a class="btn waves-effect waves-light teal right" href="/admin/tags/new">Добавить</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
