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
    <a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
    <a href="/" class="brand-logo hide-on-med-and-down">CERES PROJECT</a>
    <ul class="right">

        <c:forEach var="item" items="${topMenu}">
            <c:if test="${fn:startsWith(currUrl, item.url)}">
                <li class="active"><a href="${item.url}">${item.title}</a></li>
            </c:if>

            <c:if test="${not fn:startsWith(currUrl, item.url)}">
                <li><a href="${item.url}">${item.title}</a></li>
            </c:if>
        </c:forEach>

        <c:if test="${empty pageContext.request.userPrincipal.name}">
            <li><a href="<c:url value="/login"/>" class="waves-effect waves-light btn">Войти</a></li>
        </c:if>
        <c:if test="${not empty pageContext.request.userPrincipal.name}">
            <li><a href="/login?logout"
                   class="waves-effect waves-light red accent-2 btn">${pageContext.request.userPrincipal.name}</a></li>
        </c:if>

    </ul>
</nav>