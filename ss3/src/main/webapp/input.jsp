<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ss3.ss3.UserManager" %>
<%@ page import="com.ss3.ss3.User" %>
<%
  UserManager userManager = (UserManager) application.getAttribute("userManager");
  if (userManager == null) {
    userManager = new UserManager();
    application.setAttribute("userManager", userManager);
  }

  String name = request.getParameter("name");
  String email = request.getParameter("email");

  if (name != null && email != null) {
    userManager.addUser(new User(0, name, email));
    response.sendRedirect("listUser.jsp");
    return;
  }
%>
<html>
<head>
  <title>Thêm người dùng</title>
</head>
<body>
<h2>Thêm người dùng</h2>
<form method="post" action="input.jsp">
  <label for="name">Tên :</label>
  <input type="text" id="name" name="name" required><br><br>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required><br><br>

  <button type="submit">Thêm người dùng</button>
</form>
</body>
</html>