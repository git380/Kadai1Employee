<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>薬投与指示画面</title>
</head>
<body>
<h1>薬投与指示画面</h1>
<form action="prescriptionInstruction" method="post">
    患者ID:<input type="text" name="patId"><br>
    薬剤ID:<input type="text" name="medicineId"><br>
    数量:<input type="text" name="quantity"><br>
    実施日:<input type="date" name="impDate"><br>
    <input type="submit" value="処置指示">
</form>
</body>
</html>

