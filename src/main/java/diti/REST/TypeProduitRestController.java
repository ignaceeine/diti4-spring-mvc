package diti.REST;


import diti.entity.TypeProduit;
import diti.service.TypeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-produit")
public class TypeProduitRestController {


    @Autowired
    private TypeProduitService typeProduitService;


    @GetMapping
    public List<TypeProduit>  getList(){
        List<TypeProduit>  typeProduits =  typeProduitService.findAll();
        return typeProduits;
    }

    @PostMapping
    public String save(@RequestBody TypeProduit typeProduit){
        typeProduitService.save(typeProduit);
        return "type produit ajoute avec succes";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        typeProduitService.delete(id);
        return "type produit supprime avec succes";
    }


    @GetMapping("/{id}")
    public TypeProduit getById(@PathVariable Long id){
        return  typeProduitService.findById(id);
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        TypeProduit typeProduit =  typeProduitService.findById(id);
        model.addAttribute("typeProduit", typeProduit);
        return "form-type-produit";
    }


}
