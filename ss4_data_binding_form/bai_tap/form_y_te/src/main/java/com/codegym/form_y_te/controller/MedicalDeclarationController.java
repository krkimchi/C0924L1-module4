package com.codegym.form_y_te.controller;

import com.codegym.form_y_te.model.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MedicalDeclarationController {
    private List<MedicalDeclaration> declarations = new ArrayList<>();

    @GetMapping("/")
    public String redirectToForm() {
        return "redirect:/declaration";
    }

    @GetMapping("/declaration")
    public String showForm(Model model) {
        model.addAttribute("declaration", new MedicalDeclaration());
        model.addAttribute("declarations", declarations);
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("declaration") MedicalDeclaration declaration, Model model) {
        List<String> missingFields = new ArrayList<>();

        if (declaration.getFullName() == null || declaration.getFullName().isEmpty()) missingFields.add("Họ tên");
        if (declaration.getBirthYear() == null || declaration.getBirthYear().isEmpty()) missingFields.add("Năm sinh");
        if (declaration.getGender() == null || declaration.getGender().isEmpty()) missingFields.add("Giới tính");
        if (declaration.getNationality() == null || declaration.getNationality().isEmpty()) missingFields.add("Quốc tịch");
        if (declaration.getIdNumber() == null || declaration.getIdNumber().isEmpty()) missingFields.add("CMND/hộ chiếu");
        if (declaration.getProvince() == null || declaration.getProvince().isEmpty()) missingFields.add("Tỉnh");
        if (declaration.getDistrict() == null || declaration.getDistrict().isEmpty()) missingFields.add("Quận");
        if (declaration.getWard() == null || declaration.getWard().isEmpty()) missingFields.add("Phường");
        if (declaration.getAddress() == null || declaration.getAddress().isEmpty()) missingFields.add("Địa chỉ");
        if (declaration.getPhone() == null || declaration.getPhone().isEmpty()) missingFields.add("Điện thoại");
        if (declaration.getPast14Days() == null || declaration.getPast14Days().isEmpty()) missingFields.add("Địa điểm đi qua");

        if (!missingFields.isEmpty()) {
            model.addAttribute("error", "Vui lòng nhập: " + String.join(", ", missingFields));
            model.addAttribute("declarations", declarations);
            return "form";
        }

        declarations.add(declaration);
        model.addAttribute("success", "Gửi tờ khai thành công!");
        model.addAttribute("declaration", new MedicalDeclaration());
        model.addAttribute("declarations", declarations);
        return "form";
    }

    @GetMapping("/edit/{index}")
    public String editForm(@PathVariable int index, Model model) {
        model.addAttribute("declaration", declarations.get(index));
        model.addAttribute("editIndex", index);
        model.addAttribute("declarations", declarations);
        return "form";
    }

    @PostMapping("/update/{index}")
    public String updateForm(@PathVariable int index, @ModelAttribute("declaration") MedicalDeclaration declaration, Model model) {
        declarations.set(index, declaration);
        model.addAttribute("success", "Cập nhật tờ khai thành công!");
        model.addAttribute("declaration", new MedicalDeclaration()); // reset
        model.addAttribute("declarations", declarations);
        return "form";
    }
}
