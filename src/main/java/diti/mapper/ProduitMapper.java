package diti.mapper;

import diti.dto.ProduitDTO;
import diti.entity.Produit;
import diti.entity.TypeProduit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProduitMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "libelle", source = "produitDTO.nomProduit")
    @Mapping(target = "prix", source = "produitDTO.prixProduit")
    @Mapping(target = "typeProduit", source = "typeProduit")
    Produit toProduit(ProduitDTO produitDTO, TypeProduit typeProduit);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "libelle", source = "produitDTO.nomProduit")
    @Mapping(target = "prix", source = "produitDTO.prixProduit")
    @Mapping(target = "typeProduit", source = "typeProduit")
    void updateProduit(@MappingTarget Produit p, ProduitDTO produitDTO, TypeProduit typeProduit);

    @Mapping(target = "nomProduit", source = "libelle")
    @Mapping(target = "prixProduit", source = "prix")
    @Mapping(target = "typeProduitId", source = "typeProduit.id")
    ProduitDTO toDTO(Produit p);
}
