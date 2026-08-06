package diti.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProduitDTO {
    private Long id;

    @NotBlank(message = "Le nom du produit ne peut pas etre vide")
    private String nomProduit;

    @Min(value = 10, message = "Le prix minimum est 10")
    private double prixProduit;

    @NotNull(message = "L'id du type de produit ne peut pas etre null")
    private Long typeProduitId;

    public ProduitDTO() {

    }

    public ProduitDTO(Long id, String nomProduit, double prixProduit, Long typeProduitId) {
        this.id = id;
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.typeProduitId = typeProduitId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public Long getTypeProduitId() {
        return typeProduitId;
    }

    public void setTypeProduitId(Long typeProduitId) {
        this.typeProduitId = typeProduitId;
    }
}
