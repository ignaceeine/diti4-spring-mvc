package diti.REST;


import diti.entity.Produit;
import diti.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {


    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Produit>  getList(){
        List<Produit>  produits =  productService.findAll();
        return produits;
    }

    @PostMapping
    public String save(@RequestBody Produit produit){
        productService.save(produit);
        return "produit ajoute avec succes";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.delete(id);
        return "produit supprime avec succes";
    }


    @GetMapping("/{id}")
    public Produit getById(@PathVariable Long id){
        return  productService.findById(id);
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Produit produit =  productService.findById(id);
        model.addAttribute("produit", produit);
        return "form-product";
    }


}

