package com.codegym.ung_dung_blog.service;

import com.codegym.ung_dung_blog.model.Blog;
import com.codegym.ung_dung_blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> searchByTitle(String keyword) {
        return blogRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Blog> findByCategoryId(Long categoryId) {
        return blogRepository.findByCategoryId(categoryId);
    }
}
