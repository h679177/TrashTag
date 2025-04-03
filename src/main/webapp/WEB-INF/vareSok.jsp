<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link href="design.css" rel="stylesheet" type="text/css" />
	<link href="vareSok.css" rel="stylesheet" type="text/css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Italiana&display=swap" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/quagga/0.12.1/quagga.min.js"></script>
	<script src="vareSok.js"></script>
	<title>Vare søk</title>

	<script>
		function toggleInfo(id) {
			let element = document.getElementById(id);
			element.style.display = (element.style.display === "none" || element.style.display === "") ? "block" : "none";
		}
	</script>
</head>

<body>
<nav>
	<a href="hjem">HJEM</a>
	<a href="vareSok">SØK</a>
	<a href="kart">KART</a>
	<a href="profil">PROFIL</a>
</nav>
<h2>SØK ETTER VARE</h2>
<form method="get">
	<input type="text" id="eanInput" name="EAN" placeholder="EAN-nummer">

	<button type="submit">Søk</button>
</form>

<c:if test="${not empty feilmelding}">
	<div style="color: #338e45; margin-top: 10px;">
			${feilmelding}
	</div>
</c:if>

<c:if test="${not empty vare}">
	<div class="trash-info" style="display: block;">
		<h4>PRODUKTDETALJER</h4>
		<p><i>Produktnavn: ${vare.varenavn}</i></p>
		<p><i>Produsent: ${vare.produsent}</i></p>

		<c:forEach var="emballasje" items="${vare.emballasjer}">
			<p><strong>${emballasje.kommentar} sorteres som ${emballasje.id.avfallstype}.</strong></p>
                    </c:forEach>
	</div>
</c:if>

<!-- Trash category buttons with expandable info -->
<div class="trash-buttons">
	<button onclick="toggleInfo('plastInfo')">
		Plast
	</button>
	<button onclick="toggleInfo('pappInfo')">
		Papp
	</button>
	<button onclick="toggleInfo('glassMetallInfo')">
		Glass/
		Metall
	</button>
	<button onclick="toggleInfo('matavfallInfo')">
		Matavfall
	</button>
	<button onclick="toggleInfo('elektronikkInfo')">
		Elektronikk
	</button>
</div>

<!-- Knapp for å starte kamera-skanning -->
<button type="button" id="camera-button">📷 Skann med kamera</button>
<!-- Container for kameravisning -->
<div id="scanner-container">
    <video id="scanner" autoplay playsinline></video>
</div>


<!-- Hidden trash info sections -->
<div id="plastInfo" class="trash-info">
	<h4>Plastavfall</h4>
	<p>Plastemballasje bør skylles og sorteres i plastavfall. Store plastgjenstander går til gjenvinningsstasjon.</p>
</div>
<div id="pappInfo" class="trash-info">
	<h4>Papp og papir</h4>
	<p>Papp, papir og kartong resirkuleres. Husk å fjerne plastbelegg før sortering.</p>
</div>
<div id="glassMetallInfo" class="trash-info">
	<h4>Glass og metall</h4>
	<p>Skyll glass og metall før det kastes i riktig beholder. Metall kan også leveres til gjenvinningsstasjon.</p>
</div>
<div id="matavfallInfo" class="trash-info">
	<h4>Matavfall</h4>
	<p>Matavfall kastes i bioavfall. Unngå plastposer – bruk papirposer eller bioposer.</p>
</div>
<div id="elektronikkInfo" class="trash-info">
	<h4>Elektronikkavfall</h4>
	<p>Elektronikk må leveres til spesialavfall. Ikke kast i restavfall.</p>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>