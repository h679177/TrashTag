<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="design.css" rel="stylesheet" type="text/css" />
    <link href="profil.css" rel="stylesheet" type="text/css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hurricane&family=Italiana&family=Notable&display=swap" rel="stylesheet">
    <title>Profil</title>
</head>

<body>
<div class="container">
    <div class="topnav">
        <a href="hjem">HJEM</a>
        <a href="vareSok">SØK</a>
        <a href="kart">KART</a>
        <a href="profil">PROFIL</a>
    </div>
</div>

<h1 style="margin-top: 100px" class="profil-header">Profil</h1>
<h3>følg din egen utvikling</h3>
<div class="main-content">
    <c:if test="${empty username}">
        <form action="${pageContext.request.contextPath}/loggInn" method="get">
            <button style="margin-top: 20px;" type="submit" class="profil-button">Logg inn</button>
        </form>
        <form action="${pageContext.request.contextPath}/opprettBruker" method="get">
            <button style="margin-bottom: 50px;"type="submit" class="profil-button">Opprett bruker</button>
        </form>

    </c:if>
    <c:if test="${not empty username}">
        <div class="logout-container">
            <p class="logout-button"><c:out value="${username}"/></p>
            <form action="loggUt" method="post">
                <button type="submit" class="logout-btn">Logg Ut</button>
            </form>
        </div>

        <form method="get" action="registrerResirkulering">
                <button type="submit" class="profil-button">Ny registrering</button>
        </form>

        <c:if test="${not empty bruker}">
        <div class="bruker-info" style="display: block;">
        <h4>Din informasjon</h4>
        <p><i>${bruker.brukernavn}</i></p>
        <p><i>${bruker.fornavn} ${' '} ${bruker.etternavn}</i></p>
            <p><i>${bruker.gatenavn}, ${bruker.postnummer}</i></p>
            <c:if test="${bruker.deler_data == true}">
                <p style="display:inline;">Ditt nabolag: <c:out value="${bruker.nabolag}"/></p>
            </c:if>
            <c:if test="${bruker.deler_data == false}">
                <p><i>Du er ikke med i et nabolag</i></p>
            </c:if>
            <br>
            <form action="${pageContext.request.contextPath}/redigerBruker" method="get">
                <button type="submit" class="profil-button">Rediger informasjon</button>
            </form>

        </div>
        </c:if>
    </c:if>
</div>

    <%@ include file="footer.jsp" %>
</body>
</html>