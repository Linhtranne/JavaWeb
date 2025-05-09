<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
  class Product {
    private int id;
    private String name;
    private double price;
    private String description;

    public Product(int id, String name, double price, String description) {
      this.id = id;
      this.name = name;
      this.price = price;
      this.description = description;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public double getPrice() {
      return price;
    }

    public String getDescription() {
      return description;
    }
  }

  List<Product> productList = new ArrayList<>();
  productList.add(new Product(1, "Sản phẩm 01", 1, "he"));
  productList.add(new Product(2, "Sản phẩm 02", 2, "hehe"));
  productList.add(new Product(3, "Sản phẩm 03", 3, "hehehe"));
  String searchId = request.getParameter("productId");
  Product foundProduct = null;

  if (searchId != null) {
    try {
      int id = Integer.parseInt(searchId);
      for (Product product : productList) {
        if (product.getId() == id) {
          foundProduct = product;
          break;
        }
      }
    } catch (NumberFormatException e) {
    }
  }

  request.setAttribute("foundProduct", foundProduct);
%>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
</head>
<body>
<h2>Tìm Kiếm Sản Phẩm</h2>
<form method="get">
  <label for="productId">Nhập ID sản phẩm:</label>
  <input type="text" id="productId" name="productId">
  <button type="submit">Tìm Kiếm</button>
</form>

<c:choose>
  <c:when test="${not empty foundProduct}">
    <div class="product">
      <p><strong>ID:</strong> ${foundProduct.id}</p>
      <p><strong>Tên sản phẩm:</strong> ${foundProduct.name}</p>
      <p><strong>Giá:</strong> ${foundProduct.price} VNĐ</p>
      <p><strong>Mô tả:</strong> ${foundProduct.description}</p>
    </div>
  </c:when>
  <c:otherwise>
    <p class="no-info">Sản phẩm không tìm thấy.</p>
  </c:otherwise>
</c:choose>
</body>
</html>