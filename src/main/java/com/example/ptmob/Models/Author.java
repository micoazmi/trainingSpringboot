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
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "fullname is required")
    private String fullname;

    @NotBlank(message = "email is required")
    private String email;

}
