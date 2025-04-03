<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="design.css" rel="stylesheet" type="text/css" />
    <title>Profil</title>
</head>

<body>
<nav>
    <a href="hjem">Hjem</a> |
    <a href="vareSok">Søk</a> |
    <a href="kart">Kart</a> |
    <a href="profil">Profil</a>
</nav>
<h1>Opprett bruker</h1>
<form action="lagBruker" method="post" id="bruker">
    <fieldset>
        <p>Brukernavn<br><input type="text" name="brukernavn" value="${bruker.brukernavn}">
            <c:if test="${not empty bindingResult.getFieldError('brukernavn')}">
        <div style="color: red;">
            <c:forEach var="error" items="${bindingResult.getFieldErrors('brukernavn')}">
                <c:out value="${error.defaultMessage}"/><br/>
            </c:forEach>
        </div>
        </c:if>
        </p>
        <p>Fornavn <br><input type="text" name="fornavn" value="${bruker.fornavn}">
            <c:if test="${not empty bindingResult.getFieldError('fornavn')}">
        <div style="color: red;">
            <c:forEach var="error" items="${bindingResult.getFieldErrors('fornavn')}">
                <c:out value="${error.defaultMessage}"/><br/>
            </c:forEach>
        </div>
        </c:if>
        </p>
        <p>Etternavn<br><input type="text" name="etternavn" value="${bruker.etternavn}">
            <c:if test="${not empty bindingResult.getFieldError('etternavn')}">
        <div style="color: red;">
            <c:forEach var="error" items="${bindingResult.getFieldErrors('etternavn')}">
                <c:out value="${error.defaultMessage}"/><br/>
            </c:forEach>
        </div>
        </c:if>
        </p>
        <p>Post nummer<br><input type="text" name="postnr" value="${bruker.postnr}">
            <c:if test="${not empty bindingResult.getFieldError('postnr')}">
        <div style="color: red;">
            <c:forEach var="error" items="${bindingResult.getFieldErrors('postnr')}">
                <c:out value="${error.defaultMessage}"/><br/>
            </c:forEach>
        </div>
        </c:if>
        </p>
        <p>Gatenavn<br><input type="text" name="gatenavn" value="${bruker.gatenavn}">
            <c:if test="${not empty bindingResult.getFieldError('gatenavn')}">
        <div style="color: red;">
            <c:forEach var="error" items="${bindingResult.getFieldErrors('gatenavn')}">
                <c:out value="${error.defaultMessage}"/><br/>
            </c:forEach>
        </div>
        </c:if>
        </p>
        <p>Passord<br><input type="password" name="passord">
            <c:if test="${not empty bindingResult.getFieldError('passord')}">
        <div style="color: red;">
            <c:forEach var="error" items="${bindingResult.getFieldErrors('passord')}">
                <c:out value="${error.defaultMessage}"/><br/>
            </c:forEach>
        </div>
        </c:if>
        </p>
        <p>Repetert Passord<br><input type="password" name="repPassord">
            <c:if test="${not empty bindingResult.getFieldError('repPassord')}">
        <div style="color: red;">
            <c:forEach var="error" items="${bindingResult.getFieldErrors('repPassord')}">
                <c:out value="${error.defaultMessage}"/><br/>
            </c:forEach>
        </div>
        </c:if>
        </p>

        <input type="submit" value="Opprett bruker"/>
    </fieldset>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>