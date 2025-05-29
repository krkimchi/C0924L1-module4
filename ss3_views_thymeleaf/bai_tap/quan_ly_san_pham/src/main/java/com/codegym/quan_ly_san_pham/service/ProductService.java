package com.codegym.quan_ly_san_pham.service;

import com.codegym.quan_ly_san_pham.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Iphone 14", 1000, "Smartphone cao cấp", "Apple"));
        products.add(new Product(2, "Galaxy S22", 900, "Điện thoại Android", "Samsung"));
        products.add(new Product(3, "Xiaomi 12", 700, "Cấu hình mạnh, giá rẻ", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(int id, Product product) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            products.set(index, product);
        }
    }

    @Override
    public void remove(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

}
