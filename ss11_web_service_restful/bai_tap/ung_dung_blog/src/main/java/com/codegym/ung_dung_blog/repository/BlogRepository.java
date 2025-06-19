package com.codegym.ung_dung_blog.repository;

import com.codegym.ung_dung_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByTitleContainingIgnoreCase(String keyword);

    List<Blog> findByCategoryId(Long categoryId);
}
