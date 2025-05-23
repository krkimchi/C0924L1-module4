package com.codegym.may_tinh_ca_nhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam double number1,
                            @RequestParam double number2,
                            @RequestParam String operator,
                            Model model) {

        double result = 0;
        String message = "";

        switch (operator) {
            case "+":
                result = number1 + number2;
                message = "Addition";
                break;
            case "-":
                result = number1 - number2;
                message = "Subtraction";
                break;
            case "*":
                result = number1 * number2;
                message = "Multiplication";
                break;
            case "/":
                if (number2 == 0) {
                    message = "Error: Division by zero!";
                    model.addAttribute("error", message);
                    return "index";
                }
                result = number1 / number2;
                message = "Division";
                break;
        }

        model.addAttribute("result", result);
        model.addAttribute("message", message);
        return "index";
    }
}
