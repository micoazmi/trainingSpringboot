package com.example.ptmob.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ptmob.Models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
