<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.ss2.ss2.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Sản Phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 20px;
        }

        .form-container {
            width: 400px;
            margin: 20px auto;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
        }

        .form-container input[type="text"],
        .form-container input[type="number"],
        .form-container input[type="submit"] {
            width: 90%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .form-container input[type="submit"] {
            background-color: #2980b9;
            color: #fff;
            border: none;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .form-container input[type="submit"]:hover {
            background-color: #1f6391;
        }

        .error-message {
            color: red;
            font-weight: bold;
            margin-bottom: 12px;
        }
    </style>
</head>
<body>
<%
    Product product = (Product) request.getAttribute("product");
    String error = (String) request.getAttribute("error");
%>

<h2>Cập Nhật Sản Phẩm</h2>

<div class="form-container">
    <% if (error != null) { %>
    <p class="error-message"><%= error %></p>
    <% } %>

    <form action="products" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= product.getId() %>">

        <label for="name">Tên:</label>
        <input type="text" id="name" name="name" value="<%= product.getName() %>" required>

        <label for="price">Giá:</label>
        <input type="number" id="price" step="0.1" name="price" value="<%= product.getPrice() %>" required>

        <input type="submit" value="Cập nhật">
    </form>
</div>
</body>
</html>
