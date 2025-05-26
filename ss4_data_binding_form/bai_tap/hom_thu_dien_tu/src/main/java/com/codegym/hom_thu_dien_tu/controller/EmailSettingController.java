package com.codegym.hom_thu_dien_tu.controller;

import com.codegym.hom_thu_dien_tu.model.EmailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailSettingController {
    private EmailSetting setting = new EmailSetting();

    public EmailSettingController() {
        setting.setLanguage("English");
        setting.setPageSize(25);
        setting.setSpamsFilter(false);
        setting.setSignature("Thor\nKing, Asgard");
    }

    @GetMapping("/")
    public String redirectToSettings() {
        return "redirect:/settings";
    }

    @GetMapping("/settings")
    public String showForm(Model model) {
        model.addAttribute("setting", setting);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
        return "form";
    }

    @PostMapping("/settings")
    public String updateSetting(@ModelAttribute("setting") EmailSetting emailSetting, Model model) {
        this.setting = emailSetting;
        model.addAttribute("setting", setting);
        return "result";
    }
}
