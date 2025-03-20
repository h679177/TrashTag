<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
    <title>Leaflet Map</title>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <link href="design.css" rel="stylesheet" type="text/css" />
</head>
<body>
<nav>
    <a href="hjem.jsp">HJEM</a>
    <a href="vareSok.jsp">SØK</a>
    <a href="kart.jsp">KART</a>
    <a href="profil.jsp">PROFIL</a>
</nav>
<h1>Leaflet Map</h1>
<div id="map"></div>
<script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
<script src="kart.js"></script>
</body>
</html>

