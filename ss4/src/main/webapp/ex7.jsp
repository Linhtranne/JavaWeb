<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ss4.ss4.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="products" class="java.util.ArrayList" scope="session" />
<%
    if (products.isEmpty()) {
        products.add(new Product(1, "A", 15000000, "A"));
        products.add(new Product(2, "B", 8000000, "B"));
        products.add(new Product(3, "C", 5000000, "C"));
        products.add(new Product(4, "D", 2000000, "D"));
        products.add(new Product(5, "E", 1000000, "E"));
        products.add(new Product(6, "F", 7000000, "F"));
    }
    String minPriceStr = request.getParameter("minPrice");
    String maxPriceStr = request.getParameter("maxPrice");

    double minPrice = 0;
    double maxPrice = Double.MAX_VALUE;

    try {
        if (minPriceStr != null && !minPriceStr.isEmpty()) {
            minPrice = Double.parseDouble(minPriceStr);
        }
        if (maxPriceStr != null && !maxPriceStr.isEmpty()) {
            maxPrice = Double.parseDouble(maxPriceStr);
        }
    } catch (NumberFormatException e) {
        minPrice = 0;
        maxPrice = Double.MAX_VALUE;
    }
%>
<html>
<head>
</head>
<body>
<h2>Lọc Sản Phẩm Theo Giá</h2>

<form method="get">
    <label>Giá Tối Thiểu:</label>
    <input type="number" name="minPrice" placeholder="Nhập giá tối thiểu" step="1000">
    <label>Giá Tối Đa:</label>
    <input type="number" name="maxPrice" placeholder="Nhập giá tối đa" step="1000">
    <button type="submit">Lọc</button>
</form>

<h3>Danh Sách Sản Phẩm</h3>
<table>
    <tr>
        <th>ID</th>
        <th>Tên Sản Phẩm</th>
        <th>Giá</th>
        <th>Mô Tả</th>
    </tr>
    <c:choose>
        <c:when test="${not empty products}">
            <c:forEach var="product" items="${products}">
                <c:if test="${product.price >= minPrice && product.price <= maxPrice}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.productName}</td>
                        <td>${product.price}</td>
                        <td>${product.description}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="4">Không có sản phẩm nào trong khoảng giá này.</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
