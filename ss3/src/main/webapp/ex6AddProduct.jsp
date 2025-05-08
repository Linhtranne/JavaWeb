<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h2>Add Product</h2>
<form method="post" action="product">
    <label for="productName">Tên sản phẩm:</label>
    <input type="text" id="productName" name="productName" required>

    <label for="price">Giá:</label>
    <input type="number" id="price" name="price" step="0.01" required>

    <label for="description">Mô tả:</label>
    <textarea id="description" name="description" required></textarea>

    <label for="stock">Số lượng:</label>
    <input type="number" id="stock" name="stock" required>

    <label for="status">Trạng thái:</label>
    <select id="status" name="status">
        <option value="true">Còn hàng</option>
        <option value="false">Không còn hàng</option>
    </select>

    <button type="submit">Add Product</button>
</form>
</body>
</html>