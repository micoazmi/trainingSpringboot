package com.example.ptmob.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.ptmob.Models.Category;
import com.example.ptmob.Repositorys.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> list() {
        return categoryRepository.findAll();
    }

    public void create(Category category) {
        categoryRepository.save(category);
    }

    public void update(Long id, Category category) {
        categoryRepository.findById(id).ifPresent(item -> {
            item.setName(category.getName());
            item.setDescription(category.getDescription());
        });
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
