<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>処置確定画面</title>
</head>
<body>
<h1>処置確定画面</h1>
<p>以下の処置情報を確定しました。</p>
<p>患者ID: ${patId}</p>
<p>薬剤ID: ${medicineId}</p>
<p>数量: ${quantity}</p>
<p>実施日: ${impDate}</p>
<form action="/Kadai1Employee/WelcomeServlet" method="post">
    <input type="hidden" name="emprole" value="2">
    <input type="submit" value="トップへ">
</form>
</body>
</html>