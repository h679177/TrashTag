<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="design.css" rel="stylesheet" type="text/css" />
    <title>Profil</title>
</head>

<body>
<nav>
    <a href="hjem">Hjem</a> |
    <a href="vareSok">Søk</a> |
    <a href="kart">Kart</a> |
    <a href="profil">Profil</a>
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