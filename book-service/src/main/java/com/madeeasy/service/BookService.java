package com.madeeasy.service;

import com.madeeasy.model.BookEntity;
import com.madeeasy.model.CategoryEntity;
import com.madeeasy.request.BookRequest;

import java.util.List;


public interface BookService {
    List<BookEntity> getAllBooks();

    BookEntity getBookById(Long id);

    BookEntity addBook(BookEntity bookEntity);

    void deleteBookById(Long id);

    List<BookEntity> searchBooksByTitle(String title);

    List<BookEntity> getBooksByAuthor(Long authorId);

    List<BookEntity> getBooksByCategory(Long categoryId);

    List<BookEntity> getTopSellingBooks();

    BookEntity updateBookById(Long id, BookRequest bookRequest);

    void addCategoryToBook(Long bookId, Long categoryId);

    void removeCategoryFromBook(Long bookId, Long categoryId);
    CategoryEntity getCategoryById(Long categoryId);
}
