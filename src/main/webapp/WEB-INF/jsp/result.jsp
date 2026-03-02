<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String contextPath = request.getContextPath();
    Object username = request.getAttribute("username");
    Object score = request.getAttribute("score");
    Object total = request.getAttribute("total");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Résultat</title>
</head>
<body>
<h1>Résultat final</h1>
<p>Étudiant: <strong><%= username %></strong></p>
<p>Score: <strong><%= score %>/<%= total %></strong></p>

<p>
    <a href="<%= contextPath %>/register">Recommencer</a> |
    <a href="<%= contextPath %>/logout">Logout</a>
</p>
</body>
</html>
