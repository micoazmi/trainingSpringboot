package com.example.ptmob.Models.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewsDto {
    private Long id;

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "content is required")
    private String content;

    @JsonAlias("category_id")
    @NotNull(message = "categoryId is required")
    private Long categoryId;

    @JsonAlias("author_id")
    @NotNull(message = "authorId is required")
    private Long authorId;

    @JsonAlias("is_published")
    @NotNull(message = "is_published is required")
    private Boolean isPublished;

}
