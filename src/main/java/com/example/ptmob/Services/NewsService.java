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

        public List<News> search(String keyword) {
                return newsRepository.findByTitleContainingIgnoreCase(keyword);
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
                news.setIsPublished(dto.getIsPublished());
                return newsRepository.save(news);

        }

        public News update(Long id, NewsDto dto) throws NotFoundExceptionClass {
                News news = newsRepository
                                .findById(id)
                                .orElseThrow(() -> new NotFoundExceptionClass("News not found"));
                Category category = categoryRepository
                                .findById(dto.getCategoryId())
                                .orElseThrow(() -> new NotFoundExceptionClass("Category Not found"));
                Author author = authorRepository
                                .findById(dto.getAuthorId())
                                .orElseThrow(() -> new NotFoundExceptionClass("Author Not Found"));

                news.setTitle(dto.getTitle());
                news.setContent(dto.getContent());
                news.setAuthor(author);
                news.setCategory(category);
                news.setIsPublished(dto.getIsPublished());
                return newsRepository.save(news);

        }

        public void delete(Long id) throws NotFoundExceptionClass {
                News news = newsRepository
                                .findById(id)
                                .orElseThrow(() -> new NotFoundExceptionClass("News not found"));
                newsRepository.delete(news);
        }

}
