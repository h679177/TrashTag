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
<div class="container">
    <div class="topnav">
        <a href="hjem">HJEM</a>
        <a href="vareSok">SØK</a>
        <a href="kart">KART</a>
        <a href="profil">PROFIL</a>
    </div>
</div>

<h1>Profil</h1>
<c:if test="${empty username}">
    <form action="${pageContext.request.contextPath}/loggInn" method="get">
        <button type="submit">Logg inn</button>
    </form>
    <form action="${pageContext.request.contextPath}/opprettBruker" method="get">
        <button type="submit">Opprett bruker</button>
    </form>

</c:if>
<c:if test="${not empty username}">
    <p style="display:inline;">innlogget som <c:out value="${username}"/></p>
    <form action="loggUt" method="post" style="display:inline;">
        <button type="submit">Logg Ut</button>
    </form>

    <form method="get" action="registrerResirkulering">
            <button type="submit">Ny registrering</button>
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
            <button type="submit">Rediger informasjon</button>
        </form>

    </div>
    </c:if>
</c:if>

    <%@ include file="footer.jsp" %>
</body>
</html>