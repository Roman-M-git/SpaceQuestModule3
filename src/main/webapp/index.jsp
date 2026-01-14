<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HelloQuest (||) начало</title>

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

        h2 {
            margin-top: 20px; /* уменьшили отступ сверху */
            margin-bottom: 10px; /* небольшой отступ снизу */
            color: #7dd3fc;
            text-shadow: 0 0 10px rgba(125, 211, 252, 0.6);
            text-align: center;
        }

        pre {
            max-width: 1000px; /* увеличили ширину строки */
            text-align: center;
            white-space: pre-wrap;
            font-size: 16px;
            line-height: 1.4; /* чуть плотнее строки */
            text-shadow: 0 0 6px rgba(56, 189, 248, 0.4);
            margin: 0 20px 20px 20px; /* убрали лишние промежутки сверху */
        }

        form {
            text-align: center;
            margin-top: 10px; /* уменьшили отступ, чтобы кнопка была выше */
        }

        label {
            font-size: 18px;
            color: #a5f3fc;
        }

        input[type="text"] {
            width: 300px;
            padding: 10px;
            font-size: 16px;
            background-color: #020617;
            color: #e0f2fe;
            border: 1px solid #38bdf8;
            border-radius: 6px;
            box-shadow: 0 0 10px rgba(56, 189, 248, 0.4);
            outline: none;
        }

        button {
            padding: 10px 28px;
            font-size: 16px;
            margin-top: 10px;
            background: linear-gradient(90deg, #38bdf8, #7dd3fc);
            color: #020617;
            border: none;
            border-radius: 22px;
            cursor: pointer;
            box-shadow: 0 0 18px rgba(56, 189, 248, 0.6);
        }
    </style>
</head>

<body>

<h2>Пролог</h2>

<pre>
Ты очнулся в космическом порту и голова покачивается на борту
своего корабля. Разве ты не об этом мечтал? Стать капитаном
галактического судна с экипажем, который будет совершать
подвиги под твоим командованием.

Так что вперёд!
</pre>

<h2>Знакомство с экипажем</h2>

<pre>
Когда ты поднимаешься на борт корабля, тебя приветствует девушка
с умной улыбкой в глазах:

— Здравствуйте, командир! Я Зинаида — ваша помощница.
Видите? Там в углу пьёт кофе наш штурман - сержант Перегарный Шлейф,
    под штурвалом спит наш бортмеханик Чёрный Богдан,
    а фоторрафирует его Сергей Стальная Пятка - наш навигатор.

А как обращаться к вам?
</pre>

<form action="start" method="post">
    <label for="playerName">"Представьтесь, командир:"</label><br>
    <input type="text" id="playerName" name="playerName"
           placeholder="Введите ваше имя" required
           value="${sessionScope.playerName != null ? sessionScope.playerName : ''}"><br><br>
    <button type="submit">Начать приключение</button>
</form>

</body>
</html>
