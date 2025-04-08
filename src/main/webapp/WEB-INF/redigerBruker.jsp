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

<h1>Rediger profil</h1>
<c:if test="${empty username}">
    <form action="${pageContext.request.contextPath}/loggInn" method="get">
        <button type="submit">Logg inn</button>
    </form>
    <form action="${pageContext.request.contextPath}/opprettBruker" method="get">
        <button type="submit">Opprett bruker</button>
    </form>
</c:if>

<form action="oppdaterBruker" method="post" id="redigerBruker">
<fieldset>
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
    <input type="submit" value="Oppdater bruker"/>
    <form method="post" action="slettBruker" style="display:inline;" onsubmit="return confirmDelete();">
        <button type="submit">Slett Bruker</button>
    </form>
</fieldset>
</form>
<script>
    function confirmDelete() {
        return confirm("Er du sikker på at du vil slette brukeren? Dette kan ikke angres, og alle lagrede data vil gå tapt.");
    }
</script>


<%@ include file="footer.jsp" %>
</body>
</html>