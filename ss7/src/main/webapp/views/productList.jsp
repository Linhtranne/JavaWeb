<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Danh sách sản phẩm</title></head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="cart">🛒 Xem giỏ hàng</a>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<table border="1">
    <tr>
        <th>Hình ảnh</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="ex9Product" items="${products}">
        <tr>
            <td><img src="${ex9Product.image}" width="100"/></td>
            <td>${ex9Product.name}</td>
            <td>${ex9Product.price}</td>
            <td>${ex9Product.stock}</td>
            <td>
                <form action="cart/add" method="post">
                    <input type="hidden" name="id" value="${ex9Product.id}"/>
                    <input type="number" name="quantity" min="1" value="1" style="width:50px"/>
                    <button type="submit">Thêm vào giỏ</button>
                </form>
                <a href="ex9products/details?id=${ex9Product.id}">Xem chi tiết</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>