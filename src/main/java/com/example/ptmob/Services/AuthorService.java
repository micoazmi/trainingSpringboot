package com.example.ptmob.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ptmob.Models.Author;
import com.example.ptmob.Repositorys.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> list() {
        return authorRepository.findAll();
    }

    public void create(Author author) {
        authorRepository.save(author);
    }

    public void update(Long id, Author author) {
        authorRepository.findById(id).ifPresent(item -> {
            item.setFullname(author.getFullname());
            item.setEmail(author.getEmail());
            authorRepository.save(item);
        });
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

}