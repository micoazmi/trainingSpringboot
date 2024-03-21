package com.example.ptmob.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.ptmob.Response;
import com.example.ptmob.Services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public Response all() {
        return new Response(HttpStatus.OK, "Succes get all author", authorService.list());
    }

}
