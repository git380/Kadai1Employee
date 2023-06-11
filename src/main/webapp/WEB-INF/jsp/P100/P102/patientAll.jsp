<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>検索結果</title>
</head>
<body>
<h1>変更する患者を選択してください</h1>
<table>
  <tr>
    <th>患者ID</th>
    <th>姓</th>
    <th>名</th>
    <th>保険証記号番号</th>
    <th>有効期限</th>
    <th>変更</th>
  </tr>

  <c:forEach var="pat" items="${patients}">
    <tr>
      <td>${pat.patid}</td>
      <td>${pat.patfname}</td>
      <td>${pat.patlname}</td>
      <td>${pat.hokenmei}</td>
      <td>${pat.hokenexp}</td>
      <td>
        <form action="/Kadai1Employee/PatientUpdateServlet" method="get">
          <input type="hidden" name="patId" value="${pat.patid}">
          <input type="hidden" name="patFname" value="${pat.patfname}">
          <input type="hidden" name="patLname" value="${pat.patlname}">
          <input type="hidden" name="hokenmei" value="${pat.hokenmei}">
          <input type="hidden" name="hokenexp" value="${pat.hokenexp}">
          <input type="submit" value="変更">
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
