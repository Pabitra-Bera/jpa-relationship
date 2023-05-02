package com.madeeasy.request;

import com.madeeasy.model.AuthorEntity;
import com.madeeasy.model.CategoryEntity;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BookRequest {

    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private String description;
    private Double price;
    private Integer quantity;
    private List<CategoryEntity> categorieEntity;
    private AuthorEntity authorEntity;

}
