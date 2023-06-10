<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>従業員画面</title>
</head>
<body>
<h1>ようこそ!従業員画面です。</h1>
<ul>
    <c:if test="${empty sessionScope.empId}">
        <li><a href="/Kadai1Employee/LoginServlet">ログイン</a></li>
    </c:if>
    <c:if test="${not empty sessionScope.empId}">
        <li><a href="/Kadai1Employee/LogoutServlet">ログアウト</a></li>
        <% int emprole = (int) request.getAttribute("emprole"); %>
        <% if (emprole == 1) { %>
        <li><a href="/Kadai1Employee/PwChangeServlet">パスワードの変更</a></li>
        <li><a href="/Kadai1Employee/PatientRegistrationServlet">患者を登録する</a></li>
        <li><a href="/Kadai1Employee/PatientUpdateServlet">患者の保険情報の変更</a></li>
        <li><a href="/Kadai1Employee/PatientExpirationServlet">保証が切れているか</a></li>
        <% } else { %>
        <li><a href="/Kadai1Employee/PwChangeServlet">パスワードの変更</a></li>
        <li><a href="/Kadai1Employee/PatientSearchServlet">患者の全検索</a></li>
        <% } %>
    </c:if>
</ul>
</body>
</html>