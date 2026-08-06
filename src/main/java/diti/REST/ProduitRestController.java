package diti.REST;


import diti.entity.Produit;
import diti.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produits")
public class ProduitRestController {


    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Produit>  getList(){
        List<Produit> produits =  productService.findAll();
        return produits;
    }

    @PostMapping
    public ResponseEntity<Produit> save(@RequestBody Produit produit){
       return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(produit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Produit> produit = productService.findById(id);
        if(!produit.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Produit>  getById(@PathVariable Long id){
        Optional<Produit> produit = productService.findById(id);
        if(!produit.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produit.get());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> edit(@PathVariable Long id,@RequestBody Produit  produit){
        Optional<Produit> p = productService.findById(id);
        if(!p.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        p.get().setLibelle(produit.getLibelle());
        p.get().setPrix(produit.getPrix());

        productService.save(p.get());

        return ResponseEntity.status(HttpStatus.OK).body("Produit modifié avec succes");
    }


}

