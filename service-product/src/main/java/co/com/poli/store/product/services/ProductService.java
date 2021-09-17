package co.com.poli.store.product.services;

import co.com.poli.store.product.entities.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);
    void delete(Product product);
    List<Product> findAll();
    Product findById(Long id);

}
