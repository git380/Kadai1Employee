<%@ page import="P100.P105.model.PatientSearch" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>検索結果</title>
</head>
<body>
<h1>検索結果</h1>
<table>
    <tr>
        <th>患者ID</th>
        <th>姓</th>
        <th>名</th>
        <th>保険名</th>
        <th>保険有効期限</th>
        <th>指示</th>
    </tr>

    <c:forEach var="pat" items="${patients}">
        <tr>
            <td>${pat.patid}</td>
            <td>${pat.patfname}</td>
            <td>${pat.patlname}</td>
            <td>${pat.hokenmei}</td>
            <td>${pat.hokenexp}</td>
            <td>
                <form action="/Kadai1Employee/TreatmentSelectionServlet" method="get">
                    <input type="hidden" name="patId" value="${pat.patid}">
                    <input type="submit" value="指示">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
