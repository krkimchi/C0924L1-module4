package com.codegym.ung_dung_blog.service;

import com.codegym.ung_dung_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    void delete(Long id);
}
