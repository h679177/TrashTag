<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link href="simple.css" rel="stylesheet" type="text/css" />
	<title>Søk etter vare</title>
</head>

<body>
<h1>Søk etter vare:</h1>
<form action="/search" method="get">
	<input type="text" name="query" placeholder="Søk etter vare...">
	<button type="submit">Søk</button>
<nav>
	<a href="hjem.jsp">Hjem</a> |
	<a href="vareSok.jsp">Søk</a> |
	<a href="kart.jsp">Kart</a> |
	<a href="profil.jsp">Profil</a>
</nav>
</form>
</body>
</html>