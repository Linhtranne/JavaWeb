<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kết Quả Đăng Nhập</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    boolean isValid = "admin".equals(username) && "123456".equals(password);
    request.setAttribute("isValid", isValid);
%>
<c:if test="${isValid}">
    <h2>Đăng nhập thành công!</h2>
    <p>Chào mừng, <b>${param.username}</b>!</p>
</c:if>
<c:if test="${!isValid}">
    <h2>Đăng nhập thất bại!</h2>
    <p>Thông tin không chính xác. Vui lòng thử lại.</p>
    <a href="login.jsp">Quay lại trang đăng nhập</a>
</c:if>
</body>
</html>