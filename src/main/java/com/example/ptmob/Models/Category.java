package com.example.ptmob.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "description is required")
    private String description;

}
