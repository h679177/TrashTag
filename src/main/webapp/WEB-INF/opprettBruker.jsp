<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="design.css" rel="stylesheet" type="text/css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hurricane&family=Italiana&family=Notable&display=swap" rel="stylesheet">
    <title>Profil</title>
    <style>
        .login-button {
            color: #1a9350;
            background-color: #bee0c7;
            transition: background-color 0.3s ease;
            display: inline-block;
            cursor: pointer;
            font-size: 18px;
            font-weight: bold;
            border: none;
            border-radius: 20px;
            padding: 10px 20px;
            white-space: nowrap;
        }

        .login-button:hover {
            background-color: #a9d4b9; /* Slightly darker on hover */
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
</div>

<h2>Opprett bruker</h2>
<p style="color:red;">

    <c:if test="${not empty feilmeldinger}">
        <c:forEach var="feilmelding" items="${feilmeldinger}">
            ${feilmelding}<br>
        </c:forEach>
    </c:if>
</p>

<form action="lagBruker" method="post" id="bruker">
    <fieldset style="border: 3px solid #1a9350; border-radius: 10px; padding: 20px; margin-bottom: 50px">
        <p>Brukernavn<br>
            <input type="text" name="brukernavn" value="${bruker.brukernavn}">
        </p>
        <p>Fornavn<br>
            <input type="text" name="fornavn" value="${bruker.fornavn}">
        </p>
        <p>Etternavn<br>
            <input type="text" name="etternavn" value="${bruker.etternavn}">
        </p>
        <p>Postnummer<br>
            <input type="text" name="postnummer" value="${bruker.postnummer}">
        </p>
        <p>Gatenavn<br>
            <input type="text" name="gatenavn" value="${bruker.gatenavn}">
        </p>
        <p>Passord<br>
            <input type="password" name="passord">
        </p>
        <p>Repetert Passord<br>
            <input type="password" name="repPassord">
        </p>
        <input type="submit" value="Opprett bruker" class="login-button"/>
    </fieldset>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>