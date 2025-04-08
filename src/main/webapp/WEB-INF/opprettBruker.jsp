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

<h2>Opprett bruker</h2>
<p style="color:red;">

    <c:if test="${not empty feilmeldinger}">
        <c:forEach var="feilmelding" items="${feilmeldinger}">
            ${feilmelding}<br>
        </c:forEach>
    </c:if>
</p>

<form action="lagBruker" method="post" id="bruker">
    <fieldset>
        <p>Brukernavn<br>
            <input type="text" name="brukernavn" value="${bruker.brukernavn}">
        </p>
        <p>Fornavn<br>
            <input type="text" name="fornavn" value="${bruker.fornavn}">
        </p>
        <p>Etternavn<br>
            <input type="text" name="etternavn" value="${bruker.etternavn}">
        </p>
        <p>Postnummer<br>
            <input type="text" name="postnummer" value="${bruker.postnummer}">
        </p>
        <p>Gatenavn<br>
            <input type="text" name="gatenavn" value="${bruker.gatenavn}">
        </p>
        <p>Passord<br>
            <input type="password" name="passord">
        </p>
        <p>Repetert Passord<br>
            <input type="password" name="repPassord">
        </p>
        <input type="submit" value="Opprett bruker"/>
    </fieldset>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>