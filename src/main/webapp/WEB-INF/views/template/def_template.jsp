<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="utf-8">
</head>
<body>
<div class="wrapper">

<tiles:insertAttribute name="navigation"/>

<tiles:insertAttribute name="content"/>
</div>

<footer class="page-footer cyan darken-4">
    <div class="footer-copyright">
        <div class="container center">
            © 2016 Ceres Project
        </div>
    </div>
</footer>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/bin/materialize.min.js'/>"></script>

<script>
    $( document ).ready(function(){
        $('.button-collapse').sideNav();
        $('.parallax').parallax();
        $('select').material_select();

        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15, // Creates a dropdown of 15 years to control year
            format: 'dd.mm.yyyy'
        });
    });
</script>
</body>
</html>