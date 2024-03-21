package com.example.ptmob.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.ptmob.Response;
import com.example.ptmob.Models.Author;
import com.example.ptmob.Services.AuthorService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public Response all() {
        return new Response(HttpStatus.OK, "Succes get all author", authorService.list());
    }

    @PostMapping("")
    public Response create(@Valid @RequestBody Author author) {
        authorService.create(author);
        return new Response(HttpStatus.CREATED, "berhasil create author", author);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @Valid @RequestBody Author author) {
        authorService.update(id, author);
        return new Response(HttpStatus.OK, "Berhasil update", author);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        authorService.delete(id);
        return new Response(HttpStatus.OK, "Berhasil delete", null);
    }

}
