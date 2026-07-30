<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<form action="${pageContext.request.contextPath}/produit" method="post">
    <input type="text" value="${produit.id}" name="id" hidden="">
    <label for="">Libelle</label>
    <input type="text" name="libelle" value="${produit.libelle}"/>
    <label for="">Prix</label>
    <input type="number" name="prix" value="${produit.prix}"/>
    <label for="">Type de produit</label>
    <select name="typeProduit.id">
        <option value="">-- Choisir un type --</option>
        <c:forEach var="typeProduit" items="${typeProduits}">
            <option value="${typeProduit.id}"
                    <c:if test="${produit.typeProduit.id == typeProduit.id}">selected</c:if>>
                ${typeProduit.libelle}
            </option>
        </c:forEach>
    </select>
    <button type="submit">Enregistrer</button>
</form>
