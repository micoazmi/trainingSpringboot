package com.example.ptmob.Repositorys;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ptmob.Models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}