<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 4/16/2017
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <ul class="collapsible" data-collapsible="expandable">
        <c:forEach var="project" items="${projects}">
            <li>
                <div class="collapsible-header"><i class="material-icons">work</i>${project.title}</div>
                <div class="collapsible-body"><span>${project.description}</span></div>
            </li>
        </c:forEach>
    </ul>
</div>
