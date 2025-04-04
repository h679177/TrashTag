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


<h1>TrashTag</h1>
<h3>for smartere resirkulering</h3>
    <div class="text-container">
        <p>
            TrashTag er en applikasjon som hjelper deg med å få oversikt over
            hvor mye du resirkulerer, og ditt eget avfallsforbruk. Her finner du også
            informasjon om produkt, og hvordan du skal resirkulere det produktet
            til best mulig evne. Det er mye avfall som blir produsert i hver husstand i
            Norge i dag. Vi mener dette kan hjelpe med å gjøre oss mer bevisste på
            hvordan vi som forbukere kan gjøre små endringer i hverdagen, for
            sammen å skape en større innvirkning. Det begynner alltid i det små.
        </p>
    </div>


<!-- Scan bilde og knapp -->
<div class="scan-section">
    <h2>Skann en vare</h2>
    <img src="images/ScanBilde.png" alt="Skann strekkode" class="scan-image">
    <p>Trykk for å bruke kameraet og finn ut hvordan produktet skal resirkuleres</p>
    <a href="vareSok">
        <button class="scan-button">Skann vare</button>
    </a>
</div>


<div class="row">
    <div class="column-img"><img src="/images/grid1.jpg" alt="Description"></div>
    <div class="column">
        <h2>Hvordan fungerer det?</h2>
        <p>
            Ved å veie avfallet ditt og registrere hvilket materiale det er når du
            kaster det, vil du få opp statestikk på brukerkontoen din. Her vil du
            se en oversikt over hva og hvor mye du resirkulerer, og den totale
            mengden avfall du som forbruker produserer. Dette vil gjøre det lettere
            å se hvor man kan gjøre noe bedre, og om du er flinkere enn naboene dine
            (om du skulle ønske å dele statestikken din). Målet er å gjøre befolkningen
            i Norge mer bevisste på sitt avfallsmønster, samtidig som de får veiledning
            i hvordan ulike produkter skal resirkuleres riktig.
        </p>
    </div>


</div>

<h2>Varesøk<h3> - finn ut hvordan du resikulerer riktig</h3></h2>
<p>
    Usikker på hvordan et produkt skal sorteres?
    Med varesøket i TrashTag kan du enkelt søke opp produkter og få informasjon om hvordan de skal resirkuleres.
    For eksempel, hvis en kartong har et plastlokk og en pappboks, vil systemet fortelle deg hvordan hver del skal sorteres riktig.
    Dette hjelper deg med å unngå feilsortering og resirkulere på en mer effektiv måte.
    For enda enklere resirkulering har TrashTag en strekkodeskanner.
    Ved å trykke på en knapp aktiveres kameraet slik at du kan skanne produktets strekkode og
    automatisk få informasjon produktet. Alternativt kan du manuelt skrive inn strekkoden.
    Scanneren gjør resirkuleringen mindre tidkrevende.
</p>

<h2>Kart<h3> - finn nærmeste avfallstasjon</h3></h2>
<p>
    TrashTag gir deg muligheten til å finne nærmeste avfallstasjon basert på postnummer, eller koordinater.
    Du kan også se hvilke typer materialer hver stasjon tar imot, slik at du enkelt kan planlegge hvor du skal levere avfallet ditt.
</p>

<h2>Personlig profil<h3> - følg din egen utvikling</h3></h2>
<p>
    For å kunne få tilgang til all statistikk og funksjonalitet må brukerne opprette en profil.
    Med en personlig konto kan du følge med på hvor mye du har kastet over tid,
    hvilke materialer du resirkulerer mest, og sette deg mål for å redusere avfallet ditt.
    Du har også en mulighet til å dele statistikken med naboene dine, for å skape en konkurranse mellom dere.
    Dette gir en motiverende og lærerik opplevelse som kan føre til mer miljøvennlige vaner i hverdagen.
</p>

<p>
    TrashTag handler ikke bare om avfallshåndtering – det er en plattform som inspirerer til en mer bærekraftig livsstil.
    Ved å gi brukerne innsikt, veiledning og praktiske verktøy for smartere resirkulering,
    hjelper vi hver enkelt med å gjøre en forskjell for miljøet!
</p>



<%@ include file="footer.jsp" %>
</body>
</html>