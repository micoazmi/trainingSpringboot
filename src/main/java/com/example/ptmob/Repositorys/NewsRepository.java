package com.example.ptmob.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ptmob.Models.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}