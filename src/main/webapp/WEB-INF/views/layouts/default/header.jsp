<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 10/12/2016
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="${requestScope['javax.servlet.forward.request_uri']}" var="currUrl"/>

<nav class="nav-wrapper cyan darken-4">
    <a href="/" class="brand-logo">CERES PROJECT</a>
    <ul class="right hide-on-med-and-down">

        <c:forEach var="item" items="${topMenu}">
            <c:if test="${fn:startsWith(currUrl, item.url)}">
                <li class="active"><a href="${item.url}">${item.title}</a></li>
            </c:if>

            <c:if test="${not fn:startsWith(currUrl, item.url)}">
                <li><a href="${item.url}">${item.title}</a></li>
            </c:if>
        </c:forEach>

        <li><a href="<c:url value="/auth/login"/>" class="waves-effect waves-light btn">Войти</a></li>

        <li><a href="/auth/logout"
               class="waves-effect waves-light red accent-2">${pageContext.request.userPrincipal.name}</a></li>
        <%--@if(Auth::check())
        <li><a href="/auth/logout" class="waves-effect waves-light btn red accent-2">Выйти</a></li>
        @else
        <li><a href="/auth/login" class="waves-effect waves-light btn">Войти</a></li>
        @endif--%>
    </ul>

    <ul class="side-nav" id="mobile-nav">

        <c:forEach var="item" items="${topMenu}">
            <c:if test="${fn:startsWith(currUrl, item.url)}">
                <li class="active"><a href="${item.url}">${item.title}</a></li>
            </c:if>

            <c:if test="${not fn:startsWith(currUrl, item.url)}">
                <li><a href="${item.url}">${item.title}</a></li>
            </c:if>
        </c:forEach>


        <li><a href="<c:url value="/auth/login"/>" class="waves-effect waves-light">Войти</a></li>

        <%--@if(Auth::check())

        @else
        <li><a href="/auth/login" class="waves-effect waves-light">Войти</a></li>
        @endif--%>
    </ul>

    <a href="#" data-activates="mobile-nav" class="button-collapse"><i class="material-icons">menu</i></a>
</nav>