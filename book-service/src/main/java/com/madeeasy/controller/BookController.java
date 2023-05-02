package com.madeeasy.controller;

import com.madeeasy.model.BookEntity;
import com.madeeasy.request.BookRequest;
import com.madeeasy.service.impl.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
@Validated
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<BookEntity> saveBook(@Valid @RequestBody BookEntity bookEntity) {
        BookEntity book = bookServiceImpl.addBook(bookEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/all-books")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        try {
            List<BookEntity> allBooks = bookServiceImpl.getAllBooks();
            return ResponseEntity.status(HttpStatus.OK).body(allBooks);
        } catch (Exception ex) {
            throw new RuntimeException("Error while saving the book: " + ex.getMessage(), ex);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable("id") Long id){
        BookEntity bookById = bookServiceImpl.getBookById(id);
        return ResponseEntity.ok().body(bookById);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable("id") Long id){
        bookServiceImpl.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted Successfully");
    }
    @PatchMapping(value = "/{id}")
    public ResponseEntity<BookEntity> updateBookById(@PathVariable("id") Long id ,
                                                     @RequestBody BookRequest bookRequest){
        BookEntity bookEntityUpdated = bookServiceImpl.updateBookById(id, bookRequest);
        return ResponseEntity.status(HttpStatus.OK).body(bookEntityUpdated);
    }
}
