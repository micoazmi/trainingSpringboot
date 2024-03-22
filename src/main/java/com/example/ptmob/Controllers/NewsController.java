package com.example.ptmob.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ptmob.NotFoundExceptionClass;
import com.example.ptmob.Response;
import com.example.ptmob.Models.News;
import com.example.ptmob.Models.Dto.NewsDto;
import com.example.ptmob.Services.NewsService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("")
    public Response getAll(@RequestParam(value = "search", required = false) String keyword) {
        if (keyword != null) {
            return new Response(HttpStatus.OK, "berhasil search", newsService.search(keyword));
        } else {
            return new Response(HttpStatus.OK, "getAll News", newsService.list());
        }
    }

    @PostMapping("")
    public Response create(@Valid @RequestBody NewsDto dto) throws NotFoundExceptionClass {
        News news = newsService.create(dto);
        return new Response(HttpStatus.OK, "berhasil create news", news);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @Valid @RequestBody NewsDto dto) throws NotFoundExceptionClass {
        News news = newsService.update(id, dto);
        return new Response(HttpStatus.OK, "sukses edit", news);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) throws NotFoundExceptionClass {
        newsService.delete(id);
        return new Response(HttpStatus.OK, "deleted", null);
    }

}
