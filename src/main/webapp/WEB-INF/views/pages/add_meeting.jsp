<%--
  Created by IntelliJ IDEA.
  User: kirilltsivako
  Date: 5/21/17
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

<div class="card-panel z-depth-2">
    <div class="card-title cyan darken-4 green-header">
        <h3 class="white-text">Создать встречу</h3>
    </div>

    <div class="card-content row">
        <form class="col s12" action="${pageContext.request.contextPath}/meetings/addMeeting/add" enctype="multipart/form-data" method="post">

            <div class="input-field">
                <input name="title" id="titleInput" required placeholder="Встреча учатсников проекта CERES" type="text" class="validate">
                <label for="titleInput">Название встречи</label>
            </div>

            <div class="input-field">
                <input name="place" id="placeInput" required placeholder="г. Минск, ул. Гикала 9" type="text" class="validate">
                <label for="placeInput">Место проведения</label>
            </div>

            <div class="row">
                <div class="input-field col s6">
                    <input name="date" id="dateInput" required type="date" class="datepicker">
                    <label for="dateInput">Дата проведения</label>
                </div>

                <div class="input-field col s6">
                    <input name="time" id="timeInput" required type="time" class="picker--time">
                </div>
            </div>

            <div class="input-field">
                <textarea name="info" id="infoInput" class="materialize-textarea"> </textarea>
                <label for="infoInput">Дополнительная информация</label>
            </div>

            <button class="right btn waves-effect waves-light" type="submit" name="action">
                <i class="material-icons">check</i>
            </button>

            <a href="/meetings/" class="btn red right" style="margin-right: 20px;"><i class="material-icons">cancel</i></a>
        </form>
    </div>
</div></div>