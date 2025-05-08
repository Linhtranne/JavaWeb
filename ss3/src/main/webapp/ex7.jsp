<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ss3.ss3.Order" %>
<html>
<head>
    <title>Order Form</title>
</head>
<body>
<h2>Order Form</h2>
<form method="post" action="ex7.jsp">
    <label for="productName">Tên sản phẩm:</label>
    <input type="text" id="productName" name="productName" required><br><br>

    <label for="quantity">Số lượng:</label>
    <input type="number" id="quantity" name="quantity" required><br><br>

    <label for="pricePerProduct">Giá trên mỗi sản phẩm:</label>
    <input type="number" id="pricePerProduct" name="pricePerProduct" step="0.01" required><br><br>

    <button type="submit">Xác nhận</button>
</form>

<%
    String productName = request.getParameter("productName");
    String quantityStr = request.getParameter("quantity");
    String priceStr = request.getParameter("pricePerProduct");

    if (productName != null && quantityStr != null && priceStr != null) {
        int quantity = Integer.parseInt(quantityStr);
        double pricePerProduct = Double.parseDouble(priceStr);
        Order order = new Order(productName, quantity, pricePerProduct);
        double total = order.calculateTotal();
%>
    <h3>Đơn đặt hàng</h3>
    <p>Tên sản phẩm: <%= productName %></p>
    <p>Số lượng: <%= quantity %></p>
    <p>Giá trên mỗi sản phẩm: <%= pricePerProduct %></p>
    <p><strong>Tổng cộng: <%= total %></strong></p>
<%
    }
%>
</body>
</html>
