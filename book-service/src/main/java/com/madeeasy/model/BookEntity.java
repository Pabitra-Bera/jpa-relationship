package com.madeeasy.model;

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
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_sequence_gen")
    @SequenceGenerator(name = "book_sequence_gen", sequenceName = "book_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "author",nullable = false)
    private String author;
    @Column(name = "isbn", nullable = false)
    private String isbn;
    @Column(name = "publisher", nullable = false)
    private String publisher;
    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;
    @Column(name = "description")
    private String description;
    @Column(name = "price",nullable = false)
    private Double price;
    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "category_id"))
    @Valid
    private List<CategoryEntity> categorieEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @Valid
    private AuthorEntity authorEntity;


}
