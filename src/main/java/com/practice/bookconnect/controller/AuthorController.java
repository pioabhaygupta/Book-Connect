package com.practice.bookconnect.controller;

import com.practice.bookconnect.model.Author;
import com.practice.bookconnect.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController{
    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author){
       return authorService.addAuthor(author);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAuthor(@RequestParam("id") Long id){
        try{
            Author author = authorService.getAuthor(id);
            return new ResponseEntity<>(author, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeAuthor(@PathVariable Long id){
        try{
            String response=authorService.removeAuthor(id);
            return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get_all")
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }
}
