<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ss3.ss3.Book" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Book Management</title>
</head>
<body>
<h2>Book Management</h2>

<h3>Thêm sách</h3>
<form method="post" action="ex8">
    <input type="hidden" name="action" value="add">
    <label for="name">Tên sách:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="author">Tác giả:</label>
    <input type="text" id="author" name="author" required><br><br>

    <label for="year">Năm phát hành:</label>
    <input type="number" id="year" name="year" required><br><br>

    <button type="submit">Thêm</button>
</form>
<h3>Tìm kiếm sách</h3>
<form method="post" action="ex8">
    <input type="hidden" name="action" value="search">
    <label for="searchName">Tên sách:</label>
    <input type="text" id="searchName" name="searchName" required>
    <button type="submit">Tìm kiếm</button>
</form>
<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
    <p style="color: green;"><%= message %></p>
<%
    }
%>
=
<%
    List<Book> searchResults = (List<Book>) request.getAttribute("searchResults");
    if (searchResults != null) {
%>
    <h3>Search Results</h3>
    <ul>
    <%
        for (Book book : searchResults) {
    %>
        <li><strong>Sách <%= book.getName() %></strong> của <%= book.getAuthor() %> (năm phát hành: <%= book.getYear() %>)</li>
    <%
        }
    %>
    </ul>
<%
    }
%>

<h3>Sách</h3>
<%
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
    if (bookList != null && !bookList.isEmpty()) {
%>
    <ul>
    <%
        for (Book book : bookList) {
    %>
        <li><strong><%= book.getName() %></strong> by <%= book.getAuthor() %> (Published: <%= book.getYear() %>)</li>
    <%
        }
    %>
    </ul>
<%
    } else {
%>
    <p>No books available.</p>
<%
    }
%>
</body>
</html>