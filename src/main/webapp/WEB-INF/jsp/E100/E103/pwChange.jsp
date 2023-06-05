<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>パスワードの変更</title>
</head>
<body>
<h1>パスワードの変更</h1>
<form action="PwChangeServlet" method="post">
  <label>新しいパスワードを入力してください</label><br>
  PW:<input type="text" name="empPasswd"><br>
  <input type="submit" value="変更">
</form>
</body>
</html>
