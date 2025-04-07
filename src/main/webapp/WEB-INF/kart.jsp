<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
    <title>Returpunkt</title>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <link href="design.css" rel="stylesheet" type="text/css" />
    <link href="kart.css" rel="stylesheet" type="text/css" />
    < <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hurricane&family=Italiana&family=Notable&display=swap" rel="stylesheet">
</head>
<body>
    <!-- Navigasjonsbar -->
    <nav>
        <a href="hjem">HJEM</a>
        <a href="vareSok">SØK</a>
        <a href="kart">KART</a>
        <a href="profil">PROFIL</a>
    </nav>

    <h1>AVFALLSSTASJONER</h1>

    <h3>- finn en nær deg</h3>
    <h2>AVFALLSSTASJONER</h2>
    <c:if test="${not empty username}">
        <p style="display:inline;">innlogget som <c:out value="${username}"/></p>
        <form action="loggUt" method="post" style="display:inline;">
            <button type="submit">Logg Ut</button>
        </form>
    </c:if>
    <h3>FINN DE NÆR DEG</h3>
    <form method="post" action="avfallstypeValg">
        <c:forEach var="kategori" items="${kategorier}">
            <div>
                <input type="checkbox" name="kategori" value="${kategori.avfallstype}" />
                    ${kategori.avfallstype}
            </div>
        </c:forEach>

        <input type="text" id="koordinatInput" name="koordinat" placeholder="Postnr/koordinat">

        <button type="submit">Søk</button>
    </form>

<c:if test="${not empty returpunkter}">

    <!-- Table for Collection points -->
    <table class="styled-table">
        <thead>
            <tr>
                <th>NAVN</th>
                <th>POSTNUMMER</th>
                <th>KOORDINATER</th>
                <th>TAR IMOT</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="returpunkt" items="${returpunkter}">
                <tr>
                    <td>${returpunkt.navn}</td>
                    <td>${returpunkt.postnummer}</td>
                    <td>${returpunkt.koordinater}</td>
                    <td>
                        <c:forEach var="type" items="${returpunkt.avfallstype}">
                        ${type}, </c:forEach>
                    </td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

    <!-- Kartet vises her -->
    <div id="map"></div>

    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
    <script src="kart.js"></script>

    <%@ include file="footer.jsp" %>
</body>
</html>

