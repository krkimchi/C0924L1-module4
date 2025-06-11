package com.codegym.hoan_thien_gio_hang.controller;

import com.codegym.hoan_thien_gio_hang.model.Product;
import com.codegym.hoan_thien_gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String showProductDetail(@PathVariable int id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product/detail";
        } else {
            return "redirect:/products";
        }
    }
}
