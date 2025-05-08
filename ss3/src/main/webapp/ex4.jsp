<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 5/7/2025
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Vui lòng nhập 2 số vào để cộng</p>
<form method="post" action="ex4.jsp">
    <input type="text" name="number1" placeholder="Nhập số thứ nhất">
    <input type="text" name="number2" placeholder="Nhập số thứ hai">
    <button type="submit">Cộng</button>
</form>
<%
    String number1 = request.getParameter("number1");
    String number2 = request.getParameter("number2");
    if (number1 != null && number2 != null) {
        try {
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(number2);
            int sum = num1 + num2;
            %>
            <p>Kết quả: <%= num1 %> + <%= num2 %> = <%= sum %></p>
            <%
        } catch (NumberFormatException e) {
            %>
            <p style="color: red;">Vui lòng nhập số hợp lệ.</p>
            <%
        }
              }
            %>


</body>
</html>
