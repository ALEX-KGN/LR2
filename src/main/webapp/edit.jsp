<%@ page import="by.bsuir.lr2.Series" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Series</title>
</head>
<body>

<h2>Edit Series</h2>

<%
    Series series = (Series) request.getAttribute("param");
%>

<form action="/LR2-1.0-SNAPSHOT/series" method="post">
    <input type="hidden" name="action" value="edit">
    <label for="name">Series Name:</label>
    <input type="text" name="name" value="<%= series.getName() %>" readonly>
    <br>
    <label for="rating">New Rating:</label>
    <input type="text" name="rating" value="<%= series.getRating() %>" required>
    <br>
    <label for="numbers">New Number of Episodes:</label>
    <input type="text" name="numbers" value="<%= series.getNumbers() %>" required>
    <br>
    <input type="submit" value="Edit Series">
</form>

</body>
</html>
