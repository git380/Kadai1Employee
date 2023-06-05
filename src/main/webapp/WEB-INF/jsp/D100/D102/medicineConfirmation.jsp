<%@ page import="D100.D101.model.Medicine" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Medicine Confirmation</title>
</head>
<body>
<h1>Medicine Confirmation</h1>
<table>
  <tr>
    <th>Medicine</th>
    <th>Quantity</th>
    <th>Action</th>
  </tr>
  <% Map<Medicine, Integer> medicineQuantityMap = (Map<Medicine, Integer>) request.getAttribute("medicineQuantityMap");
    for (Map.Entry<Medicine, Integer> entry : medicineQuantityMap.entrySet()) { %>
  <tr>
    <td><%= entry.getKey().getMedicineName() %></td>
    <td><%= entry.getValue() %> <%= entry.getKey().getUnit() %></td>
    <td>
      <form action="MedicineDeletionServlet" method="post">
        <input type="hidden" name="medicineId" value="<%= entry.getKey().getMedicineId() %>">
        <button type="submit">Delete</button>
      </form>
    </td>
  </tr>
  <% } %>
</table>
<form action="MedicineConfirmationServlet" method="post">
  <button type="submit">Confirm</button>
</form>
</body>
</html>
