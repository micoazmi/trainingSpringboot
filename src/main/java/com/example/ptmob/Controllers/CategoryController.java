package com.example.ptmob.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ptmob.Response;
import com.example.ptmob.Models.Category;
import com.example.ptmob.Services.CategoryService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public Response all() {
        return new Response(HttpStatus.OK, "berhasil get all category", categoryService.list());
    }

    @PostMapping("")
    public Response create(@Valid @RequestBody Category category) {
        categoryService.create(category);
        return new Response(HttpStatus.CREATED, "berhasil create category", category);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody Category category) {
        // TODO: process PUT request
        categoryService.update(id, category);
        return new Response(HttpStatus.OK, "Berhasil update category", category);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        categoryService.delete(id);
        return new Response(HttpStatus.OK, "deleted category", null);
    }

}
