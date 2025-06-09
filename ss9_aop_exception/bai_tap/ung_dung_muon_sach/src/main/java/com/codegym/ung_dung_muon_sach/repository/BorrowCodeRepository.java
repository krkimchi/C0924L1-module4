package com.codegym.ung_dung_muon_sach.repository;

import com.codegym.ung_dung_muon_sach.model.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowCodeRepository extends JpaRepository<BorrowCode, Long> {
    Optional<BorrowCode> findByCode(String code);
}
