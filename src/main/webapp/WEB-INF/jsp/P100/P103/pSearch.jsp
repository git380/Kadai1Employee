<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>患者名検索</title>
</head>
<body>
<h1>患者名検索</h1>
<form action="PatientSearchServlet" method="post">
    <label for="patfname">姓：</label>
    <input type="text" name="patfname" id="patfname" required><br>
    <label for="patlname">名：</label>
    <input type="text" name="patlname" id="patlname" required><br>
    <input type="submit" value="検索">
</form>
</body>
</html>
