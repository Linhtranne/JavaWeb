<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sản phẩm - Category: ${category}</h2>
<c:if test="${not empty color}">
    <p>Lọc theo màu: ${color}</p>
</c:if>
<c:if test="${not empty size}">
    <p>Lọc theo size: ${size}</p>
</c:if>

<table border="1">
    <tr>
        <th>Tên</th>
        <th>Màu</th>
        <th>Size</th>
    </tr>
    <c:forEach var="ex9Product" items="${ex8Products}">
        <tr>
            <td>${ex9Product.name}</td>
            <td>${ex9Product.color}</td>
            <td>${ex9Product.size}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>