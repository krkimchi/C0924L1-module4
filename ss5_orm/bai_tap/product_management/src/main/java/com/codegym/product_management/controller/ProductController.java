package com.codegym.product_management.controller;

import com.codegym.product_management.model.Product;
import com.codegym.product_management.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String showHome() {
        return "redirect:/product/list";
    }

    @GetMapping("/product/list")
    public String showListProduct(Model model) {
        model.addAttribute("productList", productService.getAllProducts());
        return "list";
    }

    @GetMapping("/product/add")
    public String showFormAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/product/edit")
    public String showFormEditProduct(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit";
    }

    @PostMapping("/product/edit")
    public String editProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/product/view")
    public String showViewProduct(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "view";
    }

    @GetMapping("/product/delete")
    public String showFormDeleteProduct(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "delete";
    }

    @PostMapping("/product/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }
}
