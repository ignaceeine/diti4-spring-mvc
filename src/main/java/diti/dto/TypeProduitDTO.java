package diti.dto;


public class TypeProduitDTO {
    private Long id;
    private String nomTypeProduit;

    public TypeProduitDTO() {

    }

    public TypeProduitDTO(Long id, String nomTypeProduit) {
        this.id = id;
        this.nomTypeProduit = nomTypeProduit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomTypeProduit() {
        return nomTypeProduit;
    }

    public void setNomTypeProduit(String nomTypeProduit) {
        this.nomTypeProduit = nomTypeProduit;
    }
}
