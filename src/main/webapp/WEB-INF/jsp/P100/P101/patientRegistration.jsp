<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>患者登録</title>
</head>
<body>
<h1>患者登録</h1>
<form action="PatientRegistrationServlet" method="post">
  <label for="empId">患者ID:</label>
  <input type="text" id="empId" name="patId"><br>
  <label for="patFname">名:</label>
  <input type="text" id="patFname" name="patFname"><br>
  <label for="patLname">姓:</label>
  <input type="text" id="patLname" name="patLname"><br>
  <label for="hokenmei">保険証記号番号:</label>
  <input type="number" id="hokenmei" name="hokenmei"><br>
  <label for="hokenexp">有効期限:</label>
  <input type="date" id="hokenexp" name="hokenexp"><br>
  <input type="submit" value="登録">
</form>
</body>
</html>
