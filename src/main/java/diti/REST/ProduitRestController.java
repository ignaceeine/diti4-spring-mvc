package diti.REST;


import diti.dto.ProduitDTO;
import diti.entity.Produit;
import diti.entity.TypeProduit;
import diti.exception.RessourceIntrouvableException;
import diti.exception.RessourceInvalideException;
import diti.mapper.ProduitMapper;
import diti.service.ProductService;
import diti.service.TypeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitRestController {


    @Autowired
    private ProductService productService;

    @Autowired
    private TypeProduitService typeProduitService;


    @GetMapping
    public List<ProduitDTO> getList(){
        List<Produit> produits =  productService.findAll();
        return ProduitMapper.toDTOList(produits);
    }

    @PostMapping
    public ResponseEntity<ProduitDTO> save(@Valid @RequestBody ProduitDTO produitDTO){
        TypeProduit typeProduit = null;
        if(produitDTO.getTypeProduitId() != null){
            typeProduit = findTypeProduit(produitDTO.getTypeProduitId());
        }
        Produit produit = productService.save(ProduitMapper.toProduit(produitDTO, typeProduit));
        return ResponseEntity.status(HttpStatus.CREATED).body(ProduitMapper.toDTO(produit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        findProduit(id);
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{id}")
    public ProduitDTO getById(@PathVariable Long id){
        return ProduitMapper.toDTO(findProduit(id));
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<String> edit(@PathVariable Long id,@Valid @RequestBody ProduitDTO produitDTO){
        Produit produit = findProduit(id);
        TypeProduit typeProduit = produit.getTypeProduit();
        if(produitDTO.getTypeProduitId() != null){
            typeProduit = findTypeProduit(produitDTO.getTypeProduitId());
        }
        ProduitMapper.updateProduit(produit, produitDTO, typeProduit);

        productService.save(produit);

        return ResponseEntity.status(HttpStatus.OK).body("Produit modifié avec succes");
    }

    private Produit findProduit(Long id){
        return productService.findById(id).orElseThrow(() -> new RessourceIntrouvableException("Produit est introuvable"));
    }

    private TypeProduit findTypeProduit(Long id){
        return typeProduitService.findById(id).orElseThrow(() -> new RessourceInvalideException("Le type produit est introuvable"));
    }


}

