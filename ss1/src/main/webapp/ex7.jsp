<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.data.ss1.Student" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Danh sách vé xe sinh viên</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #eef2f7;
      margin: 0;
      padding: 30px;
    }

    h2 {
      text-align: center;
      color: #2c3e50;
      margin-bottom: 40px;
    }

    .table-container {
      overflow-x: auto;
    }

    table {
      width: 90%;
      margin: 0 auto;
      border-collapse: collapse;
      border-radius: 10px;
      overflow: hidden;
      background-color: #ffffff;
      box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
    }

    th, td {
      padding: 15px 20px;
      text-align: center;
      border-bottom: 1px solid #e0e0e0;
    }

    th {
      background-color: #34495e;
      color: #ffffff;
      text-transform: uppercase;
      font-size: 14px;
    }

    td {
      color: #333;
      font-size: 15px;
    }

    tr:hover {
      background-color: #f9f9f9;
    }

    .no-data {
      text-align: center;
      color: #888;
      margin-top: 20px;
      font-style: italic;
    }

    @media (max-width: 768px) {
      table {
        width: 100%;
        font-size: 14px;
      }

      th, td {
        padding: 12px;
      }
    }
  </style>
</head>
<body>
<h2>Danh sách sinh viên đã đăng ký vé xe</h2>
<div class="table-container">
  <table>
    <tr>
      <th>Họ và Tên</th>
      <th>Lớp</th>
      <th>Loại Xe</th>
      <th>Biển Số Xe</th>
    </tr>
    <%
      List<Student> students = (List<Student>) request.getAttribute("students");
      if (students != null && !students.isEmpty()) {
        for (Student student : students) {
    %>
    <tr>
      <td><%= student.getName() %></td>
      <td><%= student.getClassName() %></td>
      <td><%= student.getVehicleType() %></td>
      <td><%= student.getLicensePlate() %></td>
    </tr>
    <%
      }
    } else {
    %>
    <tr>
      <td colspan="4" class="no-data">Không có dữ liệu để hiển thị.</td>
    </tr>
    <%
      }
    %>
  </table>
</div>
</body>
</html>
