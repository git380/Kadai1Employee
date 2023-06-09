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
<p>以下の処置情報を確定しますか？</p>
<p>患者ID: ${patId}</p>
<p>薬剤ID: ${medicineId}</p>
<p>数量: ${quantity}</p>
<p>実施日: ${impDate}</p>
<form action="TreatmentConfirmationServlet" method="post">
  <input type="hidden" name="patId" value="${patId}">
  <input type="hidden" name="medicineId" value="${medicineId}">
  <input type="hidden" name="quantity" value="${quantity}">
  <input type="hidden" name="impDate" value="${impDate}">
  <input type="submit" value="処置確定">
</form>
<form action="TreatmentDeleteServlet" method="post">
  <input type="submit" value="削除">
</form>
</body>
</html>