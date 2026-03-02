<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String contextPath = request.getContextPath();
    Object currentAnswer = request.getAttribute("currentAnswer");
    String answerValue = currentAnswer == null ? "" : String.valueOf(currentAnswer);
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Examen - Question 1</title>
</head>
<body>
<h1>Examen - Page 1</h1>
<p>Question 1: Combien fait <strong>7 + 5</strong> ?</p>

<% if (error != null) { %>
<p style="color: red;"><%= error %></p>
<% } %>

<form method="post" action="<%= contextPath %>/exam1">
    <label for="answer">Réponse:</label>
    <input id="answer" name="answer" type="number" value="<%= answerValue %>" required>
    <button type="submit">Suivant</button>
</form>

<p><a href="<%= contextPath %>/logout">Logout</a></p>
</body>
</html>
