package com.madeeasy.service.impl;


import com.madeeasy.error.ResourceAlreadyExistsException;
import com.madeeasy.error.ResourceNotFoundException;
import com.madeeasy.model.AuthorEntity;
import com.madeeasy.model.BookEntity;
import com.madeeasy.model.CategoryEntity;
import com.madeeasy.repository.AuthorRepository;
import com.madeeasy.repository.BookRepository;
import com.madeeasy.repository.CategoryRepository;
import com.madeeasy.request.BookRequest;
import com.madeeasy.service.BookService;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AuthorEntity authorEntity;

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity getBookById(Long id) {
        Optional<BookEntity> findById = bookRepository.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        } else {
            throw new ResourceNotFoundException("Not Found :(");
        }
    }

    @Override
    public BookEntity addBook(BookEntity bookEntity) {
        authorRepository.save(bookEntity.getAuthorEntity());
        List<CategoryEntity> categorieEntityList = bookEntity.getCategorieEntity();
        for (CategoryEntity categoryEntity : categorieEntityList) {
            categoryRepository.save(categoryEntity);
        }
        return bookRepository.save(bookEntity);
    }

    @Override
    public void deleteBookById(Long id) {
        Optional<BookEntity> findById = bookRepository.findById(id);
        if (findById.isPresent()) {
            BookEntity bookEntity = findById.get();
            bookRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Not Found :(");
        }
    }

    @Override
    public List<BookEntity> searchBooksByTitle(String title) {
        return null;
    }

    @Override
    public List<BookEntity> getBooksByAuthor(Long authorId) {
        return null;
    }

    @Override
    public List<BookEntity> getBooksByCategory(Long categoryId) {
        return null;
    }

    @Override
    public List<BookEntity> getTopSellingBooks() {
        return null;
    }

    @Override
    public BookEntity updateBookById(Long id, BookRequest bookRequest) {
        Optional<BookEntity> findById = bookRepository.findById(id);
        if (findById.isPresent()) {

            BookEntity bookEntity = findById.get();

            if (bookRequest.getAuthor() != null) {
                bookEntity.setAuthor(bookRequest.getAuthor());
            }
            if (bookRequest.getAuthorEntity() != null) {
                bookEntity.setAuthorEntity(bookRequest.getAuthorEntity());
            }
            if (bookRequest.getCategorieEntity() != null) {
                bookEntity.setCategorieEntity(bookRequest.getCategorieEntity());
            }
            if (bookRequest.getDescription() != null) {
                bookEntity.setDescription(bookRequest.getDescription());
            }
            if (bookRequest.getIsbn() != null) {
                bookEntity.setIsbn(bookRequest.getIsbn());
            }
            if (bookRequest.getPrice() != null) {
                bookEntity.setPrice(bookRequest.getPrice());
            }
            if (bookRequest.getPublicationDate() != null) {
                bookEntity.setPublicationDate(bookRequest.getPublicationDate());
            }
            if (bookRequest.getPublisher() != null) {
                bookEntity.setPublisher(bookRequest.getPublisher());
            }
            if (bookRequest.getQuantity() != null) {
                bookEntity.setQuantity(bookRequest.getQuantity());
            }
            if (bookRequest.getTitle() != null) {
                bookEntity.setTitle(bookRequest.getTitle());
            }
            authorRepository.save(bookEntity.getAuthorEntity());
            List<CategoryEntity> categoryEntityList = bookEntity.getCategorieEntity();
            for (CategoryEntity categoryEntity : categoryEntityList) {
                    categoryRepository.save(categoryEntity);
            }
            return bookRepository.save(bookEntity);
        } else {
            throw new ResourceNotFoundException("Not found :(");
        }
    }

    @Override
    public void addCategoryToBook(Long bookId, Long categoryId) {

    }

    @Override
    public void removeCategoryFromBook(Long bookId, Long categoryId) {

    }

    @Override
    public CategoryEntity getCategoryById(Long categoryId) {
        return null;
    }
}
