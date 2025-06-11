package com.codegym.hoan_thien_gio_hang.service;

import com.codegym.hoan_thien_gio_hang.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(int id);
}
