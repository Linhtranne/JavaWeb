<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Department</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h1>Thêm phòng ban mới</h1>

<form action="/departments/add" method="post">
    <label for="name">Tên phòng ban:</label>
    <input type="text" id="name" name="name" required>
    <br><br>

    <label for="description">Mô tả:</label>
    <textarea id="description" name="description" rows="4" cols="50" required></textarea>
    <br><br>

    <label for="status">Trạng thái:</label>
    <select id="status" name="status" required>
        <option value="ACTIVE">Active</option>
        <option value="INACTIVE">Inactive</option>
    </select>
    <br><br>

    <button type="submit">Thêm phòng ban</button>
</form>

<a href="departments">Quay về</a>
</body>
</html>