package com.codegym.ung_dung_blog.service;

import com.codegym.ung_dung_blog.model.Blog;
import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void delete(Long id);
}
