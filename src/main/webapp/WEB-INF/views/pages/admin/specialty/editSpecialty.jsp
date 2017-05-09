<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton Shulha
  Date: 07.05.2017
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Specialty</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col s12">
            <div class="card darken-1 hoverable">
                <div class="card-content teal-text">
                    <div class="card-content">
                        <span class="card-title">Specialty</span>
                        <div class="row">
                            <form:form method="post" action="${pageContext.request.contextPath}/admin/specialties/save"
                                       modelAttribute="specialty" commandName="specialty" cssclass="col s12">
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
                                        <form:select path="faculty" id="faculty" multiple="false">
                                            <form:options  items="${facultyList}" itemValue="id" itemLabel="name"/>
                                        </form:select>
                                        <label for="faculty">University</label>
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
