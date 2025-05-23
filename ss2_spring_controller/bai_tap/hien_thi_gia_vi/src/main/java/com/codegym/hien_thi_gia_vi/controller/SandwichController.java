package com.codegym.hien_thi_gia_vi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        List<String> selected;
        if (condiment != null) {
            selected = Arrays.asList(condiment);
        } else {
            selected = new java.util.ArrayList<>();
        }

        model.addAttribute("selected", selected);
        return "result";
    }
}
