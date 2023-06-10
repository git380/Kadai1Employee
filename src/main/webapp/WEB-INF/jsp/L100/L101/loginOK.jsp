<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>従業員画面</title>
</head>
<body>
<c:if test="${emprole != 0}">
    <input type="hidden" name="emprole" value="${emprole}">
    <p>ようこそ<c:out value="${empId}"/>さん</p>
    <a href="/Kadai1Employee/WelcomeServlet">トップへ</a>
</c:if>
<c:if test="${emprole == 0}">
    <p>管理者です。ログアウトしてください。</p>
    <li><a href="/Kadai1Employee/LogoutServlet">ログアウト</a></li>
</c:if>
</body>
</html>