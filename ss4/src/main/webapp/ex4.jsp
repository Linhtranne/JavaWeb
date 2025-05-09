<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  Map<String, String> product = new HashMap<>();
  product.put("name", "Sản phẩm 01");
  product.put("price", "");
  product.put("description", "Mô tả sản phẩm 01");
  request.setAttribute("product", product);
%>

<html>
<head>
</head>
<body>
<h2>Chi Tiết Sản Phẩm</h2>

<c:choose>
  <c:when test="${not empty product}">
    <p><strong>Tên sản phẩm:</strong> ${product.name}</p>
    <p><strong>Giá:</strong> ${product.price} VNĐ</p>
    <p><strong>Mô tả</strong>${product.description}</p>
  </c:when>
  <c:otherwise>
    <p style="color:red;">Sản phẩm không có thông tin.</p>
  </c:otherwise>
</c:choose>

</body>
</html>