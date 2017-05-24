<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: stas-
  Date: 5/20/2017
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ошибка</title>
    <link href="<c:url value="/resources/css/own_styles.css"/>" rel="stylesheet">
</head>
<body>
    <tiles:insertAttribute name="content"/>
</body>
</html>
