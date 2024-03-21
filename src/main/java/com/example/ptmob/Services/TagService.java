package com.example.ptmob.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ptmob.Models.Tag;
import com.example.ptmob.Repositorys.TagRepository;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> list() {
        return tagRepository.findAll();
    }

    public void create(Tag tag) {
        tagRepository.save(tag);
    }

    public void update(Long id, Tag tag) {
        tagRepository.findById(id).ifPresent(item -> {
            item.setName(tag.getName());
            tagRepository.save(item);
        });
    }

    public void delete(Long id) {
        tagRepository.deleteById(id);
    }

}
