<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  ServletContext context = application;
  if ("POST".equalsIgnoreCase(request.getMethod())) {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    if (name != null && email != null) {
      context.setAttribute("userName", name);
      context.setAttribute("userEmail", email);
    }
  }
  String storedName = (String) context.getAttribute("userName");
  String storedEmail = (String) context.getAttribute("userEmail");
%>

<!DOCTYPE html>
<html>
<head>
  <title>Thông tin người dùng</title>
</head>
<body>
<h2>Nhập thông tin người dùng</h2>
<form action="ex2.jsp" method="post">
  Tên: <input type="text" name="name" required><br><br>
  Email: <input type="email" name="email" required><br><br>
  <input type="submit" value="Gửi">
</form>
<% if (storedName != null && storedEmail != null) { %>
<h2>Thông tin người dùng đã nhập:</h2>
<p>Tên: <%= storedName %></p>
<p>Email: <%= storedEmail %></p>
<% } %>
</body>
</html>
