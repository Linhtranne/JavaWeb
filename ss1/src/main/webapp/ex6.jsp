<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Đăng ký vé xe</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f2f2f2;
      padding: 40px;
      display: flex;
      justify-content: center;
    }

    .form-container {
      background-color: #ffffff;
      padding: 30px 40px;
      border-radius: 10px;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 500px;
    }

    h2 {
      text-align: center;
      color: #333;
      margin-bottom: 30px;
    }

    label {
      display: block;
      margin-bottom: 8px;
      color: #555;
      font-weight: bold;
    }

    input[type="text"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
      box-sizing: border-box;
      font-size: 16px;
    }

    input[type="submit"] {
      width: 100%;
      background-color: #28a745;
      color: white;
      padding: 12px;
      border: none;
      border-radius: 5px;
      font-size: 16px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
      background-color: #218838;
    }
  </style>
</head>
<body>
<div class="form-container">
  <h2>Đăng ký vé xe cho học sinh</h2>
  <form action="ex6" method="post">
    <label for="fullName">Họ và tên:</label>
    <input type="text" name="fullName" id="fullName" required>

    <label for="className">Lớp:</label>
    <input type="text" name="className" id="className" required>

    <label for="vehicleType">Loại xe:</label>
    <input type="text" name="vehicleType" id="vehicleType" required>

    <label for="plateNumber">Biển số xe:</label>
    <input type="text" name="plateNumber" id="plateNumber" required>

    <input type="submit" value="Đăng ký">
  </form>
</div>
</body>
</html>
