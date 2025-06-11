package com.codegym.hoan_thien_gio_hang.controller;

import com.codegym.hoan_thien_gio_hang.model.CartItem;
import com.codegym.hoan_thien_gio_hang.model.Product;
import com.codegym.hoan_thien_gio_hang.service.IProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public String showCart(HttpSession session, Model model) {
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        model.addAttribute("cart", cart);
        model.addAttribute("total", calculateTotal(cart));
        return "cart/cart";
    }

    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @RequestParam int quantity, HttpSession session) {
        Product product = productService.findById(id).orElse(null);
        if (product == null) {
            return "redirect:/products";
        }

        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        if (cart.containsKey(id)) {
            CartItem item = cart.get(id);
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            cart.put(id, new CartItem(product, quantity));
        }

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @PostMapping("/update/{id}")
    public String updateQuantity(@PathVariable int id, @RequestParam int quantity, HttpSession session) {
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(id)) {
            cart.get(id).setQuantity(quantity);
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeItem(@PathVariable int id, HttpSession session) {
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.remove(id);
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session) {
        session.removeAttribute("cart");
        return "redirect:/products";
    }

    private double calculateTotal(Map<Integer, CartItem> cart) {
        return cart.values().stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
