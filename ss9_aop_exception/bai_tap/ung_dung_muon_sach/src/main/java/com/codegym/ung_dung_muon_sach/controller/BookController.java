package com.codegym.ung_dung_muon_sach.controller;

import com.codegym.ung_dung_muon_sach.exception.BookUnavailableException;
import com.codegym.ung_dung_muon_sach.exception.InvalidBorrowCodeException;
import com.codegym.ung_dung_muon_sach.model.Book;
import com.codegym.ung_dung_muon_sach.model.BorrowCode;
import com.codegym.ung_dung_muon_sach.service.IBookService;
import com.codegym.ung_dung_muon_sach.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowCodeService borrowCodeService;

    @GetMapping
    public String showBookList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "list";
    }

    @GetMapping("/borrow/{id}")
    public String showBorrowForm(@PathVariable Long id, Model model) {
        Optional<Book> bookOpt = bookService.findById(id);
        if (bookOpt.isPresent()) {
            model.addAttribute("book", bookOpt.get());
            return "borrow";
        }
        return "error";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long id, Model model) {
        Optional<Book> bookOpt = bookService.findById(id);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (book.getQuantity() == 0) {
                throw new BookUnavailableException("Sách đã hết, không thể mượn.");
            }

            bookService.decreaseQuantity(book);
            BorrowCode borrowCode = borrowCodeService.createBorrowCode(book);
            model.addAttribute("borrowCode", borrowCode.getCode());
            return "borrow_success";
        }
        return "error";
    }

    @GetMapping("/return")
    public String showReturnForm() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code, Model model) {
        Optional<BorrowCode> codeOpt = borrowCodeService.findByCode(code);
        if (codeOpt.isPresent()) {
            BorrowCode borrowCode = codeOpt.get();
            Book book = borrowCode.getBook();

            bookService.increaseQuantity(book);
            borrowCodeService.delete(borrowCode);
            model.addAttribute("title", book.getTitle());
            return "return_success";
        }

        throw new InvalidBorrowCodeException("Mã mượn không hợp lệ!");
    }
}
