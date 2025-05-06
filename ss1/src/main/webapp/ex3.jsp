<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông tin người dùng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f9fc;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 20px;
        }

        table {
            width: 60%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        th, td {
            padding: 15px;
            border: 1px solid #ddd;
            text-align: center;
            font-size: 16px;
        }

        th {
            background-color: #2980b9;
            color: white;
            text-transform: uppercase;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ecf0f1;
        }
        @media (max-width: 768px) {
            table {
                width: 90%;
            }

            th, td {
                padding: 10px;
            }
        }
    </style>
</head>
<body>
<h2>Thông tin người dùng</h2>
<table>
    <tr>
        <th>Tên</th>
        <th>Tuổi</th>
    </tr>
    <tr>
        <td><%= request.getAttribute("userName") %></td>
        <td><%= request.getAttribute("userAge") %></td>
    </tr>
</table>
</body>
</html>
