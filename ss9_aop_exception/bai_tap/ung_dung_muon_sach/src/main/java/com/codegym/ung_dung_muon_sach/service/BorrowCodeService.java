package com.codegym.ung_dung_muon_sach.service.impl;

import com.codegym.ung_dung_muon_sach.model.Book;
import com.codegym.ung_dung_muon_sach.model.BorrowCode;
import com.codegym.ung_dung_muon_sach.repository.BorrowCodeRepository;
import com.codegym.ung_dung_muon_sach.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class BorrowCodeService implements IBorrowCodeService {

    @Autowired
    private BorrowCodeRepository borrowCodeRepository;

    private final Random random = new Random();

    @Override
    public BorrowCode createBorrowCode(Book book) {
        String code = String.format("%05d", random.nextInt(100000));
        BorrowCode borrowCode = new BorrowCode();
        borrowCode.setCode(code);
        borrowCode.setBook(book);
        return borrowCodeRepository.save(borrowCode);
    }

    @Override
    public Optional<BorrowCode> findByCode(String code) {
        return borrowCodeRepository.findByCode(code);
    }

    @Override
    public void delete(BorrowCode code) {
        borrowCodeRepository.delete(code);
    }
}
