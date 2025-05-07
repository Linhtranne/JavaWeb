<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.ss2.ss2.Product" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh Sách Sản Phẩm</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f6f8;
      margin: 0;
      padding: 20px;
    }

    h1, h2 {
      text-align: center;
      color: #2c3e50;
    }

    .form-container {
      width: 400px;
      margin: 20px auto;
      background-color: #ffffff;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      padding: 20px;
    }

    form {
      display: flex;
      flex-direction: column;
      gap: 12px;
    }

    input[type="text"],
    input[type="number"],
    input[type="submit"] {
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 5px;
      font-size: 16px;
    }

    input[type="submit"] {
      background-color: #2980b9;
      color: #fff;
      border: none;
      cursor: pointer;
      transition: background-color 0.2s;
    }

    input[type="submit"]:hover {
      background-color: #1f6391;
    }

    table {
      width: 80%;
      margin: 20px auto;
      border-collapse: collapse;
      background-color: #fff;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    th, td {
      padding: 12px 16px;
      border: 1px solid #ddd;
      text-align: center;
    }

    th {
      background-color: #2980b9;
      color: #fff;
      text-transform: uppercase;
    }

    tr:hover {
      background-color: #f1f1f1;
    }

    .action-buttons form {
      display: inline-block;
    }

    .action-buttons input[type="submit"] {
      margin: 0 2px;
      padding: 6px 12px;
      font-size: 14px;
      border-radius: 5px;
    }

    .edit-btn {
      background-color: #3498db;
      color: #fff;
    }

    .delete-btn {
      background-color: #e74c3c;
      color: #fff;
    }

    .edit-btn:hover {
      background-color: #2980b9;
    }

    .delete-btn:hover {
      background-color: #c0392b;
    }
  </style>
</head>
<body>
<h1>Danh Sách Sản Phẩm</h1>

<div class="form-container">
  <h2>Thêm Sản Phẩm</h2>
  <form action="products" method="post">
    <label for="name">Tên:</label>
    <input type="text" id="name" name="name" required>

    <label for="price">Giá:</label>
    <input type="number" id="price" name="price" step="0.1" required>

    <input type="submit" value="Thêm">
  </form>
</div>

<table>
  <tr>
    <th>ID</th>
    <th>Tên Sản Phẩm</th>
    <th>Giá</th>
    <th>Hành động</th>
  </tr>
  <%
    List<Product> list = (List<Product>) request.getAttribute("productList");
    if (list != null) {
      for (Product p : list) {
  %>
  <tr>
    <td><%= p.getId() %></td>
    <td><%= p.getName() %></td>
    <td><%= p.getPrice() %></td>
    <td class="action-buttons">
      <form action="products" method="get">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="<%= p.getId() %>">
        <input type="submit" value="Sửa" class="edit-btn">
      </form>
      <form action="products" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này không?');">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="<%= p.getId() %>">
        <input type="submit" value="Xóa" class="delete-btn">
      </form>
    </td>
  </tr>
  <%
      }
    }
  %>
</table>
</body>
</html>
