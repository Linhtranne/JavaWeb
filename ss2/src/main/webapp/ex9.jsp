<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game Đoán Chữ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 30px;
            color: #2c3e50;
        }

        h2 {
            text-align: center;
            color: #2980b9;
        }

        .game-container {
            max-width: 400px;
            margin: auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .hint, .attempts {
            font-weight: bold;
            margin: 10px 0;
            text-align: center;
        }

        .message {
            color: #e74c3c;
            text-align: center;
            margin: 10px 0;
            font-weight: bold;
        }

        form {
            display: flex;
            justify-content: center;
            gap: 8px;
        }

        input[type="text"] {
            padding: 8px;
            width: 60%;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        input[type="submit"],
        button[type="submit"] {
            padding: 8px 12px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        input[type="submit"]:hover,
        button[type="submit"]:hover {
            background-color: #2980b9;
        }

        .play-again {
            text-align: center;
            margin-top: 15px;
        }

        .play-again button {
            background-color: #2ecc71;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .play-again button:hover {
            background-color: #27ae60;
        }
    </style>
</head>
<body>
<h2>Game Đoán Chữ</h2>

<div class="game-container">
    <p class="hint">💡 <strong>Gợi ý từ:</strong> <%= session.getAttribute("displayHint") %></p>
    <p class="attempts">🔄 Bạn còn: <%= session.getAttribute("attemptsLeft") %> lượt đoán</p>

    <form method="post" action="guess">
        <input type="text" name="guess" required placeholder="Nhập từ bạn đoán..."/>
        <input type="submit" value="Đoán"/>
    </form>

    <% String message = (String) session.getAttribute("message"); %>
    <% if (message != null && !message.isEmpty()) { %>
    <p class="message"><%= message %></p>
    <% } %>

    <% if (message != null && (message.contains("thua") || message.contains("đoán đúng"))) { %>
    <div class="play-again">
        <form action="guess" method="get">
            <button type="submit">🔁 Chơi lại</button>
        </form>
    </div>
    <% } %>
</div>
</body>
</html>
