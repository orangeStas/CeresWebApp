<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 10/6/2016
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h3>Новости</h3>

    <c:forEach var="news" items="${newsList}" varStatus="loop" step="2">
        <div class="row">

            <div class="card col s5 hoverable">
                <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator" src="resources/images/news/${newsList[loop.index].imageFileName}">
                </div>
                <div class="card-content">
                    <p>${newsList[loop.index].modificationDate}</p>
                            <span class="card-title activator grey-text text-darken-4">${newsList[loop.index].title}<i
                                    class="material-icons right">more_vert</i></span>
                </div>
                <div class="card-reveal">
                            <span class="card-title grey-text text-darken-4">${newsList[loop.index].title}<i
                                    class="material-icons right">close</i></span>
                        ${newsList[loop.index].content}
                </div>
            </div>

            <c:if test="${loop.index + 2 <= fn:length(newsList)}">
                <div class="card col s5 offset-s2 hoverable">
                    <div class="card-image waves-effect waves-block waves-light">
                        <img class="activator" src="resources/images/news/${newsList[loop.index + 1].imageFileName}">
                    </div>
                    <div class="card-content">
                        <p>${newsList[loop.index + 1].modificationDate}</p>
                                <span class="card-title activator grey-text text-darken-4">${newsList[loop.index + 1].title}<i
                                        class="material-icons right">more_vert</i></span>
                    </div>
                    <div class="card-reveal">
                                <span class="card-title grey-text text-darken-4">${newsList[loop.index + 1].title}<i
                                        class="material-icons right">close</i></span>
                            ${newsList[loop.index + 1].content}
                    </div>
                </div>
            </c:if>
        </div>
        <!-- End row-->

    </c:forEach>
</div>