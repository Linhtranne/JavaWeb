<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h2>User Registration Form</h2>
<form method="post" action="ex5.jsp">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <button type="submit">Register</button>
</form>

<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (name != null && email != null && password != null) {
%>
        <h3>Registration Successful!</h3>
        <p>Thank you, <%= name %>. Đăng nhập thành công.</p>
        <p>Email: <%= email %></p>
<%
    }
%>
</body>
</html>