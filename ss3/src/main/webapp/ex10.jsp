<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ss3.ss3.CartManager" %>
<%@ page import="com.ss3.ss3.ProductEx10" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ss3.ss3.Product" %>

<%
    CartManager cartManager = (CartManager) session.getAttribute("cartManager");
    if (cartManager == null) {
        cartManager = new CartManager();
        session.setAttribute("cartManager", cartManager);
    }

    List<ProductEx10> products = new ArrayList<>();
    products.add(new ProductEx10(1, "Sản phẩm A", 100.0));
    products.add(new ProductEx10(2, "Sản phẩm B", 200.0));
    products.add(new ProductEx10(3, "Sản phẩm C", 300.0));

    String productId = request.getParameter("addProductId");
    if (productId != null) {
        int id = Integer.parseInt(productId);
        for (ProductEx10 product : products) {
            if (product.getId() == id) {
                cartManager.addProduct(product);
                break;
            }
        }
    }
%>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm có sẵn</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (ProductEx10 product : products) {
    %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %> VND</td>
        <td>
            <a href="ex10.jsp?addProductId=<%= product.getId() %>">Thêm vào giỏ hàng</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<a href="cart.jsp">Xem giỏ hàng</a>
</body>
</html>
