<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lỗi hệ thống</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            color: #333;
            padding: 50px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .error-box {
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 500px;
            width: 100%;
        }

        .error-box h2 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #721c24;
        }

        .error-box p {
            font-size: 16px;
            color: #721c24;
        }

        .error-box .error-message {
            background-color: #f5c6cb;
            color: #721c24;
            padding: 15px;
            border-radius: 5px;
            margin: 20px 0;
            font-weight: bold;
        }

        .error-box .error-btn {
            padding: 10px 20px;
            background-color: #721c24;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
            display: inline-block;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .error-box .error-btn:hover {
            background-color: #b02a2a;
        }
    </style>
</head>
<body>
<div class="error-box">
    <h2>Có lỗi xảy ra!</h2>
    <p><strong>Chi tiết:</strong></p>
    <div class="error-message">${errorMessage}</div>
    <a href="javascript:history.back()" class="error-btn">Trở về trang trước</a>
</div>
</body>
</html>
