package diti.controller;


import diti.entity.Produit;
import diti.service.ProductService;
import diti.service.TypeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produit")
public class ProduitController {


    @Autowired
    private ProductService productService;

    @Autowired
    private TypeProduitService typeProduitService;


    @GetMapping
    public String getList(@PageableDefault(size = 5, sort = "id") Pageable pageable, Model model){
        Page<Produit> produits = productService.findAll(pageable);
        model.addAttribute("produits", produits.getContent());
        model.addAttribute("page", produits);
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

