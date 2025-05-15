<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
    <h3>Thông tin khách hàng</h3>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Họ tên</th>
            <th>Email</th>
            <th>Giới tính</th>
            <th>Loại</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.gender}</td>
                <td>${customer.customerType}</td>
            </tr>
        </c:forEach>
</body>
</html>
