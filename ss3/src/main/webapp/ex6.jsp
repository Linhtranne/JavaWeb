<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ss3.ss3.Product" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h2>Product List</h2>
<table border="1">
    <thead>

    <a href="ex6AddProduct.jsp">Thêm sản phẩm</a>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Mô tả</th>
        <th>Số lượng</th>
        <th>Trạng thái</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Product> productList = (List<Product>) application.getAttribute("productList");
        if (productList != null) {
            for (Product product : productList) {
    %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getProductName() %></td>
        <td><%= product.getPrice() %></td>
        <td><%= product.getDescription() %></td>
        <td><%= product.getStock() %></td>
        <td><%= product.isStatus() ? "Available" : "Unavailable" %></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="6">Không có sản phẩm nào.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>