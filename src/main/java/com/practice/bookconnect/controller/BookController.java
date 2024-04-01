package com.practice.bookconnect.controller;

import com.practice.bookconnect.exception.AuthorNotFoundException;
import com.practice.bookconnect.exception.BookNotFoundException;
import com.practice.bookconnect.model.Book;
import com.practice.bookconnect.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController{
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestParam("id") Long id, @RequestBody Book book){
        try{
            Book book1=bookService.addBook(id,book);
            return new ResponseEntity<>(book1, HttpStatus.ACCEPTED);
        } catch (AuthorNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id){
        try{
            Book book=bookService.getBook(id);
            return new ResponseEntity<>(book,HttpStatus.OK);
        }catch (BookNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping("/update")
//    public ResponseEntity<?> updateBook(@PathVariable Long id,@RequestBody Book book){
//
//    }

}
