<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String contextPath = request.getContextPath();
    String error = (String) request.getAttribute("error");
    String usernamePrefill = (String) request.getAttribute("usernamePrefill");
    if (usernamePrefill == null) {
        usernamePrefill = "";
    }
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
</head>
<body>
<h1>Inscription</h1>

<% if (!usernamePrefill.isEmpty()) { %>
<p>Username mémorisé: <strong><%= usernamePrefill %></strong></p>
<% } %>

<% if (error != null) { %>
<p style="color: red;"><%= error %></p>
<% } %>

<form method="post" action="<%= contextPath %>/register">
    <label for="username">Username:</label>
    <input id="username" name="username" type="text" value="<%= usernamePrefill %>" required>
    <button type="submit">Commencer l'examen</button>
</form>
</body>
</html>
