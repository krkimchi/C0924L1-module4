package com.codegym.tu_dien_don_gian.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
        dictionary.put("student", "học sinh");
        dictionary.put("teacher", "giáo viên");
    }

    public String translate(String word) {
        return dictionary.getOrDefault(word.toLowerCase(), "Không tìm thấy từ");
    }
}
