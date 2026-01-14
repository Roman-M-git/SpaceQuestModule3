<%--
  Created by IntelliJ IDEA.
  User: rmeeo
  Date: 25-Dec-25
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Космический квест</title>

    <style>
        body {
            margin: 0;
            min-height: 100vh;
            background: radial-gradient(circle at top, #1b2735, #090a0f);
            font-family: "Trebuchet MS", Arial, sans-serif;
            color: #d0e6ff;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            margin-top: 30px;
            color: #7dd3fc;
            text-shadow: 0 0 12px rgba(125, 211, 252, 0.8);
            text-align: center;
        }

        h2, h3 {
            color: #7dd3fc;
            text-shadow: 0 0 10px rgba(125, 211, 252, 0.6);
            text-align: center;
            margin: 15px 0 10px 0;
        }

        div, p {
            max-width: 1000px;
            text-align: center;
            margin: 5px 20px;
            line-height: 1.4;
        }

        hr {
            width: 80%;
            border: 0;
            border-top: 1px solid #38bdf8;
            margin: 20px 0;
        }

        form {
            text-align: center;
            margin-top: 10px;
        }

        input[type="radio"] {
            margin-right: 10px;
            cursor: pointer;
        }

        button, a {
            display: inline-block;
            padding: 10px 28px;
            font-size: 16px;
            margin-top: 10px;
            background: linear-gradient(90deg, #38bdf8, #7dd3fc);
            color: #020617;
            border: none;
            border-radius: 22px;
            cursor: pointer;
            text-decoration: none;
            box-shadow: 0 0 18px rgba(56, 189, 248, 0.6);
            transition: transform 0.2s;
        }

        button:hover, a:hover {
            transform: scale(1.05);
        }

        input[type="hidden"] {
            display: none;
        }
    </style>
</head>
<body>

<h1>Космический квест</h1>

<div>
    <p>Игрок: ${sessionScope.playerName}</p>
    <p>Сыграно игр: ${sessionScope.gamesPlayed != null ? sessionScope.gamesPlayed : 0}</p>
</div>

<hr>

<h2>${step.text}</h2>

<c:choose>
    <c:when test="${not empty step.option1}">
        <form action="game" method="post">
            <input type="hidden" name="currentStep" value="${step.id}">

            <p>
                <input type="radio" name="answer" value="1" required>
                    ${step.option1}
            </p>

            <p>
                <input type="radio" name="answer" value="2" required>
                    ${step.option2}
            </p>

            <button type="submit">Ответить</button>
        </form>
    </c:when>

    <c:otherwise>
        <h3>${step.text}</h3>
        <p>
            <a href="game?step=start">Играть снова</a> |
            <a href="start">Начать сначала</a>
        </p>
    </c:otherwise>
</c:choose>

<hr>

<div>
    <p>ID сессии: ${pageContext.session.id}</p>
    <p>Текущий шаг: ${step.id}</p>
</div>

</body>
</html>

