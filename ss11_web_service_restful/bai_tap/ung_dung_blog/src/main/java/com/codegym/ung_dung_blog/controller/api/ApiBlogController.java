package com.codegym.ung_dung_blog.controller.api;

import com.codegym.ung_dung_blog.model.Blog;
import com.codegym.ung_dung_blog.model.Category;
import com.codegym.ung_dung_blog.service.IBlogService;
import com.codegym.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin("*")
public class ApiBlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        return blogService.findById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Blog> getBlogsByCategory(@PathVariable Long categoryId) {
        return blogService.findByCategoryId(categoryId);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }
}
