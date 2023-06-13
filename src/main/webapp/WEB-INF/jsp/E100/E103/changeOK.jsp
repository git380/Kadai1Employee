<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>変更完了</title>
</head>
<body>
<p>変更完了</p>
<form action="/Kadai1Employee/WelcomeServlet" method="post">
    <input type="hidden" name="emprole" value="${emprole}">
    <input type="submit" value="トップへ">
</form>
</body>
</html>