<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton Shulha
  Date: 02.05.2017
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact persons</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col s12">
            <div class="card darken-1 hoverable">
                <div class="card-content teal-text">
                    <div class="card-content">
                        <span class="card-title">Contact persons</span>
                        <div class="row">
                            <form:form method="post" action="${pageContext.request.contextPath}/admin/contactpersons/save"
                                       modelAttribute="person" commandName="person" cssclass="col s12" enctype="multipart/form-data">
                                <form:hidden path="id"/>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="name" required="required" type="text" cssclass="validate"
                                                    id="name" autfocus="true"/>
                                        <label for="name">Name</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="address" required="required" type="text" cssclass="validate"
                                                    id="address" autfocus="true"/>
                                        <label for="address">Address</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="phone" required="required" type="text"
                                                    id="phone" autfocus="true"/>
                                        <label for="phone">Phone</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="position" required="required" type="text" cssclass="validate"
                                                    id="position" autfocus="true"/>
                                        <label for="position">Position</label>
                                    </div>
                                </div>
                                <div class="file-field input-field col s6">
                                    <div class="btn">
                                        <span>File</span>
                                        <input type="file" name="sourceFile" id="sourceInput" multiple>
                                    </div>
                                    <div class="file-path-wrapper">
                                        <input class="file-path validate" type="text" name="imageName" value="${requestScope.imageName}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:checkbox path="active" id="active"/>
                                        <label for="active">Active</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:button class="btn waves-effect waves-light right" type="submit" name="action">Сохранить
                                            <i class="material-icons right">send</i>
                                        </form:button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
