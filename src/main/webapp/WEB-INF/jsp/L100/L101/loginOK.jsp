<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>スッキリ商店</title>
</head>
<body>
<p>ようこそ<c:out value="${empId}"/>さん</p>
<a href="/Kadai1Employee/WelcomeServlet">トップへ</a>
</body>
</html>