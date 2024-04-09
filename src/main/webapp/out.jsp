<%@ page import="by.bsuir.lr2.Series" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Series List</title>
</head>
<body>

<h2>Series List</h2>

<form action="/LR2-1.0-SNAPSHOT/series" method="get">
    <label for="rating">Select Rating:</label>
    <input type="text" name="rating" value="<%= request.getAttribute("selectedRating") == null ? 0 : request.getAttribute("selectedRating")  %>">
    <input type="submit" value="Filter">
</form>

<%
    List<Series> seriesList = (List<Series>) request.getAttribute("seriesList");
    for (Series series : seriesList) {
%>
<p>Name: <%= series.getName() %>, Rating: <%= series.getRating() %>, Numbers: <%= series.getNumbers() %>
    <a href="<%= request.getContextPath() %>/edit?name=<%= series.getName()  %>">
        Edit
    </a>
</p>
<%
    }
%>

</body>
</html>
