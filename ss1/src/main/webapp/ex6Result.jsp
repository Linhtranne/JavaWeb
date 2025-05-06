<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả đăng ký</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        .result-box {
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
            text-align: center;
        }

        .success {
            color: #28a745;
        }

        .error {
            color: #dc3545;
        }

        h2 {
            margin-bottom: 20px;
        }

        p {
            font-size: 16px;
            margin: 8px 0;
            color: #333;
        }

        .back-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .back-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="result-box">
    <%
        String status = (String) request.getAttribute("status");
        if ("success".equals(status)) {
    %>
    <h2 class="success">Đăng ký vé xe thành công!</h2>
    <p><strong>Họ và tên:</strong> <%= request.getAttribute("fullName") %></p>
    <p><strong>Lớp:</strong> <%= request.getAttribute("className") %></p>
    <p><strong>Loại xe:</strong> <%= request.getAttribute("vehicleType") %></p>
    <p><strong>Biển số xe:</strong> <%= request.getAttribute("plateNumber") %></p>
    <%
    } else {
    %>
    <h2 class="error">Đăng ký thất bại</h2>
    <p>Vui lòng điền đầy đủ thông tin và thử lại.</p>
    <%
        }
    %>
    <a href="javascript:history.back()" class="back-btn">Quay lại</a>
</div>
</body>
</html>
