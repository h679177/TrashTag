<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link href="design.css" rel="stylesheet" type="text/css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Italiana&display=swap" rel="stylesheet">
	<title>Vare søk</title>
	<style>
		.trash-buttons {
			margin-top: 20px;
			display: flex;
			gap: 15px;
			justify-content: center;
		}
		.trash-buttons button {
			background-color: #656965;
			color: white;
			font-weight: bold;
			font-size: 10px;
			padding: 12px; /* Makes it more square */
			border: none;
			border-radius: 12px; /* Adjust for more rounded corners */
			cursor: pointer;
			display: flex;
			align-items: center;
			justify-content: center;
			gap: 8px;
			width: 60px; /* Set fixed width */
			height: 60px; /* Set fixed height */
			text-align: center;
		}
		.trash-buttons button img {
			width: 28px; /* Slightly larger icon */
			height: 28px;
		}
		.trash-info {
			display: none;
			margin-top: 10px;
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 8px;
			background-color: #f9f9f9;
			width: 60%;
			margin-left: auto;
			margin-right: auto;
		}
	</style>
	<script>
		function toggleInfo(id) {
			let element = document.getElementById(id);
			element.style.display = (element.style.display === "none" || element.style.display === "") ? "block" : "none";
		}
	</script>
</head>

<body>
<nav>
	<a href="hjem.jsp">HJEM</a>
	<a href="vareSok.jsp">SØK</a>
	<a href="kart.jsp">KART</a>
	<a href="profil.jsp">PROFIL</a>
</nav>
<h1>SØK ETTER VARE:</h1>
<form method="get">
	<input type="text" name="ean" placeholder="EAN-nummer">
	<button type="submit">Søk</button>
</form>
<%
	String ean = request.getParameter("ean");
	String productName = null;
	String material = null;

	if (ean != null && !ean.isEmpty()) {
		switch (ean) {
			case "1234567890123":
				productName = "GoMorgen yoghurt";
				material = "Plast";
				break;
			case "9876543210987":
				productName = "Melk";
				material = "Papp";
				break;
			case "5556667778889":
				productName = "Tomatpuré";
				material = "Glass/metall";
				break;
			default:
				productName = "Produkt ikke funnet";
				material = "-";
		}
%>

<div class="trash-info" style="display: block;">
	<h3>Produktdetaljer</h3>
	<p><strong>EAN:</strong> <%= ean %></p>
	<p><strong>Produktnavn:</strong> <%= productName %></p>
	<p><strong>Materiale:</strong> <%= material %></p>
</div>
<%
	}
%>

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

<!-- Hidden trash info sections -->
<div id="plastInfo" class="trash-info">
	<h3>Plastavfall</h3>
	<p>Plastemballasje bør skylles og sorteres i plastavfall. Store plastgjenstander går til gjenvinningsstasjon.</p>
</div>
<div id="pappInfo" class="trash-info">
	<h3>Papp og papir</h3>
	<p>Papp, papir og kartong resirkuleres. Husk å fjerne plastbelegg før sortering.</p>
</div>
<div id="glassMetallInfo" class="trash-info">
	<h3>Glass og metall</h3>
	<p>Skyll glass og metall før det kastes i riktig beholder. Metall kan også leveres til gjenvinningsstasjon.</p>
</div>
<div id="matavfallInfo" class="trash-info">
	<h3>Matavfall</h3>
	<p>Matavfall kastes i bioavfall. Unngå plastposer – bruk papirposer eller bioposer.</p>
</div>
<div id="elektronikkInfo" class="trash-info">
	<h3>Elektronikkavfall</h3>
	<p>Elektronikk må leveres til spesialavfall. Ikke kast i restavfall.</p>
</div>

</body>
</html>