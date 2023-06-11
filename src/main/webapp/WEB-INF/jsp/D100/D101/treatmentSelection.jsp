<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>薬投与指示画面</title>
</head>
<body>
<h1>薬投与指示画面</h1>
<form action="TreatmentSelectionServlet" method="post">
    患者ID:<c:out value="${patId}"/><br>
    <input type="hidden" name="patId" value="${patId}">
    <label for="medicine">薬剤名:</label>
    <select name="medicineId" id="medicine">
        <c:forEach var="medicine" items="${medicines}">
            <option value="${medicine.medicineId}">${medicine.medicineName}</option>
        </c:forEach>
    </select><br>
    数量:<input type="number" name="quantity"><br>
    実施日:<input type="date" name="impDate"><br>
    <input type="submit" value="処置指示" disabled>
</form>
<script>
    const form = document.querySelector('form');
    const submitButton = form.querySelector('input[type=submit]');
    const inputs = form.querySelectorAll('input[type=number], input[type=date]');

    inputs.forEach(input => {
        input.addEventListener('input', () => {
            const empty = Array.from(inputs).some(input => !input.value);
            submitButton.disabled = empty;
        });
    });
</script>
</body>
</html>

