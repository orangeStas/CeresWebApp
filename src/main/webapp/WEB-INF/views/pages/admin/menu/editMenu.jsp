<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton Shulha
  Date: 02.05.2017
  Time: 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit menu</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col s12">
            <div class="card darken-1 hoverable">
                <div class="card-content teal-text">
                    <div class="card-content">
                        <span class="card-title">Menu items</span>
                        <div class="row">
                            <form:form method="post" action="${pageContext.request.contextPath}/admin/menus/save"
                                       modelAttribute="menuItem" commandName="menuItem" cssclass="col s12">
                                <form:hidden path="id"/>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="title" required="required" type="text" cssclass="validate"
                                                    id="title" autfocus="true"/>
                                        <label for="position">Title</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="weight" required="required" type="number" cssclass="validate"
                                                    id="weight" autfocus="true"/>
                                        <label for="weight">Weight</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="url" required="required" type="text" cssclass="validate"
                                                    id="url" autfocus="true"/>
                                        <label for="url">Url</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="icon" required="required" type="text" cssclass="validate"
                                                    id="icon" autfocus="true"/>
                                        <label for="icon">Icon</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="position" required="required" type="text" cssclass="validate"
                                                    id="position" autfocus="true"/>
                                        <label for="position">Position</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:checkbox value="true" path="active" id="active"/>
                                        <label for="active">Active</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:button class="btn waves-effect waves-light right  " type="submit" name="action">Сохранить
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
