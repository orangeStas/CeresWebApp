<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton Shulha
  Date: 07.05.2017
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col s12">
            <div class="card darken-1 hoverable">
                <div class="card-content teal-text">
                    <div class="card-content">
                        <span class="card-title">User</span>
                        <div class="row">
                            <form:form method="post" action="${pageContext.request.contextPath}/admin/users/save"
                                       modelAttribute="student" commandName="student" cssclass="col s12">
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
                                        <form:input path="middleName" required="required" type="text" cssclass="validate"
                                                    id="middleName" autfocus="true"/>
                                        <label for="middleName">Middle name</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="surname" required="required" type="text" cssclass="validate"
                                                    id="surname" autfocus="true"/>
                                        <label for="surname">Last name</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="imageName" type="text" cssclass="validate"
                                                    id="imageName" autfocus="true"/>
                                        <label for="imageName">Image</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:select path="speciality" id="speciality" multiple="false">
                                            <form:options  items="${specialtyList}" itemValue="id" itemLabel="name"/>
                                        </form:select>
                                        <label for="speciality">Specialty</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:select path="user" id="user" multiple="false">
                                            <form:options  items="${userList}" itemValue="id" itemLabel="mail"/>
                                        </form:select>
                                        <label for="user">User</label>
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
