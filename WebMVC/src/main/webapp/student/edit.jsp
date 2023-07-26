<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/students?action=edit" method="post">
    <input type="text" name="id" placeholder="Id" value="${student.id}" disabled>
    <input type="text" name="name" placeholder="Name" value="${student.name}">
    <input type="number" name="age" placeholder="Age" value="${student.age}">
    <input type="text" name="image" placeholder="Image" value="${student.image}">
    <button>Sửa</button>
</form>
</body>
</html>
