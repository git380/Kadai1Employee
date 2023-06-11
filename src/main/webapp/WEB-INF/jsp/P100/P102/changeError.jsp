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
    <p>日付を入力してください。</p>
</c:if>
<c:if test="${error == 1}">
    <p>新しい日付を入力してください。</p>
</c:if>
<form action="/Kadai1Employee/PatientUpdateServlet" method="get">
    <input type="hidden" name="patId" value="${patId}">
    <input type="hidden" name="patFname" value="${patFname}">
    <input type="hidden" name="patLname" value="${patLname}">
    <input type="hidden" name="hokenmei" value="${hokenmei}">
    <input type="hidden" name="hokenexp" value="${hokenexp}">
    <input type="submit" value="変更画面へ戻る">
</form>
</body>
</html>
