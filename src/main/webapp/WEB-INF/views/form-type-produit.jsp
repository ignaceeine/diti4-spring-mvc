<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<form action="${pageContext.request.contextPath}/type-produit" method="post">
    <input type="text" value="${typeProduit.id}" name="id" hidden="">
    <label for="">Libelle</label>
    <input type="text" name="libelle" value="${typeProduit.libelle}"/>
    <button type="submit">Enregistrer</button>
</form>
