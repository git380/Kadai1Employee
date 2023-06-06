<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>従業員ログイン</title>
</head>
<body>
<form action="/Kadai1Employee/LoginServlet" method="post">
    ユーザーID:<input type="text" name="empId"><br>
    パスワード:<input type="password" name="empPasswd"><br>
    <input type="submit" value="ログイン">
</form>
</body>
</html>