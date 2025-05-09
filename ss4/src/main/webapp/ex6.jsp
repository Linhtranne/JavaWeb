<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

  class Student {
    private int id;
    private String name;
    private int age;
    private double averageScore;

    public Student(int id, String name, int age, double averageScore) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.averageScore = averageScore;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    public double getAverageScore() {
      return averageScore;
    }
  }

  List<Student> studentList = new ArrayList<>();
  studentList.add(new Student(1, "A", 20, 8.5));
  studentList.add(new Student(2, "B", 21, 6.8));
  studentList.add(new Student(3, "C", 22, 7.2));
  studentList.add(new Student(4, "D", 19, 5.5));

  int count = 0;
  for (Student student : studentList) {
    if (student.getAverageScore() > 7.0) {
      count++;
    }
  }

  request.setAttribute("studentList", studentList);
  request.setAttribute("count", count);
%>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
</head>
<body>
<h2>Danh Sách Sinh Viên</h2>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Tuổi</th>
    <th>Điểm Trung Bình</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="student" items="${studentList}">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.age}</td>
      <td>${student.averageScore}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><strong>Số lượng sinh viên có điểm trung bình lớn hơn 7.0:</strong> ${count}</p>
</body>
</html>