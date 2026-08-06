package diti.REST;


import diti.entity.TypeProduit;
import diti.service.TypeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type-produits")
public class TypeProduitRestController {


    @Autowired
    private TypeProduitService typeProduitService;


    @GetMapping
    public List<TypeProduit>  getList(){
        List<TypeProduit>  typeProduits =  typeProduitService.findAll();
        return typeProduits;
    }

    @PostMapping
    public ResponseEntity<TypeProduit> save(@RequestBody TypeProduit typeProduit){
        return ResponseEntity.status(HttpStatus.CREATED).body(typeProduitService.save(typeProduit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TypeProduit> delete(@PathVariable Long id){
        Optional<TypeProduit> typeProduit= typeProduitService.findById(id);
        if(!typeProduit.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        typeProduitService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<TypeProduit> getById(@PathVariable Long id){
        Optional<TypeProduit> typeProduit= typeProduitService.findById(id);
        if(!typeProduit.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.status(HttpStatus.OK).body(typeProduit.get());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, TypeProduit typeProduit){
        Optional<TypeProduit> tp= typeProduitService.findById(id);
        if(!tp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        tp.get().setLibelle(typeProduit.getLibelle());
        typeProduitService.save(tp.get());

        return ResponseEntity.status(HttpStatus.OK).body("Type Produit modifié avec succes");
    }


}
