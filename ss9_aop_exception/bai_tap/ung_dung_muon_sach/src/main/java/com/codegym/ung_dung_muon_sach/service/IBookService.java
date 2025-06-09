package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    void decreaseQuantity(Book book);
    void increaseQuantity(Book book);
}
