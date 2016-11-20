<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wowru
  Date: 11/20/2016
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row container">
    <h3>Добавить работу</h3>
    <form:form cssClass="col s12" action="/addWork" modelAttribute="courseWork" method="post">

        <div class="row">

            <div class="file-field input-field col s6">
                <div class="btn">
                    <span>Файл</span>
                    <form:input id="sourceInput" type="file" path=""/>
                </div>
                <div class="file-path-wrapper">
                    <form:input placeholder="Архив, содержащий исходный код и записку курсовой" type="text" cssClass="file-path validate" path=""/>
                </div>
            </div>

            <div class="input-field col s6">
                <form:input value="ФИО" id="nameInput" placeholder="Стасюкевичу Станиславу Юрьевичу" type="text" cssClass="validate" path=""/>
                <label for="nameInput">ФИО</label>
            </div>

        </div>

        <div class="row">

            <div class="input-field col s6">
                <form:input id="topicInput" placeholder='игровое приложение "Крестики-нолики"' type="text" cssClass="validate" path=""/>
                <label for="topicInput">Тема работы</label>
            </div>

            <div class="input-field col s6">
                <form:input id="dateEndingInput" placeholder="<?php echo date('j F, Y'); ?>" type="date" cssClass="datepicker" path="" />
                <label for="dateEndingInput">Дата сдачи</label>
            </div>

        </div>

        <div class="row">

            <div class="input-field col s6">
                <form:textarea id="contentInput" placeholder="Подключение базы данных" cssClass="materialize-textarea" path="" />
                <label for="contentInput">Исходные данные к работе</label>
            </div>

            <div class="input-field col s6">
                <form:textarea id="contentInput" placeholder="Введение. 1. Постановка задачи. 2. Описание решения. 3. Разработка программных средств. 4. Руководство пользователя. 5. Заключение" cssClass="materialize-textarea" path="" />
                <label for="contentInput">Содержание пояснительной записки</label>
            </div>

        </div>

        <div class="row">

            <div class="input-field col s6">
                <form:input id="assistantInput" placeholder="Перцев И. Ю." type="text" cssClass="validate" path="" />
                <label for="assistantInput">Консультант</label>
            </div>

            <div class="input-field col s6">
                <form:input id="dataInput" placeholder="" type="date" class="datepicker" path="" />
                <label for="dataInput">Дата выдачи</label>
            </div>

        </div>

        <div class="row">

            <div class="input-field col s6">
                <form:textarea id="graphicInput" placeholder="1. Блок-схема процедуры setNull(POINT pt)" cssClass="materialize-textarea" path="" />
                <label for="graphicInput">Перечень графического материла</label>
            </div>

            <div class="input-field col s6">
                <form:textarea id="scheduleInput" class="materialize-textarea" placeholder="раздел 1 к 15.09.2015  –  15 % готовности работы; раздел 2 к 15.10.2015  –  30 % готовности работы;..." path="" />
                <label for="scheduleInput">Процентовка</label>
            </div>

        </div>

        <button class="right btn waves-effect waves-light" type="submit" name="action">Добавить
            <i class="material-icons right">send</i>
        </button>

    </form:form> <!-- End add form -->

</div>