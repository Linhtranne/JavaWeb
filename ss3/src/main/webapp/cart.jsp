<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ss3.ss3.CartManager" %>
<%@ page import="com.ss3.ss3.ProductEx10" %>
<%@ page import="java.util.List" %>
<%
  CartManager cartManager = (CartManager) session.getAttribute("cartManager");
  if (cartManager == null) {
    cartManager = new CartManager();
    session.setAttribute("cartManager", cartManager);
  }

  String removeId = request.getParameter("removeProductId");
  if (removeId != null) {
    int id = Integer.parseInt(removeId);
    cartManager.removeProduct(id);
  }

  List<ProductEx10> cart = cartManager.getCart();
%>
<html>
<head>
  <title>Giỏ hàng</title>
</head>
<body>
<h2>Giỏ hàng của bạn</h2>
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
    for (ProductEx10 product : cart) {
  %>
  <tr>
    <td><%= product.getId() %></td>
    <td><%= product.getName() %></td>
    <td><%= product.getPrice() %> VND</td>
    <td>
      <a href="cart.jsp?removeProductId=<%= product.getId() %>">Xóa</a>
    </td>
  </tr>
  <%
    }
  %>
  </tbody>
</table>
<p>Tổng tiền: <%= cartManager.getTotalPrice() %> VND</p>
<a href="ex10.jsp">Quay lại trang sản phẩm</a>
</body>
</html>
