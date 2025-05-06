<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giới Thiệu Cấu Trúc Dự Án Java Web (Gradle)</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f9f9f9;
            color: #333;
            line-height: 1.6;
        }
        h1 {
            color: #2c3e50;
        }
        h2 {
            margin-top: 30px;
            color: #34495e;
        }
        code {
            background-color: #eee;
            padding: 2px 4px;
            border-radius: 3px;
        }
        ul {
            margin-left: 20px;
        }
    </style>
</head>
<body>
<h2>Giải thích cấu trúc thư mục dự án Java Web sử dụng Gradle:</h2>

<ul>
    <li><strong><code>src/main/java</code></strong>: Chứa mã nguồn Java như Servlet, Filter, Listener,…</li>
    <li><strong><code>src/main/resources</code></strong>: Dành cho các tệp cấu hình (ví dụ: log4j.properties, messages.properties,…). Trong ứng dụng web đơn giản có thể không dùng đến.</li>
    <li><strong><code>src/main/webapp</code></strong>: Chứa giao diện người dùng như các tệp <code>.jsp</code>, <code>.html</code>, <code>.css</code>, <code>.js</code> và thư mục <code>WEB-INF</code>.</li>
    <li><strong><code>src/main/webapp/WEB-INF</code></strong>: Chứa tệp cấu hình web như <code>web.xml</code>. Các tệp trong thư mục này không thể truy cập trực tiếp từ trình duyệt.</li>
</ul>

<h2>Cách hoạt động:</h2>
<p>Khi ứng dụng được triển khai lên server (Tomcat), trình duyệt sẽ gửi yêu cầu đến <code>index.jsp</code>. Trang này hiển thị lời chào và giải thích về cấu trúc thư mục của dự án.</p>

</body>
</html>
