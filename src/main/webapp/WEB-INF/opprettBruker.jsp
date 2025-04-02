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
<h1>Opprett bruker</h1>
<form action="lagBruker" method="post" id="bruker">
    <fieldset>
        <p>Brukernavn<br><input type="text" name="brukernavn" value=${bruker.brukernavn}></p>
        <p>Fornavn <br><input type="text" name="fornavn" value="${bruker.fornavn}"></p>
        <p>Etternavn<br><input type="text" name="etternavn" value="${bruker.etternavn}"></p>
        <p>Post nummer<br><input type="text" name="postnr" value="${bruker.postnr}"></p>
        <p>Gatenavn<br><input type="text" name="gatenavn" value="${bruker.gatenavn}"></p>
        <p>Passord<br><input type="password" name="passord"></p>
        <p>Repetert Passord<br><input type="password" name="repPassord"></p>

        <input type="submit" value="Opprett bruker"/>
    </fieldset>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>