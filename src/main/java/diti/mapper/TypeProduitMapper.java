package diti.mapper;

import diti.dto.TypeProduitDTO;
import diti.entity.TypeProduit;

import java.util.ArrayList;
import java.util.List;

public class TypeProduitMapper {
    public static TypeProduit toTypeProduit(TypeProduitDTO typeProduitDTO) {
        TypeProduit tp = new TypeProduit();
        tp.setLibelle(typeProduitDTO.getNomTypeProduit());
        return tp;
    }

    public static void updateTypeProduit(TypeProduit tp, TypeProduitDTO typeProduitDTO) {
        tp.setLibelle(typeProduitDTO.getNomTypeProduit());
    }

    public static TypeProduitDTO toDTO(TypeProduit tp) {
        TypeProduitDTO typeProduitDto = new TypeProduitDTO();
        typeProduitDto.setId(tp.getId());
        typeProduitDto.setNomTypeProduit(tp.getLibelle());
        return typeProduitDto;
    }

    public static List<TypeProduitDTO> toDTOList(List<TypeProduit> typeProduits) {
        List<TypeProduitDTO> typeProduitDtos = new ArrayList<>();
        for (TypeProduit tp : typeProduits) {
            typeProduitDtos.add(toDTO(tp));
        }
        return typeProduitDtos;
    }
}
