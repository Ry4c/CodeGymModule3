
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/students?action=create" method="post">
    <input type="text" name="id" placeholder="Id">
    <input type="text" name="name" placeholder="Name">
    <input type="number" name="age" placeholder="Age">
    <input type="text" name="image" placeholder="Image">
    <button>Thêm mới</button>
</form>
</body>
</html>
