<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết Quả</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f4f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .result-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h2 {
            color: #2c3e50;
        }

        p {
            font-size: 18px;
            margin: 10px 0;
        }

        button {
            margin-top: 15px;
            padding: 10px 20px;
            background-color: #3498db;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<div class="result-container">
    <h2>Kết Quả Trò Chơi</h2>
    <p><%= request.getAttribute("message") %></p>
    <form action="game" method="get">
        <button>Chơi lại</button>
    </form>
</div>
</body>
</html>
