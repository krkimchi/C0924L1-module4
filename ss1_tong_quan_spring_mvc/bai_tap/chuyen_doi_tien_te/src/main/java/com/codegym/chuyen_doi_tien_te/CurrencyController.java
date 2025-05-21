package com.codegym.chuyen_doi_tien_te;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/convert")
    public String convertCurrency(@RequestParam("rate") double rate, @RequestParam("usd") double usd, Model model) {
        double vnd = usd * rate;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        return "result";
    }
}
