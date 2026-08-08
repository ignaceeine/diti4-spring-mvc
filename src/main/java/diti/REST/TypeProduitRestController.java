package diti.REST;


import diti.dto.TypeProduitDTO;
import diti.entity.TypeProduit;
import diti.exception.RessourceIntrouvableException;
import diti.mapper.TypeProduitMapper;
import diti.service.TypeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-produits")
public class TypeProduitRestController {


    @Autowired
    private TypeProduitService typeProduitService;

    @Autowired
    private TypeProduitMapper typeProduitMapper;


    @GetMapping
    public List<TypeProduitDTO> getList(){
        List<TypeProduit> typeProduits =  typeProduitService.findAll();
        return typeProduitMapper.toDTOList(typeProduits);
    }

    @PostMapping
    public ResponseEntity<TypeProduitDTO> save(@RequestBody TypeProduitDTO typeProduitDTO){
        TypeProduit typeProduit = typeProduitService.save(typeProduitMapper.toTypeProduit(typeProduitDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(typeProduitMapper.toDTO(typeProduit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        findTypeProduit(id);
        typeProduitService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{id}")
    public TypeProduitDTO getById(@PathVariable Long id){
        return typeProduitMapper.toDTO(findTypeProduit(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody TypeProduitDTO typeProduitDTO){
        TypeProduit typeProduit = findTypeProduit(id);
        typeProduitMapper.updateTypeProduit(typeProduit, typeProduitDTO);
        typeProduitService.save(typeProduit);

        return ResponseEntity.status(HttpStatus.OK).body("Type Produit modifié avec succes");
    }

    private TypeProduit findTypeProduit(Long id){
        return typeProduitService.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Type produit " + id + " introuvable"));
    }


}
