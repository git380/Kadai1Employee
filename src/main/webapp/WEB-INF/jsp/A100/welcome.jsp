<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理者画面</title>
</head>
<body>
<h1>ようこそ!管理者画面です。</h1>
<ul>
    <c:if test="${empty sessionScope.empId}">
        <li><a href="/Kadai1Employee/LoginServlet">ログイン</a></li>
    </c:if>
    <c:if test="${not empty sessionScope.empId}">
        <li><a href="/Kadai1Employee/LogoutServlet">ログアウト</a></li>
        <li><a href="/Kadai1Employee/PwChangeServlet">パスワードの変更</a></li>
    </c:if>
</ul>
</body>
</html>