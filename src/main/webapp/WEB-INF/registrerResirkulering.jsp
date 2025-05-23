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
	<title>Registrer resirkulering</title>
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

<c:if test="${not empty username}">
    <div class="logout-container">
        <p class="logout-button"><c:out value="${username}"/></p>
        <form action="loggUt" method="post">
            <button type="submit" class="logout-btn">Logg Ut</button>
        </form>
    </div>
</c:if>

<h1 style="margin-top: 100px" class="profil-header">REGISTRER</h1>

<p style="color:red;">
    <c:forEach var="feilmelding" items="${feilmeldinger}">
        ${feilmelding}<br>
    </c:forEach></p>

<form method="post" action="registrerResirkulering" class="fyllInn">
    <fieldset>
        <label for="avfallstype">Avfallstype</label>
        <select id="avfallstype" name="avfallstype">
            <c:forEach var="kategori" items="${kategorier}">
                <option value="${kategori.avfallstype}">${kategori.avfallstype}</option>
            </c:forEach>
        </select>
        <br/><br/>

        <input type="text" id="vektInput" name="vekt" placeholder="Vekt">
        <br/><br/>
        <button type="submit" class="darkgreen-btn">Registrer</button>
    </fieldset>


    <c:if test="${not empty melding}">
        <div style="color: green; margin-top: 10px;">
                ${melding}
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/profil" method="get">
            <button type="submit" class="darkgreen-btn">Tilbake til profil</button>
        </form>

</form>

<%@ include file="footer.jsp" %>

</body>
</html>