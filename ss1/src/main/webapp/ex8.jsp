<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.data.ss1.Task" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>To-Do List</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f4f6f8;
      padding: 40px;
      margin: 0;
    }

    h2 {
      text-align: center;
      color: #2c3e50;
      margin-bottom: 30px;
    }

    form {
      display: flex;
      justify-content: center;
      gap: 10px;
      margin-bottom: 30px;
    }

    input[type="text"] {
      width: 300px;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 6px;
      font-size: 16px;
    }

    input[type="submit"] {
      padding: 10px 16px;
      font-size: 16px;
      background-color: #27ae60;
      color: #fff;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
      background-color: #219150;
    }

    ul {
      list-style: none;
      padding: 0;
      max-width: 500px;
      margin: 0 auto;
    }

    li {
      background-color: #fff;
      margin-bottom: 12px;
      padding: 12px 16px;
      border-radius: 6px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.05);
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .completed {
      text-decoration: line-through;
      color: #888;
    }

    a {
      text-decoration: none;
      font-size: 14px;
      color: #3498db;
    }

    a:hover {
      text-decoration: underline;
    }

    .no-tasks {
      text-align: center;
      color: #888;
      font-style: italic;
    }

    @media (max-width: 600px) {
      form {
        flex-direction: column;
        align-items: center;
      }

      input[type="text"] {
        width: 100%;
        max-width: 300px;
      }

      input[type="submit"] {
        width: 100%;
        max-width: 150px;
      }
    }
  </style>
</head>
<body>
<h2>📋 Danh sách công việc</h2>

<form action="ex8" method="post">
  <input type="text" name="task" placeholder="Nhập công việc mới..." required />
  <input type="submit" value="Thêm công việc" />
</form>

<ul>
  <%
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
    if (tasks != null && !tasks.isEmpty()) {
      for (int i = 0; i < tasks.size(); i++) {
        Task task = tasks.get(i);
  %>
  <li>
      <span class="<%= task.isCompleted() ? "completed" : "" %>">
        <%= task.getDescription() %>
      </span>
    <% if (!task.isCompleted()) { %>
    <a href="todo?complete=<%= i %>">✔ Hoàn thành</a>
    <% } %>
  </li>
  <%
    }
  } else {
  %>
  <li class="no-tasks">Không có công việc nào.</li>
  <%
    }
  %>
</ul>
</body>
</html>
