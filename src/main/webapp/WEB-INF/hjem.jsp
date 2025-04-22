<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="design.css" rel="stylesheet" type="text/css" />
    <link href="hjem.css" rel="stylesheet" type="text/css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hurricane&family=Italiana&family=Notable&display=swap" rel="stylesheet">
    <title>Hjem</title>
</head>

<body>
<div class="TrashTagImage">
    <div class="container">
        <div class="topnav">
            <a href="hjem">HJEM</a>
            <a href="vareSok">SØK</a>
            <a href="kart">KART</a>
            <a href="profil">PROFIL</a>
        </div>
    </div>
</div>


<h1 class="hjem-header">TrashTag</h1>
<h3>for smartere resirkulering</h3>
<c:if test="${not empty username}">
    <p style="display:inline;">innlogget som <c:out value="${username}"/></p>
    <form action="loggUt" method="post" style="display:inline;">
        <button type="submit">Logg Ut</button>
    </form>
</c:if>



<!-- Scan bilde og knapp -->
<div class="scan-section">
    <h2>Skann en vare</h2>
    <p>Trykk for å bruke kameraet, og finn ut hvordan produktet skal resirkuleres.</p>
    <img src="images/ScanBilde.png" alt="Skann strekkode" class="scan-image">
    <a href="vareSok">
        <button class="scan-button">SKANN</button>
    </a>
</div>


<div class="row high">
    <div class="column high">
        <h2>Hvordan fungerer<br /> det?</h2>
        <p>
            TrashTag er en applikasjon som gir deg en oversikt over<br />
            hvor mye du resirkulerer, og har hjelpemidler som<br />
            gjør resirkulering enkelt og effektivt i hverdagen.
        </p>
        <p>
            Ved å veie avfallet ditt og registrere hvilket materiale det<br />
            er når du kaster det, vil du få opp statestikk på brukerkontoen din.<br />
            Her vil du se en oversikt over hva og hvor mye du resirkulerer,<br />
            og den totale mengden avfall du som forbruker produserer. <br />
            Dette vil gjøre det lettere å se hvor man kan gjøre noe bedre, <br />
            og om du er flinkere enn naboene dine (om du skulle ønske å dele <br />
            statestikken din). Målet er å gjøre befolkningen i Norge mer <br />
            bevisste på sitt avfallsmønster, samtidig som de får veiledning<br />
            i hvordan ulike produkter skal resirkuleres riktig.
        </p>
        <p>
            TrashTag handler ikke bare om avfallshåndtering – det er en<br />
            plattform som ønsker å inspirerer til en mer bærekraftig livsstil.<br />
            Vi vil å gi brukerne innsikt, veiledning og praktiske verktøy<br />
            for smartere resirkulering!
        </p>
    </div>
    <div class="column high">
        <p>
            <img src="images/plastikk.jpg" alt="Ulikt farget plastposer" class="column-img">
        </p>
    </div>
</div>

<div class="row low">
    <div class="column low">
        <h2>Varesøk</h2>
        <h3>- FINN UT HVORDAN DU RESIRKULERER RIKTIG</h3>
    </div>
    <div class="column low">
        <h2>Personlig Profil</h2>
        <h3>- FØLG DIN EGEN UTVIKLING</h3>
    </div>
    <div class="column low">
        <h2>Kart</h2>
        <h3>- FINN DIN NÆRMESTE AVFALLSSTASJON</h3>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>