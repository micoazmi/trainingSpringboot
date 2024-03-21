package com.example.ptmob.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ptmob.Models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
