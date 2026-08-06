package diti.mapper;

import diti.dto.ProduitDTO;
import diti.entity.Produit;
import diti.entity.TypeProduit;

import java.util.ArrayList;
import java.util.List;

public class ProduitMapper {
    public static Produit toProduit(ProduitDTO produitDTO, TypeProduit typeProduit) {
        Produit p = new Produit();
        p.setLibelle(produitDTO.getNomProduit());
        p.setPrix(produitDTO.getPrixProduit());
        p.setTypeProduit(typeProduit);
        return p;
    }

    public static void updateProduit(Produit p, ProduitDTO produitDTO, TypeProduit typeProduit) {
        p.setLibelle(produitDTO.getNomProduit());
        p.setPrix(produitDTO.getPrixProduit());
        p.setTypeProduit(typeProduit);
    }

    public static ProduitDTO toDTO(Produit p) {
        ProduitDTO produitDto = new ProduitDTO();
        produitDto.setId(p.getId());
        produitDto.setNomProduit(p.getLibelle());
        produitDto.setPrixProduit(p.getPrix());
        if (p.getTypeProduit() != null) {
            produitDto.setTypeProduitId(p.getTypeProduit().getId());
        }
        return produitDto;
    }

    public static List<ProduitDTO> toDTOList(List<Produit> produits) {
        List<ProduitDTO> produitDtos = new ArrayList<>();
        for (Produit p : produits) {
            produitDtos.add(toDTO(p));
        }
        return produitDtos;
    }
}
