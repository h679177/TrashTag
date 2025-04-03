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
<div class="banner-img">
    <div class="container">
        <div class="topnav">
            <a href="hjem">HJEM</a>
            <a href="vareSok">SØK</a>
            <a href="kart">KART</a>
            <a href="profil">PROFIL</a>
        </div>
    </div>
</div>

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