package diti.mapper;

import diti.dto.TypeProduitDTO;
import diti.entity.TypeProduit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeProduitMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produits", ignore = true)
    @Mapping(target = "libelle", source = "nomTypeProduit")
    TypeProduit toTypeProduit(TypeProduitDTO typeProduitDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produits", ignore = true)
    @Mapping(target = "libelle", source = "nomTypeProduit")
    void updateTypeProduit(@MappingTarget TypeProduit tp, TypeProduitDTO typeProduitDTO);

    @Mapping(target = "nomTypeProduit", source = "libelle")
    TypeProduitDTO toDTO(TypeProduit tp);

    List<TypeProduitDTO> toDTOList(List<TypeProduit> typeProduits);
}
