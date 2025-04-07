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

<h1>Profil</h1>
<c:if test="${not empty username}">
    <p style="display:inline;">innlogget som <c:out value="${username}"/></p>
    <form action="loggUt" method="post" style="display:inline;">
        <button type="submit">Logg Ut</button>
    </form>
</c:if>
<form method="post" action="registrerResirkulering">

    <select name="avfallstype">
        <c:forEach var="kategori" items="${kategorier}">
            <option value="${kategori.avfallstype}">${kategori.avfallstype}</option>
        </c:forEach>
    </select>
    <br/><br/>

    <input type="number" id="vektInput" name="vekt" placeholder="Vekt">

    <button type="submit">Registrer</button>
</form>

    <%@ include file="footer.jsp" %>
</body>
</html>