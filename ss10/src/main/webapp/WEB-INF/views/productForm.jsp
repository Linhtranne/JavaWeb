<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h2>Enter Product Information</h2>
<form:form action="addProduct" modelAttribute="product" method="post">
    <label for="name">Name:</label>
    <form:input path="name" id="name" /><br/><br/>

    <label for="price">Price:</label>
    <form:input path="price" id="price" /><br/><br/>

    <label for="description">Description:</label>
    <form:input path="description" id="description" /><br/><br/>

    <button type="submit">Add</button>
</form:form>
</body>
</html>