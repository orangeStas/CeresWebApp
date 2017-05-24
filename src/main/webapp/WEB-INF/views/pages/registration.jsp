<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 11/20/2016
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h3>Регистрация</h3>

    <form:form method="POST" action="/registration" modelAttribute="registrationForm" commandName="registrationForm"
               class="col s12">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

        <spring:bind path="user.mail">
            <div class="row">
                <div class="input-field col s12 ${status.error ? 'has-error' : ''}">
                    <i class="material-icons prefix">email</i>
                    <form:input type="email" required="required" path="user.mail" class="validate"
                                placeholder="Email" maxlength="255" id="loginInput" autofocus="true"/>
                    <form:errors path="user.mail"></form:errors>
                    <label for="loginInput">Email</label>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="user.password">
            <div class="row">
                <div class="input-field col s6 ${status.error ? 'has-error' : ''}">
                    <i class="material-icons prefix">vpn_key</i>
                    <form:input type="password" required="required" path="user.password" class="form-control"
                                placeholder="Пароль" maxlength="60" pattern=".{5,10}" title="от 5 до 10 символов" id="passwordInput"></form:input>
                    <form:errors path="user.password"></form:errors>
                    <label for="passwordInput">Пароль</label>
                </div>

                <div class="input-field col s6 ${status.error ? 'has-error' : ''}">
                    <form:input type="password" required="required" path="user.passwordConfirm" class="form-control"
                                placeholder="Повторите пароль" id="secondPasswordInput"></form:input>
                    <form:errors path="user.passwordConfirm"></form:errors>
                    <label for="secondPasswordInput">Повторите пароль</label>
                </div>
            </div>
        </spring:bind>

        <div class="row">
            <div class="input-field col s4 ${status.error ? 'has-error' : ''}">
                <i class="material-icons prefix">account_circle</i>
                <form:input type="text"  required="required" maxlength="255" path="student.surname" class="validate"
                            placeholder="Фамилия" id="stSurnameInput"></form:input>
                <form:errors path="student.surname"></form:errors>
                <label for="stSurnameInput">Фамилия</label>
            </div>

            <div class="input-field col s4 ${status.error ? 'has-error' : ''}">
                <form:input type="text" required="required" maxlength="255" path="student.name" class="validate"
                            placeholder="Имя" id="stNameInput"></form:input>
                <form:errors path="student.name"></form:errors>
                <label for="stNameInput">Имя</label>
            </div>

            <div class="input-field col s4 ${status.error ? 'has-error' : ''}">
                <form:input type="text" required="required" maxlength="255" path="student.middleName" class="validate"
                            placeholder="Отчество" id="stMiddleNameInput"></form:input>
                <form:errors path="student.middleName"></form:errors>
                <label for="stMiddleNameInput">Отчество</label>
            </div>
        </div>

        <div class="input-field">
            <i class="material-icons prefix">list</i>
            <select required name="university" id="university">
                <option value="" selected></option>
                <c:forEach var="univer" items="${universities}">
                    <option value="${univer.id}">${univer.name}</option>
                </c:forEach>
            </select>
            <label for="university">Выберите университет</label>
        </div>

        <div class="input-field">
            <i class="material-icons prefix">list</i>
            <select required id="faculty">
                <option value="" selected></option>
            </select>
            <label for="faculty">Выберите факультет</label>
        </div>

        <div class="input-field">
            <i class="material-icons prefix">list</i>
            <form:select path="student.speciality.id" required="required" id="speciality">
                <option value="" selected></option>
            </form:select>
            <label for="speciality">Выберите специальность</label>
        </div>

        <button class="btn waves-effect waves-light right" type="submit" name="action">Принять
            <i class="material-icons right">send</i>
        </button>
    </form:form>

</div>
<!-- /container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function () {
        $('#university').on('change', function (e) {

            var university = e.target.value;

            $.get('/rest-education/university/faculties/' + university, function (data) {

                $('#speciality').empty();
                var $facultyDropdown = $('#faculty').empty();

                $.each(data, function (index, facultyObj) {

                    $facultyDropdown.append(
                            $("<option></option>")
                                    .attr("value", facultyObj.id)
                                    .text(facultyObj.name)
                    );
                });

                $facultyDropdown.trigger('facultyChanged');
            });

            $('select').on('facultyChanged', function () {
                $(this).material_select();
            });
        });

        $('#faculty').on('change', function (e) {

            var faculty = e.target.value;

            $.get('/rest-education/faculty/specialities/' + faculty, function (data) {

                var $specialityDropdown = $('#speciality').empty();

                $.each(data, function (index, specialityObj) {

                    $specialityDropdown.append(
                            $("<option></option>")
                                    .attr("value", specialityObj.id)
                                    .text(specialityObj.name)
                    );
                });

                $specialityDropdown.trigger('specialityChanged');
            });

            $('select').on('specialityChanged', function () {
                $(this).material_select();
            });
        });
    });
</script>