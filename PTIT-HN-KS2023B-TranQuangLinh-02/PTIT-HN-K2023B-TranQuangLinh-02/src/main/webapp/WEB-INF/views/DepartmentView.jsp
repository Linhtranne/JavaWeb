<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h1>Quản lý phòng ban</h1>

<form action="departments/search" method="get">
    <input type="text" name="searchName" placeholder="Tìm kiếm phòng ban">
    <button type="submit">Tìm kiếm</button>
</form>

<h2>Quản lý phòng ban</h2>
<c:if test="${empty departments}">
    <p>Không có phòng ban</p>
</c:if>
<c:if test="${not empty departments}">
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên phòng ban</th>
            <th>Mô tả</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="department" items="${departments}">
            <tr>
                <td>${department.departmentId}</td>
                <td>${department.departmentName}</td>
                <td>${department.description}</td>
                <td>${department.status}</td>
                <td>
                    <a href="departments/edit/${department.departmentId}">Sửa</a>
                    <a href="departments/delete/${department.departmentId}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<a href="departments/add">Thêm phòng ban mới</a>
</body>
</html>