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
<h1>VareSøk</h1>
<form action="/search" method="get">
	<input type="text" name="query" placeholder="Søk etter vare...">
	<button type="submit">Søk</button>
</form>
</body>
</html>