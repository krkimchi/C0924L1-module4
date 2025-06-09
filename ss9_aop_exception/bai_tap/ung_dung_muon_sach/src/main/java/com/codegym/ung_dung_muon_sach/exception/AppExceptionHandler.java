package com.codegym.ung_dung_muon_sach.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(BookUnavailableException.class)
    public String handleBookUnavailable(BookUnavailableException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(InvalidBorrowCodeException.class)
    public String handleInvalidCode(InvalidBorrowCodeException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleOther(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Lỗi không xác định: " + ex.getMessage());
        return "error";
    }
}
