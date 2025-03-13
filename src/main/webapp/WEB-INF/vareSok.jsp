<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link href="design.css" rel="stylesheet" type="text/css" />
	<title>Søk etter vare</title>
</head>

<body>
<nav>
	<a href="hjem.jsp">Hjem</a> |
	<a href="vareSok.jsp">Søk</a> |
	<a href="kart.jsp">Kart</a> |
	<a href="profil.jsp">Profil</a>
</nav>
<h1>Søk etter vare:</h1>
<form method="get">
	<input type="text" name="ean" placeholder="Skriv inn EAN-nummer...">
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
				productName = "T-skjorte";
				material = "Bomull";
				break;
			case "9876543210987":
				productName = "Vannflaske";
				material = "Plast";
				break;
			case "5556667778889":
				productName = "Laptop-stativ";
				material = "Aluminium";
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