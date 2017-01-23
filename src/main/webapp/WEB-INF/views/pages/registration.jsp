<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 11/20/2016
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(document).ready(function () {
        $('#university').on('change', function (e) {

            var university_id = e.target.value;

            $.get('/ajax-faculty?university_id=' + university_id, function(data){

                $('#speciality').empty();
                var $facultyDropdown = $('#faculty').empty();

                $.each(data, function(index, facultyObj){

                    $facultyDropdown.append(
                            $("<option></option>")
                                    .attr("value",facultyObj.id)
                                    .text(facultyObj.name)
                    );
                });

                $facultyDropdown.trigger('facultyChanged');
            });

            $('select').on('facultyChanged', function() {
                $(this).material_select();
            });
        });

        $('#faculty').on('change', function (e) {

            var faculty_id = e.target.value;

            $.get('/ajax-speciality?faculty_id=' + faculty_id, function(data){

                var $specialityDropdown = $('#speciality_id').empty();

                $.each(data, function(index, specialityObj){

                    $specialityDropdown.append(
                            $("<option></option>")
                                    .attr("value",specialityObj.id)
                                    .text(specialityObj.name)
                    );
                });

                $specialityDropdown.trigger('specialityChanged');
            });

            $('select').on('specialityChanged', function() {
                $(this).material_select();
            });
        });
    });
</script>

<div class="container">
    <h3>Регистрация</h3>

    <form:form method="POST" modelAttribute="registrationForm" class="col s12">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />

        <div class="row">
        <spring:bind path="user.email">
                <div class="input-field col s12 ${status.error ? 'has-error' : ''}">
                    <i class="material-icons prefix">email</i>
                    <form:input type="email" path="user.email" class="validate"
                                placeholder="Email" id="loginInput" autofocus="true" ></form:input>
                    <form:errors path="user.email"></form:errors>
                    <label for="loginInput">Email</label>
                </div>
        </spring:bind>
        </div>

        <div class="row">
        <spring:bind path="user.password">
            <div class="input-field col s6 ${status.error ? 'has-error' : ''}">
                <i class="material-icons prefix">vpn_key</i>
                <form:input type="password" path="user.password" class="form-control"
                            placeholder="Пароль" id="passwordInput"></form:input>
                <form:errors path="user.password"></form:errors>
                <label for="passwordInput">Пароль</label>
            </div>
        </spring:bind>

        <spring:bind path="user.passwordConfirm">
            <div class="input-field col s6 ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="user.passwordConfirm" class="form-control"
                            placeholder="Повторите пароль" id="secondPasswordInput"></form:input>
                <form:errors path="user.passwordConfirm"></form:errors>
                <label for="secondPasswordInput">Повторите пароль</label>
            </div>
        </spring:bind>
        </div>

        <div class="row">
        <spring:bind path="student.surname">
            <div class="input-field col s4 ${status.error ? 'has-error' : ''}">
                <i class="material-icons prefix">account_circle</i>
                <form:input type="text" path="student.surname" class="validate"
                            placeholder="Фамилия" id="stSurnameInput"></form:input>
                <form:errors path="student.surname"></form:errors>
                <label for="stSurnameInput">Фамилия</label>
            </div>
        </spring:bind>

        <spring:bind path="student.name">
            <div class="input-field col s4 ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="student.name" class="validate"
                            placeholder="Имя" id="stNameInput"></form:input>
                <form:errors path="student.name"></form:errors>
                <label for="stNameInput">Имя</label>
            </div>
        </spring:bind>

        <spring:bind path="student.middleName">
            <div class="input-field col s4 ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="student.middleName" class="validate"
                            placeholder="Отчество" id="stMiddleNameInput"></form:input>
                <form:errors path="student.middleName"></form:errors>
                <label for="stMiddleNameInput">Отчество</label>
            </div>
        </spring:bind>
        </div>

        <div class="input-field">
            <i class="material-icons prefix">list</i>
            <select name = "university" id="university">
                <option value="" selected>Choose your option</option>
                <c:forEach var="univer" items="${universities}">
                    <option value="${univer.id}">${univer.name}</option>
                </c:forEach>
            </select>
            <label for="university">Выберите университет</label>
        </div>

        <div class="input-field">
            <i class="material-icons prefix">list</i>
            <select id="faculty">
                <option value="" selected>Choose your option</option>
            </select>
            <label for="faculty">Выберите факультет</label>
        </div>

        <spring:bind path="student.speciality">
            <div class="input-field">
                <i class="material-icons prefix">list</i>
                <form:select path="student.speciality" id="speciality">
                    <option value="" selected>Choose your option</option>
                </form:select>
                <label for="speciality">Выберите специальность</label>
            </div>
        </spring:bind>

        <button class="btn waves-effect waves-light right" type="submit" name="action">Принять
            <i class="material-icons right">send</i>
        </button>
    </form:form>

</div>
<!-- /container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>