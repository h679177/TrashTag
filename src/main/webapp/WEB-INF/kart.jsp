<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
    <title>Kart</title>
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
<h1>AVFALLSSTASJONER NÆR DEG</h1>
<div id="map"></div>
<script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
<script src="kart.js"></script>

<%@ include file="footer.jsp" %>
</body>
</html>

