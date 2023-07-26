<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
<%--    <link rel="stylesheet"  href="D:\Java\Module3\Web\WebMVC\src\main\webapp\css\index.css">--%>
    <style>
        img {
            width: 70px;
            height: 70px;
        }
    </style>
</head>
<body>
<a href="http://localhost:8080/students?action=create">Thêm mới sinh viên</a>

<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Age</td>
        <td>Image</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.age}</td>
            <td>${student.name}</td>
            <td><img src="${student.image}" alt=""></td>
            <td>Sửa</td>
            <td><a href="http://localhost:8080/students?action=delete&id=${student.id}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
