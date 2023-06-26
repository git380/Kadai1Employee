<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>エラー画面</title>
</head>
<body>
<h2 style="color: red">エラーが発生しました</h2>
<c:if test="${error == 0}">
    <p>IDが一致しています。</p>
</c:if>
<c:if test="${error == 1}">
    <p>新しい日付を入力してください。</p>
</c:if>
<form action="/Kadai1Employee/PatientRegistrationServlet" method="get">
    <input type="submit" value="登録画面へ戻る">
</form>
</body>
</html>
