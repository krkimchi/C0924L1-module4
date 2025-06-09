package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.model.Book;
import com.codegym.ung_dung_muon_sach.model.BorrowCode;

import java.util.Optional;

public interface IBorrowCodeService {
    BorrowCode createBorrowCode(Book book);
    Optional<BorrowCode> findByCode(String code);
    void delete(BorrowCode code);
}
