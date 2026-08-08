package diti.service;



import diti.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Produit save(Produit product);

    Page<Produit> findAll(Pageable pageable);

    Optional<Produit> findById(Long id);

    void delete(Long id);
}