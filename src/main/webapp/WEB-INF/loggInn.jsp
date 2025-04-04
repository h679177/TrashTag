<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="design.css" rel="stylesheet" type="text/css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hurricane&family=Italiana&family=Notable&display=swap" rel="stylesheet">
    <title>Profil</title>
</head>

<body>
<nav>
    <a href="hjem">HJEM</a>
    <a href="vareSok">SØK</a>
    <a href="kart">KART</a>
    <a href="profil">PROFIL</a>
</nav>

<h1>Logg inn</h1>
<p style="color:red;">
    <c:forEach var="feilmelding" items="${feilmeldinger}">
        ${feilmelding}<br>
    </c:forEach></p>
<form action="login" method="post">
    <fieldset>
        <p>Brukernavn: <br><input type="text" name="brukernavn"></p>
        <p>Passord: <br><input type="password" name="passord"></p>
        <input type="submit" value="Logg inn"/><br>
    </fieldset>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>