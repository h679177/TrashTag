<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
    <title>Returpunkt</title>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <link href="design.css" rel="stylesheet" type="text/css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Italiana&display=swap" rel="stylesheet">
</head>
<body>
<nav>
    <a href="hjem">HJEM</a>
    <a href="vareSok">SØK</a>
    <a href="kart">KART</a>
    <a href="profil">PROFIL</a>
</nav>
<!-- Navigasjonsbar -->

<!-- Tittel for siden -->
<h1>Returpunkt</h1>

<!-- Kartet vises her -->
<div id="map"></div>
<script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>

<script src="kart.js"></script>

<h2>Collection Points</h2>
<form method="post" action="avfallstypeValg">
    <c:forEach var="kategori" items="${kategorier}">
    <div>
        <input type="checkbox" name="kategori" value="${kategori.avfallstype}" />
            ${kategori.avfallstype}
    </div>
</c:forEach>
<input type="submit" value="Submit" />
</form>

<form method="get">
	<input type="text" id="koordInput" name="koordinat" placeholder="Koordinater">

	<button type="submit">Søk</button>
</form>

<c:if test="${not empty returpunkter}">
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Postal Code</th>
            <th>Coordinates</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="returpunkt" items="${returpunkter}">
            <tr>
                <td>${returpunkt.navn}</td>
                <td>${returpunkt.postnummer}</td>
                <td>${returpunkt.koordinater}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<%@ include file="footer.jsp" %>
</body>
</html>

