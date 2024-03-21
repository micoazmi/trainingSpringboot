package com.example.ptmob.Models.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewsDto {
    private Long id;

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "content is required")
    private String content;

    @NotBlank(message = "categoryId is required")
    private Long categoryId;

    @NotBlank(message = "authorId is required")
    private Long authorId;

    @NotBlank(message = "is_published is required")
    private Boolean is_published;

}
