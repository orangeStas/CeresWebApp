<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 11/20/2016
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container valign-wrapper">
    <div class="row" style="margin-top: 10%">
        <div class="col s6">
            <div class="card white hoverable">
                <div class="card-content">
                    <form method="POST" action="${contextPath}/login" class="form-signin">

                        <div class="form-group ${error != null ? 'has-error' : ''}">

                            <span>${message}</span>
                            <label for="email">Email</label>
                            <input name="email" id="email" type="email" required class="form-control"
                                   autofocus="true"/>

                            <label for="password">Пароль</label>
                            <input name="password" id="password" required type="password" class="form-control"/>

                            <span>${error}</span>

                            <button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>

                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


                            <h6 class="right-align"><a class="teal-text text-darken-1" href="${contextPath}/registration">Зарегистрироваться</a></h6>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <div class="col s6">
            <div class="card teal darken-1 hoverable">
                <div class="card-content white-text">
                    <span class="card-title">Авторизация</span>
                    <p style="margin-top: 10px">Авторизация даст вам доступ к системе проектов и курсовых работ. У
                        вас будет возможность:</p>
                    <p> - Создать свой собственный научный проект и найти команду.</p>
                    <p> - Присоединиться к команде чужого проекта.</p>
                    <p> - Загрузить свои курсовые работы.</p>
                </div>
            </div>
        </div>
    </div>
</div>