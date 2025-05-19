<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<h2>Enter User Information</h2>
<form:form action="submit" modelAttribute="user" method="post">
    <label for="name">Name:</label>
    <form:input path="name" id="name" /><br/><br/>

    <label for="age">Age:</label>
    <form:input path="age" id="age" /><br/><br/>

    <label for="address">Address:</label>
    <form:input path="address" id="address" /><br/><br/>

    <button type="submit">Submit</button>
</form:form>
</body>
</html>