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
    <link rel="stylesheet"  href="/css/index.css" type="text/css">
</head>
<body>
<a href="http://localhost:8080/students?action=create">Thêm mới sinh viên</a>
<form action="http://localhost:8080/students?action=search" method="post">
    <input placeholder="search" name="searchItem">
    <button>Tìm Kiếm</button>
</form>

<table>
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
            <td><a href="http://localhost:8080/students?action=edit&id=${student.id}">Sửa</a></td>
            <td><a href="http://localhost:8080/students?action=delete&id=${student.id}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
