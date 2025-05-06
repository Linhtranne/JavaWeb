<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Các thành phần hệ thống Web</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            line-height: 1.6;
        }
        h2 {
            color: #2c3e50;
        }
        ul {
            margin-left: 20px;
        }
        li {
            margin-bottom: 8px;
        }
        .section {
            margin-bottom: 40px;
        }
    </style>
</head>
<body>
<img src="./images/352feee6-b19e-42f9-b351-82b9311af7dc.png" alt="logo" width="700px">
<h2>1. Các thành phần chính</h2>
<div class="section">
    <h2>Các Thành Phần Chính & Chức Năng:</h2>
    <h3>Client (Trình duyệt/Web App)</h3>
    <ul>
        <li>Gửi yêu cầu HTTP (GET, POST,...) đến ứng dụng.</li>
        <li>Hiển thị giao diện người dùng (UI).</li>
    </ul>

    <h3>Web Server (Tomcat, Nginx, Apache HTTP Server)</h3>
    <ul>
        <li>Nhận và xử lý yêu cầu HTTP từ client.</li>
        <li>Gửi các tệp tĩnh (HTML, CSS, JS).</li>
        <li>Chuyển tiếp các yêu cầu động đến Application Server (Servlet, JSP,...).</li>
    </ul>

    <h3>Application Server (Java EE, Spring Boot, WildFly, GlassFish)</h3>
    <ul>
        <li>Xử lý logic nghiệp vụ của ứng dụng.</li>
        <li>Thực thi Servlet, EJB, Controller trong Spring.</li>
        <li>Giao tiếp với Database để lấy hoặc ghi dữ liệu.</li>
    </ul>

    <h3>Database (MySQL, PostgreSQL, Oracle,...)</h3>
    <ul>
        <li>Lưu trữ và truy xuất dữ liệu.</li>
        <li>Được truy cập thông qua ORM như Hibernate hoặc JDBC.</li>
    </ul>
</div>

<div class="section">
    <h2>📖 Mối Quan Hệ Tương Tác Giữa Các Thành Phần:</h2>
    <p>
        Khi người dùng sử dụng trình duyệt (Client) để truy cập vào một ứng dụng web, yêu cầu HTTP sẽ được gửi đến Web Server.
        Web Server sẽ xác định xem yêu cầu là tĩnh hay động. Nếu là tĩnh (ví dụ: ảnh, file CSS), nó sẽ phản hồi trực tiếp.
        Nếu là yêu cầu động (ví dụ: đăng nhập, truy vấn dữ liệu), Web Server sẽ chuyển tiếp yêu cầu đến Application Server.
        Application Server tiếp nhận yêu cầu, xử lý logic nghiệp vụ và truy cập Database để lấy hoặc cập nhật dữ liệu.
        Sau đó, kết quả được gửi ngược lại qua Web Server về cho Client dưới dạng HTML, JSON hoặc các định dạng phù hợp.
    </p>
</div>
</body>
</html>
