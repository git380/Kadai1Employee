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
        <li><a href="/Kadai1Employee/PwChangeServlet">パスワードの変更</a></li>
        <li><a href="/Kadai1Employee/PatientRegistrationServlet">患者を登録する</a></li>
        <li><a href="/Kadai1Employee/PatientUpdateServlet">患者の保険情報の変更</a></li>
        <li><a href="/Kadai1Employee/PatientSearchServlet">患者の全検索</a></li>
        <li><a href="/Kadai1Employee/TreatmentSelectionServlet">薬投与を指示</a></li>
        <li><a href="/Kadai1Employee/TreatmentDeletionServlet">薬投与を削除</a></li>
        <li><a href="/Kadai1Employee/TreatmentConfirmationServlet">薬投与の確定</a></li>
    </c:if>
</ul>
</body>
</html>