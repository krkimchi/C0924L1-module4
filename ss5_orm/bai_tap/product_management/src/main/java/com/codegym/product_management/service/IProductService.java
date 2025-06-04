package com.codegym.product_management.service;

import com.codegym.product_management.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
}
