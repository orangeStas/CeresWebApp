<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="utf-8">

    <script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>

    <script type="text/javascript">

        var stompClient = null;

        window.onload = function () {
            connect();
            scrollToDown();
        };

        function scrollToDown() {
            var elem = document.getElementById('conversationDiv');
            elem.scrollTop = elem.scrollHeight;
        }

        function setConnected(connected) {

            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
        }

        function connect() {

            var socket = new SockJS('/chat');
            stompClient = Stomp.over(socket);

            stompClient.connect({}, function(frame) {

                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/messages', function(messageOutput) {

                    showMessageOutput(JSON.parse(messageOutput.body));
                });
            });
        }

        function disconnect() {

            if(stompClient != null) {
                stompClient.disconnect();
            }

            setConnected(false);
            console.log("Disconnected");
            window.history.back();
        }

        function sendMessage() {

            var from = document.getElementById('from').value;
            var text = document.getElementById('text').value;
            var chatId = document.getElementById('chatId').value;
            var studentId = document.getElementById('studentId').value;
            stompClient.send("/app/chat", {}, JSON.stringify({'from':from, 'text':text, 'chatId':chatId, 'studentId':studentId}));
        }

        function showMessageOutput(messageOutput) {
            var studentId = document.getElementById('studentId').value;

            var style = studentId == messageOutput.studentId ? 'teal lighten-2 white-text' : '';
            console.log(studentId);
            console.log(messageOutput.studentId);

            var chatColelction = document.getElementById('chat_collection');
            $('#chat_collection').append("<li class='collection-item' style='margin-top: 5px'>" +
                    "<span class='title'>"+messageOutput.from+":</span> " +
                    "<div class='chip "+style+"'>"+messageOutput.text+"</div> " +
                    "<a class='secondary-content'>"+messageOutput.time+"</a> </li>");

            document.getElementById('text').value = '';
            scrollToDown();
        }

    </script>

</head>
<body>
<div class="wrapper">

    <tiles:insertAttribute name="navigation"/>

    <tiles:insertAttribute name="content"/>
</div>

<footer class="page-footer cyan darken-4">
    <div class="footer-copyright">
        <div class="container center">
            © 2017 Ceres Project
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