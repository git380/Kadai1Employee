<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>エラー画面</title>
</head>
<body>
<h2 style="color: red">エラーが発生しました</h2>
<p>ID・パスワードをもう一度確認してください。</p>
<form action="/Kadai1Administrator/LoginServlet" method="get">
    <input type="submit" value="ログイン画面へ戻る">
</form>
</body>
</html>
