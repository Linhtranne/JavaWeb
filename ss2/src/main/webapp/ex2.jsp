<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thông tin người dùng</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #34495e;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 18px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            transition: border-color 0.2s ease;
        }

        input[type="text"]:focus,
        input[type="number"]:focus {
            border-color: #2980b9;
            outline: none;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #2980b9;
            color: #fff;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.2s ease;
        }

        input[type="submit"]:hover {
            background-color: #1f6391;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Nhập thông tin</h2>
    <form action="userinfo" method="post">
        <label for="name">Tên:</label>
        <input type="text" id="name" name="name" required>

        <label for="age">Tuổi:</label>
        <input type="number" id="age" name="age" required>

        <input type="submit" value="Gửi">
    </form>
</div>
</body>
</html>
