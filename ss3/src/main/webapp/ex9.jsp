<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ss3.ss3.UserManager" %>
<%@ page import="com.ss3.ss3.User" %>
<%
  UserManager userManager = (UserManager) application.getAttribute("userManager");
  if (userManager == null) {
    userManager = new UserManager();
    application.setAttribute("userManager", userManager);
  }

  String deleteId = request.getParameter("deleteId");
  if (deleteId != null) {
    int id = Integer.parseInt(deleteId);
    userManager.removeUser(id);
  }

  List<User> users = userManager.getUsers();
%>
<html>
<head>
  <title>Danh sách người dùng</title>
  <script>
    function confirmDelete(id) {
      if (confirm("Bạn có muốn xóa người dùng này không?")) {
        window.location.href = "listUser.jsp?deleteId=" + id;
      }
    }
  </script>
</head>
<body>
<h2>Danh sách người dùng</h2>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Hành động</th>
  </tr>
  </thead>
  <tbody>
  <%
    for (User user : users) {
  %>
  <tr>
    <td><%= user.getId() %></td>
    <td><%= user.getName() %></td>
    <td><%= user.getEmail() %></td>
    <td>
      <button onclick="confirmDelete(<%= user.getId() %>)">Delete</button>
    </td>
  </tr>
  <%
    }
  %>
  </tbody>
</table>
<a href="input.jsp">Thêm user mới</a>
</body>
</html>