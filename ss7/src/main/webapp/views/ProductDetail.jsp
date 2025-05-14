<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Chi tiết sản phẩm</title></head>
<body>
<h2>Chi tiết sản phẩm</h2>
<img src="${ex9Product.image}" width="200"/>
<p><strong>Tên:</strong> ${ex9Product.name}</p>
<p><strong>Giá:</strong> ${ex9Product.price}</p>
<p><strong>Số lượng:</strong> ${ex9Product.stock}</p>
<p><strong>Mô tả:</strong> ${ex9Product.description}</p>
<a href="ex8Products">Quay lại danh sách</a>
</body>
</html>