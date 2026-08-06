package diti.controller;


import diti.entity.Produit;
import diti.service.ProductService;
import diti.service.TypeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produit")
public class ProduitController {


    @Autowired
    private ProductService productService;

    @Autowired
    private TypeProduitService typeProduitService;


    @GetMapping
    public String getList(Model model){
        List<Produit>  produits =  productService.findAll();
        model.addAttribute("produits",produits);
        return "produit";
    }


    @GetMapping("/new")
    public String form(Model model){
        model.addAttribute("typeProduits", typeProduitService.findAll());
        return "form-product";
    }

    @PostMapping
    public String save(@ModelAttribute Produit produit){
        if (produit.getTypeProduit() != null && produit.getTypeProduit().getId() == null) {
            produit.setTypeProduit(null);
        }
        productService.save(produit);
        return "redirect:/produit";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/produit";
    }



    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Produit produit =  productService.findById(id).get();
        model.addAttribute("produit", produit);
        model.addAttribute("typeProduits", typeProduitService.findAll());
        return "form-product";
    }


}

