<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Hệ thống quản lý</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h1>Hệ thống quản lý</h1>
<form action="searchEmployee" method="get">
  <input type="text" name="searchName" placeholder="Nhập tên nhân viên">
  <button type="submit">Tìm kiếm</button>
</form>
<h2>Danh sách nhân viên</h2>
<c:if test="${empty employees}">
  <p>Không có nhân viên trong phòng ban</p>
</c:if>
<c:if test="${not empty employees}">
  <table border="1">
    <thead>
    <tr>
      <th>ID</th>
      <th>Tên nhân viên</th>
      <th>Email</th>
      <th>Phone</th>
      <th>Phòng ban</th>
      <th>Status</th>
      <th>Avatar</th>
      <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
      <tr>
        <td>${employee.employeeId}</td>
        <td>${employee.name}</td>
        <td>${employee.email}</td>
        <td>${employee.phone}</td>
        <td>${employee.departmentName}</td>
        <td>${employee.status}</td>
        <td><img src="${employee.photo}" alt="Photo" width="50" height="50"></td>
        <td>
          <a href="editEmployee?id=${employee.employeeId}">Sửa</a>
          <a href="deleteEmployee?id=${employee.employeeId}">Xóa</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>

<div>
  <c:if test="${currentPage > 1}">
    <a href="listEmployees?page=${currentPage - 1}">Trang trước</a>
  </c:if>
  <c:forEach begin="1" end="${totalPages}" var="page">
    <a href="listEmployees?page=${page}">${page}</a>
  </c:forEach>
  <c:if test="${currentPage < totalPages}">
    <a href="listEmployees?page=${currentPage + 1}">Trang tiếp</a>
  </c:if>
</div>

<!-- Add New Employee -->
<a href="addEmployee">Add New Employee</a>
</body>
</html>