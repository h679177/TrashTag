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
	// Simulated product data (later replace this with actual backend logic)
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
<h2>Produktdetaljer</h2>
<p><strong>EAN:</strong> <%= ean %></p>
<p><strong>Produktnavn:</strong> <%= productName %></p>
<p><strong>Materiale:</strong> <%= material %></p>
<%
	}
%>
</body>
</html>