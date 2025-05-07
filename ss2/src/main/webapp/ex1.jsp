<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Mô tả vòng đời Servlet</title>
  <style>
    body {
      font-family: "Segoe UI", sans-serif;
      background-color: #f9fafb;
      color: #2c3e50;
      padding: 40px 20px;
      margin: 0;
    }

    .container {
      max-width: 800px;
      margin: auto;
      background: #ffffff;
      border-radius: 12px;
      box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08);
      padding: 30px;
    }

    h1 {
      text-align: center;
      color: #2980b9;
      margin-bottom: 30px;
    }

    ul {
      list-style-type: none;
      padding-left: 0;
    }

    li {
      background-color: #ecf0f1;
      margin-bottom: 12px;
      padding: 14px 18px;
      border-left: 6px solid #2980b9;
      border-radius: 6px;
      font-size: 16px;
    }

    @media (max-width: 600px) {
      .container {
        padding: 20px;
      }

      li {
        font-size: 15px;
        padding: 12px 14px;
      }
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Vòng đời của Servlet</h1>
  <ul>
    <%
      String[] lifecycleSteps = (String[]) request.getAttribute("lifecycleSteps");
      if (lifecycleSteps != null) {
        for (String step : lifecycleSteps) {
    %>
    <li><%= step %></li>
    <%
        }
      }
    %>
  </ul>
</div>
</body>
</html>
