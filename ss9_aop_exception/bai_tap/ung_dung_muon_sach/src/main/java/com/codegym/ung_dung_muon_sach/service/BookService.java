package com.codegym.ung_dung_muon_sach.service.impl;

import com.codegym.ung_dung_muon_sach.model.Book;
import com.codegym.ung_dung_muon_sach.repository.BookRepository;
import com.codegym.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void decreaseQuantity(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
    }

    @Override
    public void increaseQuantity(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }
}
