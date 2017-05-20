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
    <form class="col s12" action="${pageContext.request.contextPath}/education/addWork" enctype="multipart/form-data" method="post">

        <div class="row">

            <div class="file-field input-field col s6">
                <div class="btn">
                    <span>Файл</span>
                    <input required type="file" name="sourceFile" id="sourceInput" multiple>
                </div>
                <div class="file-path-wrapper">
                    <input class="file-path validate" type="text" placeholder="Архив, содержащий исходный код и записку курсовой">
                </div>
            </div>

            <div class="input-field col s6">
                <input name="name" id="nameInput" required maxlength="255" placeholder="Стасюкевичу Станиславу Юрьевичу" type="text" class="validate">
                <label for="nameInput">ФИО</label>
            </div>

        </div>

        <div class="row">

            <div class="input-field col s6">
                <input required name="topic" id="topicInput" maxlength="255" placeholder='игровое приложение "Крестики-нолики"' type="text" class="validate">
                <label for="topicInput">Тема работы</label>
            </div>

            <div class="input-field col s6">
                <input required type="date" class="datepicker" name="dateEnding" id="dateEndingInput" placeholder="">
                <label for="dateEndingInput">Дата сдачи</label>
            </div>

        </div>

        <div class="row">

            <div class="input-field col s6">
                <textarea required class="materialize-textarea" name="start" id="contentInput" placeholder="Подключение базы данных"></textarea>
                <label for="contentInput">Исходные данные к работе</label>
            </div>

            <div class="input-field col s6">
                    <textarea required name="content" id="contentInput2"
                              placeholder="Введение. 1. Постановка задачи. 2. Описание решения. 3. Разработка программных средств. 4. Руководство пользователя. 5. Заключение" class="materialize-textarea"></textarea>
                <label for="contentInput2">Содержание пояснительной записки</label>
            </div>

        </div>

        <div class="row">

            <div class="input-field col s6">
                <input required type="text" class="validate" name="assistant" id="assistantInput" placeholder="Перцев И. Ю.">
                <label for="assistantInput">Консультант</label>
            </div>

            <div class="input-field col s6">
                <input required type="date" class="datepicker" name="dateGetting" id="dataInput" placeholder="">
                <label for="dataInput">Дата выдачи</label>
            </div>

        </div>

        <div class="row">

            <div class="input-field col s6">
                <textarea required name="graphic" id="graphicInput" placeholder="1. Блок-схема процедуры setNull(POINT pt)" class="materialize-textarea"></textarea>
                <label for="graphicInput">Перечень графического материла</label>
            </div>

            <div class="input-field col s6">
                <textarea required name="schedule" id="scheduleInput" class="materialize-textarea" placeholder="раздел 1 к 15.09.2015  –  15 % готовности работы; раздел 2 к 15.10.2015  –  30 % готовности работы;..."></textarea>
                <label for="scheduleInput">Процентовка</label>
            </div>

        </div>

        <input type="hidden" name="_token" value="{!!csrf_token()!!}"/>

        <button class="right btn waves-effect waves-light" type="submit" name="action">Добавить
            <i class="material-icons right">send</i>
        </button>

    </form> <!-- End add form -->

</div>