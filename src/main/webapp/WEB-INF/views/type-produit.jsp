<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<a href="${pageContext.request.contextPath}/type-produit/new">Ajouter un type de produit</a>


<table>
    <c:forEach var="typeProduit" items="${typeProduits}">
        <tr> <td>${typeProduit.id}</td>
            <td>${typeProduit.libelle}</td>
            <td>
                <a href="${pageContext.request.contextPath}/type-produit/edit/${typeProduit.id}">Modifier</a>
                <form action="${pageContext.request.contextPath}/type-produit/delete/${typeProduit.id}" method="post" style="display:inline;">
                    <input type="text" hidden  name="_method" value="DELETE">
                    <input type="submit" value="Supprimer" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce type de produit ?');" />
                </form>
            </td> </tr>
    </c:forEach>
</table>
