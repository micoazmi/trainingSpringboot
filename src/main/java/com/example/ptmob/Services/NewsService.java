package com.example.ptmob.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ptmob.NotFoundExceptionClass;
import com.example.ptmob.Models.Author;
import com.example.ptmob.Models.Category;
import com.example.ptmob.Models.News;
import com.example.ptmob.Models.Dto.NewsDto;
import com.example.ptmob.Repositorys.AuthorRepository;
import com.example.ptmob.Repositorys.CategoryRepository;
import com.example.ptmob.Repositorys.NewsRepository;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<News> list() {
        return newsRepository.findAll();
    }

    public News create(NewsDto dto) throws NotFoundExceptionClass {
        Category category = categoryRepository
                .findById(dto.getCategoryId())
                .orElseThrow(() -> new NotFoundExceptionClass("Category Not found"));
        Author author = authorRepository
                .findById(dto.getAuthorId())
                .orElseThrow(() -> new NotFoundExceptionClass("Author Not Found"));

        News news = new News();
        news.setTitle(dto.getTitle());
        news.setContent(dto.getContent());
        news.setAuthor(author);
        news.setCategory(category);
        news.setIsPublished(dto.getIs_published());
        return newsRepository.save(news);

    }

}
