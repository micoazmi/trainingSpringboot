package com.example.ptmob.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ptmob.Response;
import com.example.ptmob.Models.Tag;
import com.example.ptmob.Services.TagService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("")
    public Response all() {
        return new Response(HttpStatus.OK, "berhasil get semua tag", tagService.list());
    }

    @PostMapping("")
    public Response create(@Valid @RequestBody Tag tag) {
        tagService.create(tag);
        return new Response(HttpStatus.CREATED, "berhasil create tag", tag);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody Tag tag) {
        tagService.update(id, tag);
        return new Response(HttpStatus.OK, "berhasil edit tag", tag);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        tagService.delete(id);
        return new Response(HttpStatus.OK, "berhasil delete", null);
    }

}
