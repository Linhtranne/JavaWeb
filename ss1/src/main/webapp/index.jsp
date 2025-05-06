<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Bài tập</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            padding: 40px;
            margin: 0;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 30px;
        }

        .link-container {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .link-container a {
            display: block;
            text-decoration: none;
            color: #3498db;
            padding: 12px 16px;
            margin: 8px 0;
            background-color: #ecf0f1;
            border-radius: 6px;
            transition: all 0.2s ease;
        }

        .link-container a:hover {
            background-color: #d6eaf8;
            color: #2c3e50;
        }

        @media (max-width: 600px) {
            .link-container {
                width: 90%;
                padding: 15px;
            }
        }
    </style>
</head>
<body>
<div class="link-container">
    <a href="ex1">Bài 1</a>
    <a href="ex2">Bài 2</a>
    <a href="ex3">Bài 3</a>
    <a href="ex4">Bài 4</a>
    <a href="ex5">Bài 5</a>
    <a href="ex6">Bài 6</a>
    <a href="ex7">Bài 7</a>
    <a href="ex8">Bài 8</a>
</div>
</body>
</html>
