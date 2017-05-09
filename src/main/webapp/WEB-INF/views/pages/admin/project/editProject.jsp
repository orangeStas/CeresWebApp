<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton Shulha
  Date: 03.05.2017
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit project</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col s12">
            <div class="card darken-1 hoverable">
                <div class="card-content teal-text">
                    <div class="card-content">
                        <span class="card-title">Partner</span>
                        <div class="row">
                            <form:form method="post" action="${pageContext.request.contextPath}/admin/projects/save"
                                       modelAttribute="project" commandName="project" cssclass="col s12">
                                <form:hidden path="id"/>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="title" required="required" type="text" cssclass="validate"
                                                    id="title" autfocus="true"/>
                                        <label for="title">Title</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="countParticipants" required="required" type="number" cssclass="validate"
                                                    id="countParticipants" autfocus="true"/>
                                        <label for="countParticipants">Participants count</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:textarea cssClass="materialize-textarea" path="description" type="text" id="description" autfocus="true"/>
                                        <label for="description">Description</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:select path="author" id="author">
                                            <form:options cssClass="left circle" items="${studentList}" itemValue="id" itemLabel="surname" data-icon="imageName"/>
                                        </form:select>
                                        <label for="author">Author</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:select path="participants" id="participants" multiple="true">
                                            <form:options cssClass="left circle" items="${studentList}" itemValue="id" itemLabel="surname" data-icon="imageName"/>
                                        </form:select>
                                        <label for="participants">Participants</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:input path="repositoryUrl"  type="text" cssclass="validate"
                                                    id="repositoryUrl" autfocus="true"/>
                                        <label for="repositoryUrl">Repository URL</label>
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
