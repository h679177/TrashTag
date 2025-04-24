<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="design.css" rel="stylesheet" type="text/css" />
    <link href="personvern.css" rel="stylesheet" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hurricane&family=Italiana&family=Notable&display=swap" rel="stylesheet">
    <title>Personvern</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            line-height: 1.6;
            color: #333;
        }
        h1, h2 {
            color: #2c3e50;
            font-size: 30px;
        }
        nav {
            margin-bottom: 30px;
        }
        nav ul {
            list-style-type: none;
            padding-left: 0;
        }
        nav ul li {
            margin: 5px 0;
        }
        nav ul li a {
            text-decoration: none;
            color: #2980b9;
        }
        nav ul li a:hover {
            text-decoration: underline;
        }
        section {
            margin-bottom: 40px;
        }
        html, body {
            margin: 0;
            padding: 0;
            /*height: 100%;*/
        }

        /* Stil for bunnteksten */
        footer {
            width: 100%;
            background-color: #f8f8f8; /* Tilpass etter behov */
            padding: 20px 0; /* Juster etter design */
            text-align: center;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="topnav">
        <a href="hjem">HJEM</a>
        <a href="vareSok">SØK</a>
        <a href="kart">KART</a>
        <a href="profil">PROFIL</a>
    </div>

<h1 style="margin: 0">Personvernerklæring for TrashTag</h1>
<p><strong>Sist oppdatert:</strong> 24.April 2025</p>

<p>TrashTag er en fiktiv applikasjon utviklet som en del av et skoleprosjekt. Formålet med appen er å hjelpe brukere med å sortere søppel riktig ved å skanne produkter, samt finne nærmeste søppelkasse. Denne personvernerklæringen forklarer hvordan vi hypotetisk samler inn og bruker personopplysninger i appen.</p>

<nav>
    <h2>Innholdsfortegnelse</h2>
    <ul>
        <li><a href="#behandlingsansvarlig">1. Behandlingsansvarlig</a></li>
        <li><a href="#innsamling">2. Hvilke personopplysninger samles inn?</a></li>
        <li><a href="#formål">3. Formål med innsamling</a></li>
        <li><a href="#posisjonsdata">4. Posisjonsdata</a></li>
        <li><a href="#deling">5. Deling av informasjon</a></li>
        <li><a href="#rettigheter">6. Brukerens rettigheter</a></li>
        <li><a href="#kontakt">7. Kontaktinformasjon</a></li>
    </ul>
</nav>

<section id="behandlingsansvarlig">
    <h2>1. Behandlingsansvarlig</h2>
    <p>Utviklergruppen bak TrashTag er behandlingsansvarlig for personopplysninger som samles inn og behandles i appen.</p>
</section>

<section id="innsamling">
    <h2>2. Hvilke personopplysninger samles inn?</h2>
    <p>Ved registrering i TrashTag samles følgende informasjon:</p>
    <ul>
        <li>Navn</li>
        <li>E-postadresse</li>
        <li>Passord</li>
        <li>Adresse (valgfritt – kun hvis du vil delta i nabolagsstatistikk/rangering)</li>
        <li>Posisjonsdata (dersom bruker samtykker)</li>
    </ul>
</section>

<section id="formål">
    <h2>3. Formål med innsamling</h2>
    <p>Personopplysninger benyttes til følgende formål:</p>
    <ul>
        <li>Opprette og administrere brukerprofil</li>
        <li>Tilby produktgjenkjenning for søppelsortering</li>
        <li>Vise nærmeste søppelkasse basert på posisjon</li>
        <li>Tilby rangering og statistikk innenfor nabolag (dersom adresse oppgis)</li>
    </ul>
</section>

<section id="posisjonsdata">
    <h2>4. Posisjonsdata</h2>
    <p>TrashTag bruker enhetens GPS for å vise nærmeste søppelkasse. Brukeren kan selv velge om posisjonsdeling skjer:</p>
    <ul>
        <li>Kun når appen er i bruk</li>
        <li>Alltid (dersom funksjonalitet for bakgrunnsposisjon legges til)</li>
    </ul>
    <p>Innstillinger for posisjonsdeling kan når som helst endres av brukeren på enheten.</p>
</section>

<section id="deling">
    <h2>5. Deling av informasjon</h2>
    <p>Ingen personopplysninger deles med tredjeparter. Data behandles kun internt i applikasjonen, og brukes utelukkende i konteksten av skoleprosjektet.</p>
</section>

<section id="rettigheter">
    <h2>6. Brukerens rettigheter</h2>
    <p>Ettersom TrashTag er en prototype, behandles ingen reelle personopplysninger. Dersom dette hadde vært en ekte applikasjon, ville brukeren hatt rett til:</p>
    <ul>
        <li>Innsyn i egne data</li>
        <li>Retting eller sletting av opplysninger</li>
        <li>Trekke tilbake samtykke til behandling</li>
    </ul>
</section>

<section id="kontakt">
    <h2>7. Kontaktinformasjon</h2>
    <p>Ved spørsmål om personvern i TrashTag, kontakt prosjektgruppen:</p>
    <ul>
        <li><strong>Prosjektnavn:</strong> TrashTag</li>
        <li><strong>Skoleprosjekt ved:</strong> HVL </li>
        <li><strong>Kontaktperson:</strong> Gruppe 2 </li>
    </ul>
</section>
</div>

    <%@ include file="WEB-INF/footer.jsp" %>
</body>
</html>