
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
    <a href="ProductController">Bài 1</a>
    <a href="studentController">Bài 2</a>
    <a href="studentController">Bài 3</a>
    <a href="studentController">Bài 4</a>
    <a href="studentController">Bài 5</a>
    <a href="studentController">Bài 6</a>
    <a href="studentController">Bài 7</a>
    <a href="tasks">Bài 8</a>
    <a href="blog">Bài 9</a>
    <a href="contacts">Bài 10</a>
</div>
</body>
</html>
