package com.codegym.tu_dien_don_gian.controller;

import com.codegym.tu_dien_don_gian.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService translationService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model) {
        String result = translationService.translate(word);
        model.addAttribute("word", word);
        model.addAttribute("result", result);
        return "result";
    }
}
