<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<a href="${pageContext.request.contextPath}/produit/new">Ajouter un produit</a>


<table>
    <c:forEach var="product" items="${produits}">
        <tr> <td>${product.id}</td>
            <td>${product.libelle}</td>
            <td>${product.prix}</td>
            <td>${product.typeProduit.libelle}</td>
            <td>
                <a href="${pageContext.request.contextPath}/produit/edit/${product.id}">Modifier</a>
                <form action="${pageContext.request.contextPath}/produit/delete/${product.id}" method="post" style="display:inline;">
                    <input type="text" hidden  name="_method" value="DELETE">
                    <input type="submit" value="Supprimer" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce produit ?');" />
                </form>
            </td> </tr>
    </c:forEach>
</table>

<c:if test="${page.totalPages > 1}">
    <div>
        <c:if test="${not page.first}">
            <a href="?page=${page.number - 1}&size=${page.size}">Precedent</a>
        </c:if>

        <c:forEach var="i" begin="0" end="${page.totalPages - 1}">
            <c:choose>
                <c:when test="${i == page.number}"><strong>${i + 1}</strong></c:when>
                <c:otherwise><a href="?page=${i}&size=${page.size}">${i + 1}</a></c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${not page.last}">
            <a href="?page=${page.number + 1}&size=${page.size}">Suivant</a>
        </c:if>
    </div>
    <p>Page ${page.number + 1} / ${page.totalPages} — ${page.totalElements} produits</p>
</c:if>
